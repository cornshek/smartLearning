(function ($) {
    $.fn.jquizzy = function (settings) {

        var defaults = {
            questions: null,
            startImg: 'images/answer/start.gif',
            endText: '已结束!',
            shortURL: null,
            sendResultsURL: null,
            resultComments: {
                perfect: '你是爱因斯坦么?',
                excellent: '非常优秀!',
                good: '很好，发挥不错!',
                average: '一般般了。',
                bad: '太可怜了！',
                poor: '好可怕啊！',
                worst: '悲痛欲绝！'
            }
        };

        var config = $.extend(defaults, settings);

        if (config.questions === null) {
            $(this).html('<div class="intro-container slide-container"><h2 class="qTitle">Failed to parse questions.</h2></div>');
            return;
        }

        var superContainer = $(this),
            answers = [],
            introFob = '<div class="intro-container slide-container"><a class="nav-start" href="#">集中精神！<br/><br/><span><img src="' + config.startImg + '" alt=""></span></a></div>	',
            exitFob = '<div class="results-container slide-container"><div class="question-number">' + config.endText + '</div><div class="result-keeper"></div></div><div class="notice">请选择一个选项！</div><div class="progress-keeper" ><div class="progress"></div></div>',
            contentFob = '',
            questionsIteratorIndex,
            answersIteratorIndex;

        superContainer.addClass('main-quiz-holder');

        for (questionsIteratorIndex = 0; questionsIteratorIndex < config.questions.length; questionsIteratorIndex++) {
            contentFob += '<div class="slide-container"><div class="question-number">' + (questionsIteratorIndex + 1) + '/' + config.questions.length + '</div><div class="question">' + config.questions[questionsIteratorIndex].question + '</div><ul class="answers">';
            for (answersIteratorIndex = 0; answersIteratorIndex < config.questions[questionsIteratorIndex].answers.length; answersIteratorIndex++) {
                contentFob += '<li>' + config.questions[questionsIteratorIndex].answers[answersIteratorIndex] + '</li>';
            }
            contentFob += '</ul><div class="nav-container">';
            if (questionsIteratorIndex !== 0) {
                contentFob += '<div class="prev"><a class="nav-previous" href="#">&lt; 上一题</a></div>';
            }
            if (questionsIteratorIndex < config.questions.length - 1) {
                contentFob += '<div class="next"><a class="nav-next" href="#">下一题 &gt;</a></div>';
            } else {
                contentFob += '<div class="next final"><a class="nav-show-result" href="#">完成</a></div>';
            }
            contentFob += '</div></div>';
            answers.push(config.questions[questionsIteratorIndex].correctAnswer);
        }

        superContainer.html(introFob + contentFob + exitFob);

        var progress = superContainer.find('.progress'),
            progressKeeper = superContainer.find('.progress-keeper'),
            notice = superContainer.find('.notice'),
            progressWidth = progressKeeper.width(),
            userAnswers = [],
            questionLength = config.questions.length,
            slidesList = superContainer.find('.slide-container');

        //核对答案
        function checkAnswers() {
            var resultArr = [],
                flag = false;
            for (i = 0; i < answers.length; i++) {
                flag = answers[i] === userAnswers[i];
                resultArr.push(flag);
            }
            return resultArr;
        }

        //计算分数
        //看不懂
        function roundReloaded(num, dec) {
            return Math.round(num * Math.pow(10, dec)) / Math.pow(10, dec);
        }

        function judgeSkills(score) {
            var returnString;
            if (score === 100) return config.resultComments.perfect;
            else if (score > 90) return config.resultComments.excellent;
            else if (score > 70) return config.resultComments.good;
            else if (score > 50) return config.resultComments.average;
            else if (score > 35) return config.resultComments.bad;
            else if (score > 20) return config.resultComments.poor;
            else return config.resultComments.worst;
        }

        progressKeeper.hide();
        notice.hide();
        slidesList.hide().first().fadeIn(500);

        //监听li -- 答案列表
        //点击答案时发生样式变化
        //点击了已经选中的答案 --> 样式变回默认
        //点击了未选中的答案 --> 样式变化为“已选中”，其他答案样式变化为默认
        superContainer.find('li').click(function () {
            var thisLi = $(this);
            if (thisLi.hasClass('selected')) {
                thisLi.removeClass('selected');
            } else {
                thisLi.parents('.answers').children('li').removeClass('selected');
                thisLi.addClass('selected');
            }
        });

        //监听超链接 "nav-start" -- 开始答题
        superContainer.find('.nav-start').click(function () {
            $(this).parents('.slide-container').fadeOut(500,
                function () {
                    $(this).next().fadeIn(500);
                    progressKeeper.fadeIn(500);
                });
            return false;
        });


        //监听超链接 ".next" -- 下一题
        superContainer.find('.next').click(function () {

            //当没有任何一个答案被选中时(selected) --> notice淡入
            //否则不显示notice
            if ($(this).parents('.slide-container').find('li.selected').length === 0) {
                notice.fadeIn(300);
                return false;
            }
            notice.hide();

            //淡入到下一题
            $(this).parents('.slide-container').fadeOut(500,
                function () {
                    $(this).next().fadeIn(500);
                });

            //进度条动画
            //增长
            progress.animate({
                    width: progress.width() + Math.round(progressWidth / questionLength)
                },
                500);

            //防止跳转
            return false;
        });

        //监听超链接 ".prev" -- 上一题
        //淡入上一题
        //进度条缩短动画
        superContainer.find('.prev').click(function () {
            notice.hide();
            $(this).parents('.slide-container').fadeOut(500,
                function () {
                    $(this).prev().fadeIn(500);
                });
            progress.animate({
                    width: progress.width() - Math.round(progressWidth / questionLength)
                },
                500);
            return false;
        });

        //监听超链接 ".final" -- 完成答题
        superContainer.find('.final').click(function () {

            //当没有任何一个答案被选中时(selected) --> notice淡入
            //否则不显示notice
            if ($(this).parents('.slide-container').find('li.selected').length === 0) {
                notice.fadeIn(300);
                return false;
            }

            //遍历 "li.selected" -- 选中的答案
            //将选中的答案位于列表中的次序push到userAnswers中
            superContainer.find('li.selected').each(function (index) {
                userAnswers.push($(this).parents('.answers').children('li').index($(this).parents('.answers').find('li.selected')) + 1);
            });

            //看不懂
            /*if (config.sendResultsURL !== null) {
                var collate = [];
                for (r = 0; r < userAnswers.length; r++) {
                    collate.push('{"questionNumber":"' + parseInt(r + 1, 10) + '", "userAnswer":"' + userAnswers[r] + '"}');
                }
                $.ajax({
                    type: 'POST',
                    url: config.sendResultsURL,
                    data: '{"answers": [' + collate.join(",") + ']}',
                    complete: function() {
                        console.log("OH HAI");
                    }
                });
            }*/

            progressKeeper.hide();
            var results = checkAnswers(),
                resultSet = '',
                trueCount = 0,
                shareButton = '',
                score,
                url;

            if (config.shortURL === null) {
                config.shortURL = window.location
            }

            for (var i = 0, toLoopTill = results.length; i < toLoopTill; i++) {

                //计算答对的数量
                if (results[i] === true) {
                    trueCount++;
                    isCorrect = true;
                }

                //根据results是否为true，设置class为correct或wrong
                resultSet += '<div class="result-row">' + (results[i] === true ? "<div class='correct'>#" + (i + 1) + "<span></span></div>" : "<div class='wrong'>#" + (i + 1) + "<span></span></div>");
                resultSet += '<div class="resultsview-qhover">' + config.questions[i].question;
                resultSet += "<ul>";
                for (answersIteratorIndex = 0; answersIteratorIndex < config.questions[i].answers.length; answersIteratorIndex++) {
                    var classestoAdd = '';
                    //为悬浮选项列表设置right和selected
                    if (config.questions[i].correctAnswer === answersIteratorIndex + 1) {
                        classestoAdd += 'right';
                    }
                    if (userAnswers[i] === answersIteratorIndex + 1) {
                        classestoAdd += ' selected';
                    }
                    resultSet += '<li class="' + classestoAdd + '">' + config.questions[i].answers[answersIteratorIndex] + '</li>';
                }
                resultSet += '</ul></div></div>';
            }

            score = roundReloaded(trueCount / questionLength * 100, 2);

            resultSet = '<h2 class="qTitle">' + judgeSkills(score) + '<br/> 您的分数： ' + score + '</h2>' + shareButton + '<div class="jquizzy-clear"></div>' + resultSet + '<div class="jquizzy-clear"></div>';
            superContainer.find('.result-keeper').html(resultSet).show(500);
            superContainer.find('.resultsview-qhover').hide();

            //监听.result-row的鼠标悬停
            superContainer.find('.result-row').hover(function () {
                    $(this).find('.resultsview-qhover').show();
                },
                function () {
                    $(this).find('.resultsview-qhover').hide();
                });

            //不明所以
            $(this).parents('.slide-container').fadeOut(500,
                function () {
                    $(this).next().fadeIn(500);
                });

            /*显示3个按钮*/
            var again = $("#again");
            for (var i = 0; i < again.length; i++){
                again[i].style.display = "inline";
            }

            /*将results传递到jsp页面*/
            $("#results").attr("value", results);
            $("#results").trigger("input");

            return false;

        });
    };
})(jQuery);
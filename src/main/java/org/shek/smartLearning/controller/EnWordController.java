package org.shek.smartLearning.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.shek.smartLearning.pojo.EnWord;
import org.shek.smartLearning.service.EnWordService;
import org.shek.smartLearning.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("")
public class EnWordController {
    @Autowired
    EnWordService enWordService;

    @RequestMapping("check")
    public String list(Model model, Page page) {
//        PageHelper.offsetPage(page.getStart(), page.getCount());

        List<EnWord> enWordList = enWordService.listRandom(5);

        int total = (int) new PageInfo<>(enWordList).getTotal();
        page.setTotal(total);
        model.addAttribute("page", page);

        model.addAttribute("enWordList", enWordList);

        return "listWords";
    }
}

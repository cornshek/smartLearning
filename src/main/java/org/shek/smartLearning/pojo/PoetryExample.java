package org.shek.smartLearning.pojo;

import java.util.ArrayList;
import java.util.List;

public class PoetryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PoetryExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andBlankIsNull() {
            addCriterion("blank is null");
            return (Criteria) this;
        }

        public Criteria andBlankIsNotNull() {
            addCriterion("blank is not null");
            return (Criteria) this;
        }

        public Criteria andBlankEqualTo(String value) {
            addCriterion("blank =", value, "blank");
            return (Criteria) this;
        }

        public Criteria andBlankNotEqualTo(String value) {
            addCriterion("blank <>", value, "blank");
            return (Criteria) this;
        }

        public Criteria andBlankGreaterThan(String value) {
            addCriterion("blank >", value, "blank");
            return (Criteria) this;
        }

        public Criteria andBlankGreaterThanOrEqualTo(String value) {
            addCriterion("blank >=", value, "blank");
            return (Criteria) this;
        }

        public Criteria andBlankLessThan(String value) {
            addCriterion("blank <", value, "blank");
            return (Criteria) this;
        }

        public Criteria andBlankLessThanOrEqualTo(String value) {
            addCriterion("blank <=", value, "blank");
            return (Criteria) this;
        }

        public Criteria andBlankLike(String value) {
            addCriterion("blank like", value, "blank");
            return (Criteria) this;
        }

        public Criteria andBlankNotLike(String value) {
            addCriterion("blank not like", value, "blank");
            return (Criteria) this;
        }

        public Criteria andBlankIn(List<String> values) {
            addCriterion("blank in", values, "blank");
            return (Criteria) this;
        }

        public Criteria andBlankNotIn(List<String> values) {
            addCriterion("blank not in", values, "blank");
            return (Criteria) this;
        }

        public Criteria andBlankBetween(String value1, String value2) {
            addCriterion("blank between", value1, value2, "blank");
            return (Criteria) this;
        }

        public Criteria andBlankNotBetween(String value1, String value2) {
            addCriterion("blank not between", value1, value2, "blank");
            return (Criteria) this;
        }

        public Criteria andFillIsNull() {
            addCriterion("fill is null");
            return (Criteria) this;
        }

        public Criteria andFillIsNotNull() {
            addCriterion("fill is not null");
            return (Criteria) this;
        }

        public Criteria andFillEqualTo(String value) {
            addCriterion("fill =", value, "fill");
            return (Criteria) this;
        }

        public Criteria andFillNotEqualTo(String value) {
            addCriterion("fill <>", value, "fill");
            return (Criteria) this;
        }

        public Criteria andFillGreaterThan(String value) {
            addCriterion("fill >", value, "fill");
            return (Criteria) this;
        }

        public Criteria andFillGreaterThanOrEqualTo(String value) {
            addCriterion("fill >=", value, "fill");
            return (Criteria) this;
        }

        public Criteria andFillLessThan(String value) {
            addCriterion("fill <", value, "fill");
            return (Criteria) this;
        }

        public Criteria andFillLessThanOrEqualTo(String value) {
            addCriterion("fill <=", value, "fill");
            return (Criteria) this;
        }

        public Criteria andFillLike(String value) {
            addCriterion("fill like", value, "fill");
            return (Criteria) this;
        }

        public Criteria andFillNotLike(String value) {
            addCriterion("fill not like", value, "fill");
            return (Criteria) this;
        }

        public Criteria andFillIn(List<String> values) {
            addCriterion("fill in", values, "fill");
            return (Criteria) this;
        }

        public Criteria andFillNotIn(List<String> values) {
            addCriterion("fill not in", values, "fill");
            return (Criteria) this;
        }

        public Criteria andFillBetween(String value1, String value2) {
            addCriterion("fill between", value1, value2, "fill");
            return (Criteria) this;
        }

        public Criteria andFillNotBetween(String value1, String value2) {
            addCriterion("fill not between", value1, value2, "fill");
            return (Criteria) this;
        }

        public Criteria andConfusion1IsNull() {
            addCriterion("confusion1 is null");
            return (Criteria) this;
        }

        public Criteria andConfusion1IsNotNull() {
            addCriterion("confusion1 is not null");
            return (Criteria) this;
        }

        public Criteria andConfusion1EqualTo(String value) {
            addCriterion("confusion1 =", value, "confusion1");
            return (Criteria) this;
        }

        public Criteria andConfusion1NotEqualTo(String value) {
            addCriterion("confusion1 <>", value, "confusion1");
            return (Criteria) this;
        }

        public Criteria andConfusion1GreaterThan(String value) {
            addCriterion("confusion1 >", value, "confusion1");
            return (Criteria) this;
        }

        public Criteria andConfusion1GreaterThanOrEqualTo(String value) {
            addCriterion("confusion1 >=", value, "confusion1");
            return (Criteria) this;
        }

        public Criteria andConfusion1LessThan(String value) {
            addCriterion("confusion1 <", value, "confusion1");
            return (Criteria) this;
        }

        public Criteria andConfusion1LessThanOrEqualTo(String value) {
            addCriterion("confusion1 <=", value, "confusion1");
            return (Criteria) this;
        }

        public Criteria andConfusion1Like(String value) {
            addCriterion("confusion1 like", value, "confusion1");
            return (Criteria) this;
        }

        public Criteria andConfusion1NotLike(String value) {
            addCriterion("confusion1 not like", value, "confusion1");
            return (Criteria) this;
        }

        public Criteria andConfusion1In(List<String> values) {
            addCriterion("confusion1 in", values, "confusion1");
            return (Criteria) this;
        }

        public Criteria andConfusion1NotIn(List<String> values) {
            addCriterion("confusion1 not in", values, "confusion1");
            return (Criteria) this;
        }

        public Criteria andConfusion1Between(String value1, String value2) {
            addCriterion("confusion1 between", value1, value2, "confusion1");
            return (Criteria) this;
        }

        public Criteria andConfusion1NotBetween(String value1, String value2) {
            addCriterion("confusion1 not between", value1, value2, "confusion1");
            return (Criteria) this;
        }

        public Criteria andConfusion2IsNull() {
            addCriterion("confusion2 is null");
            return (Criteria) this;
        }

        public Criteria andConfusion2IsNotNull() {
            addCriterion("confusion2 is not null");
            return (Criteria) this;
        }

        public Criteria andConfusion2EqualTo(String value) {
            addCriterion("confusion2 =", value, "confusion2");
            return (Criteria) this;
        }

        public Criteria andConfusion2NotEqualTo(String value) {
            addCriterion("confusion2 <>", value, "confusion2");
            return (Criteria) this;
        }

        public Criteria andConfusion2GreaterThan(String value) {
            addCriterion("confusion2 >", value, "confusion2");
            return (Criteria) this;
        }

        public Criteria andConfusion2GreaterThanOrEqualTo(String value) {
            addCriterion("confusion2 >=", value, "confusion2");
            return (Criteria) this;
        }

        public Criteria andConfusion2LessThan(String value) {
            addCriterion("confusion2 <", value, "confusion2");
            return (Criteria) this;
        }

        public Criteria andConfusion2LessThanOrEqualTo(String value) {
            addCriterion("confusion2 <=", value, "confusion2");
            return (Criteria) this;
        }

        public Criteria andConfusion2Like(String value) {
            addCriterion("confusion2 like", value, "confusion2");
            return (Criteria) this;
        }

        public Criteria andConfusion2NotLike(String value) {
            addCriterion("confusion2 not like", value, "confusion2");
            return (Criteria) this;
        }

        public Criteria andConfusion2In(List<String> values) {
            addCriterion("confusion2 in", values, "confusion2");
            return (Criteria) this;
        }

        public Criteria andConfusion2NotIn(List<String> values) {
            addCriterion("confusion2 not in", values, "confusion2");
            return (Criteria) this;
        }

        public Criteria andConfusion2Between(String value1, String value2) {
            addCriterion("confusion2 between", value1, value2, "confusion2");
            return (Criteria) this;
        }

        public Criteria andConfusion2NotBetween(String value1, String value2) {
            addCriterion("confusion2 not between", value1, value2, "confusion2");
            return (Criteria) this;
        }

        public Criteria andConfusion3IsNull() {
            addCriterion("confusion3 is null");
            return (Criteria) this;
        }

        public Criteria andConfusion3IsNotNull() {
            addCriterion("confusion3 is not null");
            return (Criteria) this;
        }

        public Criteria andConfusion3EqualTo(String value) {
            addCriterion("confusion3 =", value, "confusion3");
            return (Criteria) this;
        }

        public Criteria andConfusion3NotEqualTo(String value) {
            addCriterion("confusion3 <>", value, "confusion3");
            return (Criteria) this;
        }

        public Criteria andConfusion3GreaterThan(String value) {
            addCriterion("confusion3 >", value, "confusion3");
            return (Criteria) this;
        }

        public Criteria andConfusion3GreaterThanOrEqualTo(String value) {
            addCriterion("confusion3 >=", value, "confusion3");
            return (Criteria) this;
        }

        public Criteria andConfusion3LessThan(String value) {
            addCriterion("confusion3 <", value, "confusion3");
            return (Criteria) this;
        }

        public Criteria andConfusion3LessThanOrEqualTo(String value) {
            addCriterion("confusion3 <=", value, "confusion3");
            return (Criteria) this;
        }

        public Criteria andConfusion3Like(String value) {
            addCriterion("confusion3 like", value, "confusion3");
            return (Criteria) this;
        }

        public Criteria andConfusion3NotLike(String value) {
            addCriterion("confusion3 not like", value, "confusion3");
            return (Criteria) this;
        }

        public Criteria andConfusion3In(List<String> values) {
            addCriterion("confusion3 in", values, "confusion3");
            return (Criteria) this;
        }

        public Criteria andConfusion3NotIn(List<String> values) {
            addCriterion("confusion3 not in", values, "confusion3");
            return (Criteria) this;
        }

        public Criteria andConfusion3Between(String value1, String value2) {
            addCriterion("confusion3 between", value1, value2, "confusion3");
            return (Criteria) this;
        }

        public Criteria andConfusion3NotBetween(String value1, String value2) {
            addCriterion("confusion3 not between", value1, value2, "confusion3");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
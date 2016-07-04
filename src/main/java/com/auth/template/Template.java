package com.auth.template;



    import java.util.ArrayList;
    import java.util.List;

/**
 * Created by yuxb on 16/5/27.
 */
    public class Template {

        protected String template;
        protected List<TemplateVariable> variables;

        public Template() {
            variables = new ArrayList<>();
        }

        public void setValue(String name, String value) {
            TemplateUtil.setValue(variables, name, value);
        }

        public String getResult() {
            return TemplateUtil.getResult(variables, template);
        }

        public String getTemplate() {
            return this.template;
        }

        public void setTemplate(String template) {
            this.template = template;
        }

}

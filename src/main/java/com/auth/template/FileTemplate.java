package com.auth.template;

/**
 * Created by yuxb on 16/5/27.
 */
public class FileTemplate extends Template {


        public FileTemplate(String fileName) {

            this.template = TemplateUtil.readFile( fileName);
            this.variables = TemplateUtil.getVariables(template);
        }


}

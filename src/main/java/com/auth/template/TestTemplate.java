package com.auth.template;

import java.io.*;

/**
 * Created by yuxb on 16/5/27.
 */
public class TestTemplate {
    public static void main(String[] args) throws IOException {
        FileTemplate ft=new FileTemplate("/Users/yuxb/ideaspace/auth/src/main/resources/template/controllerTemplet.html");
        ft.setValue("requestPath","/role");
        ft.setValue("Model","Role");
        ft.setValue("lowerModel","role");
      // System.out.println (ft.getResult());
        File file=new File("/Users/yuxb/ideaspace/auth/src/main/java/com/auth/controller/RoleController.java");
        file.mkdirs();
        Writer writer=new BufferedWriter(new FileWriter(file)) ;
        writer.write(ft.getResult());
        writer.flush();
        writer.close();

    }
}

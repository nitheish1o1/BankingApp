package com.mypack;

import java.io.File;
import java.io.FileWriter;

public class Generate_log {

    static Generate_log obj;

    private Generate_log(){}

    public static Generate_log getInstance(){
        if(obj == null){
            obj = new Generate_log();
        }
        return obj;
    }
    public void update_log(String log)throws Exception{
        String path = "C:bank_log.txt";
        File file = new File(path);
        if(!file.exists()){
            file.createNewFile();
        }

        FileWriter log_writer = new FileWriter(path,true);
        log_writer.write(log);
        log_writer.close();
    }
}

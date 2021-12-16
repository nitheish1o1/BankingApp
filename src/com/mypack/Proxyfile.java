package com.mypack;

import java.io.*;


class Realfile {
    public static String loadfile() throws IOException {
        String path = "C:bank_log.txt";
        File file = new File(path);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        StringBuilder stringBuilder = new StringBuilder();
        String line = bufferedReader.readLine();
        while (line != null) {
            stringBuilder.append(line);
            stringBuilder.append("\n");
            line = bufferedReader.readLine();
        }
        bufferedReader.close();
        return stringBuilder.toString();
    }
}


public class Proxyfile {
    static String content = null;
    static boolean is_transaction = true;

    public static void getfile() throws IOException {
        if (content == null || is_transaction) {
            System.out.println("Loding file from disc ............");
            content = Realfile.loadfile();
            System.out.println(content);
        } else {
            System.out.println("catch file -->");
            System.out.println(content);
        }
    }
}


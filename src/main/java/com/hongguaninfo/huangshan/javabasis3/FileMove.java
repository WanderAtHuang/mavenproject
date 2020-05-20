package com.hongguaninfo.huangshan.javabasis3;

import java.io.*;

public class FileMove {
    private String oldFile;
    private String newFile;

    public FileMove(String oldFile, String newFile) {
        this.oldFile = oldFile;
        this.newFile = newFile;
    }

    public FileMove() {
    }

    public void fileCopy(String oldFile, String newFile){
        File old = new File(oldFile);
        // 要拷贝到的文件(输出流文件);
        File new1 = new File(newFile);
        // 创建文件输入流
        InputStream is = null;
        // 创建文件输出流
        OutputStream ops = null;
        try {
            is = new FileInputStream(old);
            ops = new FileOutputStream(new1);
            byte[] bt = new byte[1];// 每次读取1KB,缓冲容器
            int len = -1;
            while ((len = is.read(bt)) != -1) {
                ops.write(bt, 0, len);
            }
            ops.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 遵循先打开的后关闭原则
            try {
                if (null != ops) {
                    ops.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (null != is) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}

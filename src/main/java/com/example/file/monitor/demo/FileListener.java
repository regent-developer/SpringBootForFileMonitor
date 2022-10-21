package com.example.file.monitor.demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.text.SimpleDateFormat;

import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.springframework.stereotype.Component;

@Component
public class FileListener extends FileAlterationListenerAdaptor {
	/**
     * 文件创建执行
     */
    @Override
    public void onFileCreate(File file) {
        //System.out.print("[新建]:" + file + "\n");
        //System.out.print("[新建]:" + file.getPath()  + "\n");
    	
    	SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
    	Date date = new Date(System.currentTimeMillis());
    	
        System.out.print(formatter.format(date) + "  [新建文件]:" + file.getAbsolutePath()  + "\n");
    }
 
    /**
     * 文件创建修改
     */
    @Override
    public void onFileChange(File file) {
        System.out.print("[修改文件]:" + file.getAbsolutePath() + "\n");
        //读取文件内容
        BufferedReader buf = null;
        try {
            buf = new BufferedReader(new InputStreamReader(new FileInputStream(file),"GBK"));
            try (BufferedReader br = new BufferedReader(buf)) {
				System.out.println(br.readLine());
			}
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {if (buf != null){buf.close();}}catch (Exception e){}
        }
    }
 
    /**
     * 文件删除
     */
    @Override
    public void onFileDelete(File file) {
        System.out.print("[删除文件]:" + file.getAbsolutePath()  + "\n");
    }
 
    /**
     * 目录创建
     */
    @Override
    public void onDirectoryCreate(File directory) {
        System.out.print("[新建文件夹]:" + directory.getAbsolutePath()  + "\n");
    }
 
    /**
     * 目录修改
     */
    @Override
    public void onDirectoryChange(File directory) {
        System.out.print("[修改文件夹]:" + directory.getAbsolutePath()  + "\n");
    }
 
    /**
     * 目录删除
     */
    @Override
    public void onDirectoryDelete(File directory) {
        System.out.print("[删除文件夹]:" + directory.getAbsolutePath()  + "\n");
    }
 
    @Override
    public void onStart(FileAlterationObserver observer) {
        // TODO Auto-generated method stub
        super.onStart(observer);
    }
 
    @Override
    public void onStop(FileAlterationObserver observer) {
        // TODO Auto-generated method stub
        super.onStop(observer);
    }
}

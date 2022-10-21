package com.example.file.monitor.demo;

import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterFileConfig {
	
	public void FileFilter(String rootDir){
		FileAlterationObserver observer = new FileAlterationObserver(rootDir);
	    observer.addListener(new FileListener());
	    FileAlterationMonitor monitor = new FileAlterationMonitor();
	    monitor.addObserver(observer);
	    try {
	    	System.out.print("文件夹[" + rootDir + "]监听中\n");
	        monitor.start();
	    } catch (Exception e) {
	        System.out.print("init file monitor error");
	    }
	}
}

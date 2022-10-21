package com.example.file.monitor.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application {

	private  static FilterFileConfig filterFileConfig;
	 
    @Autowired
    public void setFilterFileConfig(FilterFileConfig filterFileConfig) {
 
        this.filterFileConfig = filterFileConfig;
    }
    
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
		filterFileConfig.FileFilter("D:\\test");
		filterFileConfig.FileFilter("D:\\test1");
	}

}

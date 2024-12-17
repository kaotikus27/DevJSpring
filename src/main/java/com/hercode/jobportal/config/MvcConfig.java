package com.hercode.jobportal.config;

import java.nio.file.Paths;
import java.nio.file.Path;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer{
	
	private static final String UPLOAD_DIR = "photos";

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		exposeDirectory(UPLOAD_DIR,registry);
	}

	private void exposeDirectory(String uploadDir, ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		Path path = Paths.get(uploadDir);
		//Converts the uploadDir string to a PATH MAPS request staring with "/photos/**"
		//to a file system location file:<absolute path to photos directory>
		//the ** will match on all sub-directories.
		registry.addResourceHandler("/"+uploadDir+"/**")
		.addResourceLocations("file:"+path.toAbsolutePath()+"/");
	}
	
	

}

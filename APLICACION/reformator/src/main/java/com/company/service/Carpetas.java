package com.company.service;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class Carpetas {

	
	public String subirFoto(MultipartFile foto, String usuario,HttpServletRequest request) throws Exception, IllegalStateException, IOException{
		ServletContext servletContext = request.getSession().getServletContext();
		String relativeWebPath = "/";
		String absoluteDiskPath = servletContext.getRealPath(relativeWebPath);
		System.out.println("aqui esta todo joder" + absoluteDiskPath  + "/resources/images/" + usuario);
		File a = new File(absoluteDiskPath  + "/resources/images/" + usuario ); 
		deleteWithChildren(a.getPath()); 
		a.mkdir();
		a = new File(absoluteDiskPath  + "/resources/images/"  + usuario + "/" + foto.getOriginalFilename() ); 
		foto.transferTo(a);
		return "/resources/images/"  + usuario + "/" + foto.getOriginalFilename(); 
	}
	
	
	private boolean deleteWithChildren(String path) {  
	    File file = new File(path);  
	    if (!file.exists()) {  
	        return true;  
	    }  
	    if (!file.isDirectory()) {  
	        return file.delete();  
	    }  
	    return this.deleteChildren(file) && file.delete();  
	}  
	  
	private boolean deleteChildren(File dir) {  
	    File[] children = dir.listFiles();  
	    boolean childrenDeleted = true;  
	    for (int i = 0; children != null && i < children.length; i++) {  
	        File child = children[i];  
	        if (child.isDirectory()) {  
	            childrenDeleted = this.deleteChildren(child) && childrenDeleted;  
	        }  
	        if (child.exists()) {  
	            childrenDeleted = child.delete() && childrenDeleted;  
	        }  
	    }  
	    return childrenDeleted;  
	}  
}

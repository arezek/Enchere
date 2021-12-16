package eni.fr.ihm.servlet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class UplaodImagetest
 */
@MultipartConfig(
		  fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
		  maxFileSize = 1024 * 1024 * 10,      // 10 MB
		  maxRequestSize = 1024 * 1024 * 100) // 100 MB
@WebServlet("/UplaodImagetest")
public class UplaodImagetest extends HttpServlet {
	private static final long serialVersionUID = 1L;
		
	public static final String IMAGES_FOLDER = "C://Users/vmware/Documents/JavaProject/ENI-Encheres/src/main/webapp/img/ArticlesPhotos/";
	 @Override
//	    public void init() throws ServletException {
//	        uploadPath = getServletContext().getRealPath( IMAGES_FOLDER );
//	        File uploadDir = new File( uploadPath );
//	        if ( ! uploadDir.exists() ) uploadDir.mkdir();
//	    }
//   //	    if(fileName.equalsIgnoreCase("A.png")) fileName="B.png";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		Part filePart = request.getPart("photo");
//	    String fileName = filePart.getSubmittedFileName();
//		
//	    fileName = fileName.substring(fileName.lastIndexOf(File.separatorChar)+1);	
	    
		
	    filePart.write(IMAGES_FOLDER + fileName);
		
    	  		    
	    response.getWriter().print("Photo chargée avec succès");    
	    
	  }
		
	}

//}

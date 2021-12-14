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
	public static final int TAILLE_TAMPON = 10240; //définir un tampon pour la copie
	public static final String CHEMIN_FICHIERS = "/img/fichiers/ArticlesPhotos"; // A changer  
	public String uploadPath;
	 public static final String IMAGES_FOLDER = "/img";
	 @Override
	    public void init() throws ServletException {
	        uploadPath = getServletContext().getRealPath( IMAGES_FOLDER );
	        File uploadDir = new File( uploadPath );
	        if ( ! uploadDir.exists() ) uploadDir.mkdir();
	    }
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// On récupère le champ du fichier
//        Part part = request.getPart("fichier");
//            
//        // On vérifie qu'on a bien reçu un fichier
//        String nomFichier = getNomFichier(part);
//
//        // Si on a bien un fichier
//        if (nomFichier != null && !nomFichier.isEmpty()) {
//            String nomChamp = part.getName();
//            // Corrige un bug du fonctionnement d'Internet Explorer
//             nomFichier = nomFichier.substring(nomFichier.lastIndexOf('/') + 1)
//                    .substring(nomFichier.lastIndexOf('/') + 1);
//
//            // On écrit définitivement le fichier sur le disque
//            ecrireFichier(part, nomFichier, CHEMIN_FICHIERS);
//
//            request.setAttribute(nomChamp, nomFichier);
//        }
//
//        this.getServletContext().getRequestDispatcher("/WEB-INF/JSPtestImage.jsp").forward(request, response);
//    }
//
//    private void ecrireFichier( Part part, String nomFichier, String chemin ) throws IOException {
//        BufferedInputStream entree = null;
//        BufferedOutputStream sortie = null;
//        try {
//            entree = new BufferedInputStream(part.getInputStream(), TAILLE_TAMPON);
//            sortie = new BufferedOutputStream(new FileOutputStream(new File(chemin + nomFichier)), TAILLE_TAMPON);
//
//            byte[] tampon = new byte[TAILLE_TAMPON];
//            int longueur;
//            while ((longueur = entree.read(tampon)) > 0) {
//                sortie.write(tampon, 0, longueur);
//            }
//        } finally {
//            try {
//                sortie.close();
//            } catch (IOException ignore) {
//            }
//            try {
//                entree.close();
//            } catch (IOException ignore) {
//            }
//        }
//    }
//    
//    private static String getNomFichier( Part part ) {
//        for ( String contentDisposition : part.getHeader( "content-disposition" ).split( ";" ) ) {
//            if ( contentDisposition.trim().startsWith( "filename" ) ) {
//                return contentDisposition.substring( contentDisposition.indexOf( '=' ) + 1 ).trim().replace( "\"", "" );
//            }
//        }
//        return null;	
		
		Part filePart = request.getPart("file");
	    String fileName = filePart.getSubmittedFileName();
	    for (Part part : request.getParts()) {
	      part.write("/img" + fileName);
	    }	    
	  
		    
	    response.getWriter().print("Photo chargée avec succès");
	    
	
	    
	    
	  }
		
	}

//}

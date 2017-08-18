package com.spring61.mvc.controller;

import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.spring61.mvc.model.*;
import com.spring61.mvc.repository.*;
import com.spring61.mvc.service.*;

@Controller
public class UploadController  {

    private static final Logger logger = LoggerFactory.getLogger(UploadController.class);
    
    @Autowired
	private IServiceUpload uploadsrv; 
	
 
    /**
     * http://localhost/upload/fileupload
     */
    @RequestMapping(value = "/upload/fileupload", method = RequestMethod.GET)
    public String fileupload(Model model)  {

        return "upload/fileupload";
    }

    /**
     * http://localhost/upload/fileuploadone
     * @throws IOException 
     * @throws IllegalStateException 
     */
    @RequestMapping(value = "/upload/fileuploadone", method = RequestMethod.POST)
    public String fileuploadone(Model model
            , @ModelAttribute MultipartFile file
            , @RequestParam String upDir
            ) throws IllegalStateException, IOException  {
        
        // uploadsuccess.jsp 에 출력할 파일이름.
        List<String> filelist = new ArrayList<String>();
        
        // 폴더 존재 여부 검사
        File dir = new File(upDir );
        if (!dir.exists()) {
            dir.mkdir();
        }
                
        // 로컬 파일을 서버로 올리기 위한 코드
        String fileName = file.getOriginalFilename();
        String filepath = upDir + "/" + fileName;                 
        File f = new File( filepath );                
        file.transferTo( f );

        // uploadsuccess.jsp 에 출력할 파일이름 저장
        filelist.add(fileName);
        
        // DB insert 처리를 위한 코드
        ModelUploadFile attachfile = new ModelUploadFile();
        attachfile.setFileName( f.getName() );
        attachfile.setFileSize( (Long)f.length() );
        attachfile.setContentType( file.getContentType() ); // 확장자

        // DB insert 
        uploadsrv.insertAttachFile(attachfile);
        
        model.addAttribute("files", filelist);
 
        return "upload/uploadsuccess";
    }
    /**
     * http://localhost/upload/fileuploadmulti
     * @throws IOException 
     * @throws IllegalStateException 
     */
    @RequestMapping(value = "/upload/fileuploadmulti", method = RequestMethod.POST)
    public String fileuploadmulti( Model model
            , @ModelAttribute RepositoryFiles uploadForm
            , @RequestParam String upDir ) throws IllegalStateException, IOException  {

        logger.info("UploadController.fileuploadmulti");
        
        List<MultipartFile> files = uploadForm.getFiles();
        
        // uploadsuccess.jsp 에 출력할 파일이름.
        List<String> filelist = new ArrayList<String>();        
        
        if( files != null && files.size() > 0 ){
            
            for (MultipartFile file : files) {
                // 로컬 파일을 서버로 올리기 위한 코드
                String fileName = file.getOriginalFilename();
                String filepath = upDir + "/" + fileName;                 
                File f = new File( filepath );                
                file.transferTo( f );

                // uploadsuccess.jsp 에 출력할 파일이름 저장
                filelist.add(fileName);
                
                // DB insert 처리를 위한 코드
                ModelUploadFile attachfile = new ModelUploadFile();
                attachfile.setFileName( f.getName() );
                attachfile.setFileSize( (Long)f.length() );
                attachfile.setContentType( file.getContentType() ); // 확장자

                // DB insert 
                uploadsrv.insertAttachFile(attachfile);
            }
        }        

        model.addAttribute("files", filelist);
 
        return "upload/uploadsuccess";
    }

    /**
     * 사진 업로드를 위한 화면
     * @return
     */
    @RequestMapping(value="/upload/imageupload", method = RequestMethod.GET)
    public String saveImage() {
        return "upload/imageupload";
    }
     
    /**
     * 사진 파일 업로드 후 DB 저장
     * @param vo
     * @return
     */
    @RequestMapping(value="/upload/imageupload", method = RequestMethod.POST)
    public String saveImage(Model model 
            , @RequestParam String upDir
            , @ModelAttribute ModelUploadImage vo ) {
        
        Integer attachfileno = null;
        
        try {
            vo.setFileName( vo.getImage().getOriginalFilename() );
            vo.setFileSize( (Long)vo.getImage().getSize() );
            vo.setContentType( vo.getImage().getContentType() ); // 확장자
            vo.setImageBytes( vo.getImage().getBytes() );
            vo.setImageBase64( Base64.getEncoder().encodeToString( vo.getImage().getBytes() ) );
            
            attachfileno = uploadsrv.insertPhoto(vo); 
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return "redirect:/upload/imageview/"+ Integer.toString( attachfileno );
    }
    /**
     * 임의의 뷰페이지
     * @return
     */
    @RequestMapping(value="/upload/imageview/{attachfileno}", method = RequestMethod.GET)
    public String imageview(Model model, @PathVariable int attachfileno) {

        ModelUploadImage result = uploadsrv.getImageByte(attachfileno);
        
        model.addAttribute("attachfileno", attachfileno);
        model.addAttribute("contentType", result.getContentType() );
        model.addAttribute("imageBase64", result.getImageBase64() );
        
        return "upload/imageview";
    }
         
    /**
     * img 태그의 src에 이미지를 출력하기 위한 메서드
     * @return
     */
    @RequestMapping(value="/upload/getphoto/{attachfileno}", method = RequestMethod.GET)
    public ResponseEntity<byte[]> getImageByte(@PathVariable int attachfileno) {

        ModelUploadImage result = uploadsrv.getImageByte(attachfileno);
        
       byte[] imageContent =  result.getImageBytes();
       final HttpHeaders headers = new HttpHeaders();
       headers.setContentType( MediaType.valueOf( result.getContentType() ) );
       
       return new ResponseEntity<byte[]>(imageContent, headers, HttpStatus.OK);
    }
}

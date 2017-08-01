<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>      
    
<%@ page import="java.io.File" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.io.OutputStream" %>
<%@ page import="java.io.FileInputStream" %>
<%@ page import="java.io.IOException" %>
<%@ page import="org.springframework.util.FileCopyUtils" %>
<%@ page import="com.spring81.bbs.commons.WebConstants" %>
<%
    //request.setCharacterEncoding("UTF-8");//이 작업은 필터가 한다.
    String filename     = request.getParameter("filename");     // filename     : Controller 에서 넘겨 받는 실제파일명
    String tempfilename = request.getParameter("tempfilename"); // tempfilename : Controller 에서 넘겨 받는 임시파일명
    
    File file = new File(WebConstants.UPLOAD_PATH + tempfilename );  // File 
 
    /*
     * http 헤더 설정
     * 1. 파일 MIME 타입 설정
     * 2. 파일 크기 설정.
     * 3. 파일 다운로드 설정 : attachment
     */
    // http 헤더 설정 : 파일 MIME 타입 설정
    String filetype = filename.substring(filename.indexOf(".") + 1, filename.length());    
    if (filetype.trim().equalsIgnoreCase("txt")) {
        response.setContentType("text/plain");
    } else {
        response.setContentType("application/octet-stream");
    }   
    
    // http 헤더 설정 : 파일 크기 설정.
    response.setContentLength((int) file.length());
    
    // http 헤더 설정 :  파일 다운로드 설정  : attachment
    response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
    
    
    // 파일 이름 인코딩 처리
    boolean ie = request.getHeader("User-Agent").indexOf("MSIE") != -1;    
    if (ie) {
        filename = URLEncoder.encode(filename, "UTF-8").replaceAll("\\+", " ");
    } else {
        filename = new String(filename.getBytes("UTF-8"), "8859_1");
    }
    
    
    // 스트림을 이용한 파일 읽기& 쓰기
    OutputStream outputStream = response.getOutputStream();
    FileInputStream fis = null;
    
    try {
        fis = new FileInputStream(file);
        FileCopyUtils.copy(fis, outputStream);
    } finally {
        if (fis != null) {
            try {
                fis.close();
            } catch (IOException e) {
            }
        }
    }
    
    out.flush();
%>
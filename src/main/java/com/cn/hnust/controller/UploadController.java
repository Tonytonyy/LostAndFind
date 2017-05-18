package com.cn.hnust.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.cn.hnust.pojo.User;

@Controller
@RequestMapping("/upload")
public class UploadController {

	/**
	* <p>Title: UploadController.java<／p>
	* <p>Description: <／p>
	* <p>Copyright: Copyright (c) 2007<／p>
	* <p>Company: LTGames<／p>
	* @author linrz
	* @date 2017年4月16日
	* @version 1.0
	*/
	@RequestMapping("uploadPic")
	public void uploadPic(HttpServletRequest request,String fileName,String name,PrintWriter out){
		//把Request强转成多部件请求对象
		MultipartHttpServletRequest mh = (MultipartHttpServletRequest) request;
		//根据文件名称获取文件对象
		CommonsMultipartFile cm = (CommonsMultipartFile) mh.getFile(fileName);
		CommonsMultipartFile cm1 = (CommonsMultipartFile) mh.getFile(name);
		System.out.println(name+"--------------------------------"+fileName);
		String fullPath=this.saveImage(cm, request);
		String fullPath1=null;
		if(cm1!=null){
		    fullPath1=this.saveImage(cm1, request);

		}
		//获取文件上传流
		/*byte[] fbytes = cm.getBytes();
		try {
			InputStream ip=cm.getInputStream();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//文件名称在服务器有可能重复？
		String newFileName="";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		newFileName = sdf.format(new Date());
		
		Random r = new Random();
		
		for(int i =0 ;i<3;i++){
			newFileName=newFileName+r.nextInt(10);//文件名
		}
		
		//获取文件扩展名
		String originalFilename = cm.getOriginalFilename();
		String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
		
		//创建jesy服务器，进行跨服务器上传
	//	Client client = Client.create();
		//把文件关联到远程服务器
	//	WebResource resource = client.resource(Commons.PIC_HOST+"/upload/"+newFileName+suffix);
		//上传
//		resource.put(String.class, fbytes);
		String path="/static/images/"+newFileName+suffix;
		
		//ajax回调函数需要会写写什么东西？
		//图片需要回显：需要图片完整路径
		//数据库保存图片的相对路径.
        String pathRoot = request.getSession().getServletContext().getRealPath("");  
		String fullPath="http://localhost:8080/HNUST/"+path;
		System.out.println("--------------------------------------------------------"+path);
		File f = new File(path); 
		
		 try {
		    OutputStream ops = new FileOutputStream(pathRoot+path);
			ops.write(fbytes);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("图片写入错误");
		}
		//String fullPath = Commons.PIC_HOST+"/upload/"+newFileName+suffix;
		 //http://localhost:8080/HNUST//static/images/5fd5f289c132475b8c96c891462f6c83.jpeg
		
		//String relativePath="/upload/"+newFileName+suffix;
		String relativePath = null;
		//{"":"","":""}
		String result="{\"fullPath\":\""+fullPath+"\",\"relativePath\":\""+relativePath+"\"}";
		*/
		String relativePath = null;
		System.out.println("---------------------"+fullPath);
		String result="{\"fullPath\":\""+fullPath+"\",\"relativePath\":\""+relativePath+"\",\"fullPath1\":\""+fullPath1+"\"}";
		out.print(result);
				
		
	}
	@RequestMapping("/jsondemo")
	@ResponseBody
	public String jsondemo(){
		
		//System.out.println("-------------------------------------"+image.getImage()+image.getImage2());
		return null;
	}
	public String saveImage(CommonsMultipartFile cm,HttpServletRequest request){
		byte[] fbytes = cm.getBytes();
		try {
			InputStream ip=cm.getInputStream();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//文件名称在服务器有可能重复？
		String newFileName="";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		newFileName = sdf.format(new Date());
		
		Random r = new Random();
		
		for(int i =0 ;i<3;i++){
			newFileName=newFileName+r.nextInt(10);//文件名
		}
		
		//获取文件扩展名
		String originalFilename = cm.getOriginalFilename();
		String suffix = ".jpg";
		System.out.println("-----------------------------------"+originalFilename);
		if(!originalFilename.contains(".")){
			 suffix = ".jpg";
		}else{
			 suffix= originalFilename.substring(originalFilename.lastIndexOf("."));
		}
		//创建jesy服务器，进行跨服务器上传
	//	Client client = Client.create();
		//把文件关联到远程服务器
	//	WebResource resource = client.resource(Commons.PIC_HOST+"/upload/"+newFileName+suffix);
		//上传
//		resource.put(String.class, fbytes);
		String path="/static/images/"+newFileName+suffix;
		
		//ajax回调函数需要会写写什么东西？
		//图片需要回显：需要图片完整路径
		//数据库保存图片的相对路径.
        String pathRoot = request.getSession().getServletContext().getRealPath("");  
		String fullPath="http://localhost:8080/HNUST/"+path;
		System.out.println("--------------------------------------------------------"+path);
		File f = new File(path); 
		
		 try {
		    OutputStream ops = new FileOutputStream(pathRoot+path);
			ops.write(fbytes);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("图片写入错误");
		}
		//String fullPath = Commons.PIC_HOST+"/upload/"+newFileName+suffix;
		 //http://localhost:8080/HNUST//static/images/5fd5f289c132475b8c96c891462f6c83.jpeg
		
		//String relativePath="/upload/"+newFileName+suffix;
		String relativePath = null;
		//{"":"","":""}
		
		return fullPath;
	}
	@RequestMapping(value="/up")  
    private String fildUpload(User users ,@RequestParam(value="file",required=false) MultipartFile file,  
            HttpServletRequest request)throws Exception{  
        //基本表单  
        System.out.println(users.getUserName()+users.getPassword()+"---------------------------------------------------------");  
        File f=new File("/static/images");
        if(!f.exists()){
        	f.mkdir();
        	//f.createNewFile();
        	System.out.println("创建成功----------------"+f.toString());
        }else{
        	System.out.println("创建失败");
        }
        //获得物理路径webapp所在路径  
        String pathRoot = request.getSession().getServletContext().getRealPath("");  
        String path="";  
        if(!file.isEmpty()){  
            //生成uuid作为文件名称  
            String uuid = UUID.randomUUID().toString().replaceAll("-","");  
            //获得文件类型（可以判断如果不是图片，禁止上传）  
            String contentType=file.getContentType();  
            //获得文件后缀名称  
            String imageName=contentType.substring(contentType.indexOf("/")+1);  
            path="/static/images/"+uuid+"."+imageName;  
            file.transferTo(new File(pathRoot+path));
        }  
        System.out.println(pathRoot+path);
      //  uploadService.upload(pathRoot+path, "HAHAHAHA");
        request.setAttribute("imagesPath", path);  
        return "success";  
    } 
}

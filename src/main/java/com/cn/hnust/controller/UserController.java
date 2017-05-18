package com.cn.hnust.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.cn.hnust.pojo.Article;
import com.cn.hnust.pojo.Images;
import com.cn.hnust.pojo.RUser;
import com.cn.hnust.pojo.Result;
import com.cn.hnust.pojo.User;
import com.cn.hnust.service.IArticleService;
import com.cn.hnust.service.IImagesService;
import com.cn.hnust.service.IRUserService;
import com.cn.hnust.service.IUploadService;
import com.cn.hnust.service.IUserService;
import com.cn.hnust.vo.ArticlePage;
import com.mysql.fabric.xmlrpc.base.Data;

@Controller
//@RequestMapping("/user")
public class UserController {
	@Resource
	private IUserService userService;
	@Resource
	private IUploadService uploadService;
	@Resource
	private IImagesService imagesService;
	@Resource
	private IRUserService ruserService;
	@Resource
	private IArticleService articleService;
	private String search;
	@RequestMapping("/showUser")
	public String toIndex(HttpServletRequest request,Model model){
		int userId = Integer.parseInt(request.getParameter("id"));
		User user = this.userService.getUserById(userId);
		model.addAttribute("user", user);
		return "showUser";
	}
	
	@RequestMapping(value="/upload",method=RequestMethod.POST)  
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
        uploadService.upload(pathRoot+path, "HAHAHAHA");
        request.setAttribute("imagesPath", path);  
        return "success";  
    } 
	//uploadmore
	 @RequestMapping(value="/uploadmore",method=RequestMethod.POST)  
	    private String fildUpload(User users ,@RequestParam(value="file",required=false) MultipartFile[] file,  
	            HttpServletRequest request)throws Exception{  
	        //基本表单  
	        System.out.println(users.toString());  
	          
	        //获得物理路径webapp所在路径  
	        String pathRoot = request.getSession().getServletContext().getRealPath("");  
	        String path="";   
	        List<String> listImagePath=new ArrayList<String>();  
	        for (MultipartFile mf : file) {  
	            if(!mf.isEmpty()){  
	                //生成uuid作为文件名称  
	                String uuid = UUID.randomUUID().toString().replaceAll("-","");  
	                //获得文件类型（可以判断如果不是图片，禁止上传）  
	                String contentType=mf.getContentType();  
	                //获得文件后缀名称  
	                String imageName=contentType.substring(contentType.indexOf("/")+1);  
	                path="static/images/"+uuid+"."+imageName;  
	                mf.transferTo(new File(pathRoot+path));  
	                listImagePath.add(path);  
	            }  
	        }  
	        System.out.println(path);  
	        request.setAttribute("imagesPathList", listImagePath);  
	        return "success";  
	    } 
	@RequestMapping(value="/tologin")
	public String tologin(Model model){
		
		return "login";
	}
	@RequestMapping(value="/editItem")
	public String tomoreimages(Model model){
		
		return "editItem";
	}

	@RequestMapping(value="/action/reg")
    public  RUser reg(@RequestBody RUser user){
		System.out.println(user.getUsername()+"---------------------------------------+++++++++++++");
		return user;
	}
	@RequestMapping(value="/action/regdemo")
    public void demo(String username,String password){
		System.out.println(username+password+"---------------------------------------+++++++++++++");
	}
	@RequestMapping(value="/reguser")
	public @ResponseBody Result regUser(@RequestBody RUser user){
		Result result =new Result();
		Date date =new Date();
		System.out.println("-------------------------"+user.getPassword()+user.getUsername()+user.getUserphonenumber()
		 +date);
        user.setCreatedate(date);
		RUser ur= ruserService.selectRUserByName(user.getUsername());
		if(null==ur){
			ruserService.insertUser(user);
			result.setSuccess(true);
			result.setMsg("注册成功");
		}else{
			result.setSuccess(false);
			result.setMsg("用户名已存在");
		}
		
		return result;
	}
	@RequestMapping(value="/userlogin")
	public @ResponseBody Result login(@RequestBody RUser user,HttpServletRequest request){
		RUser ru = null;
		Result result = new Result();
		HttpSession hp=request.getSession();
		System.out.println("-------------------------"+user.getPassword()+user.getUsername()+user.getUserphonenumber());
		if(!user.getPassword().equals("")&&""!=user.getPassword()&&!user.getUsername().equals("")&&""!=user.getUsername()){
		   ru=ruserService.selectRUserByNameAndPass(user.getUsername(), user.getPassword());
		}
		if(ru!=null){
			result.setSuccess(true);
			hp.setAttribute("user", ru);
			result.setMsg("欢迎登入"+user.getUsername());
		}else{
			result.setSuccess(false);
			result.setErrorCode("账号或者密码输入错误");
		}
		return result;
		
	}
	@RequestMapping(value="/uploadAricle")
    public @ResponseBody Result uploadAricle(@RequestBody Article article,HttpServletRequest request){
		System.out.println("-------------------------"+article.getArticlebody()+article.getArticletitle()+article.getArticleadress());
		HttpSession session=request.getSession();
		RUser user=(RUser) session.getAttribute("user");
		Integer userid=user.getUserid();
		article.setUserid(userid);
		articleService.InsertAricle(article);
		
		Result result = new Result();
		result.setMsg("提交成功");
        return result;
	}
	@RequestMapping(value="/uploadAricleInit")
    public @ResponseBody Article uploadAricleInit(HttpServletRequest request){
		HttpSession session=request.getSession();
		Article article=new Article();
		RUser user=(RUser) session.getAttribute("user");
		Integer amid=articleService.getramId();
		article.setArticleid(amid);
		article.setUserid(user.getUserid());
		article.setType(0);//丢失物品
        return article;
	}
	@RequestMapping(value="/uploadImages")
    public @ResponseBody Result uploadImages(@RequestBody List<Images> list){
		for(Images im:list){
			System.out.println(im.getImagehref()+"111111111111111111111122222222");
		}
		imagesService.inserImagelist(list);
		Result result = new Result();
		result.setMsg("提交成功");
        return result;
	}
	//postdemo
	@RequestMapping(value="/postdemo",method=RequestMethod.POST)
    public  @ResponseBody Result postdemo(RUser user,Model m,HttpServletRequest request){
		System.out.println(user.getUsername()+"----------------------------");
		HttpSession session=request.getSession();
		RUser u=(RUser) session.getAttribute("user");
		m.addAttribute(user);
		Result result = new Result();
		result.setMsg(u.getUsername());
        return result;
	}
	@RequestMapping(value="texthtml")
	public String testhtml(){
		return "head";
	}
	//搜索结果的分页查询
	@RequestMapping(value="/search")
	public @ResponseBody ArticlePage searchreasult(String title,Integer currentPage){
        //每页显示5条记录
		System.out.println(title+currentPage);
		List<Article> list=new ArrayList<Article>();
		Integer pageRecord=4;
        if(null==currentPage){
        	currentPage=0;
        }
        
	    list=articleService.pageBylist(0, 999999, "%"+title+"%");
	    for(Article a :list){
			System.out.println(a.getArticletitle()+"--------------------------------"+a.getArticleid());
		}
		ArticlePage page = new ArticlePage();
		Integer totalrecord=list.size();
		Integer totalpage=(int) Math.ceil(totalrecord.doubleValue()/pageRecord);
		page.setCurrentPage(currentPage);
		page.setTotalRecords(totalrecord);
		page.setPageRecord(pageRecord);
		page.setTotalPage(totalpage);
		if((currentPage*pageRecord+pageRecord)<totalrecord){
			page.setPageList(list.subList(currentPage*pageRecord, currentPage*pageRecord+pageRecord));
		 }else{
				page.setPageList(list.subList(currentPage*pageRecord, totalrecord.intValue()));
		 }
		//page.setPageList(list.subList(4, 8));
		for(Article a :page.getPageList()){
			System.out.println(a.getArticletitle()+"--------------------------------"+a.getArticleid());
		}
		return page;
	}
	
	
	@RequestMapping(value="initlostandfind")
	public @ResponseBody Article initlost(){
		//this.search=title;
		System.out.println("-------------------------------lostandfind---------------------------");
		Article article = new Article();
		Integer articleid= articleService.getramId();
		article.setArticleid(articleid);
		return article;
	}
	//初始化发布丢失信息界面
	@RequestMapping(value="tosearch")
	public String tosearch(String title){
		this.search=title;
		return "search";
	}
	
	//发布物品的详情页
	@RequestMapping(value="detial")
	public  @ResponseBody Article todetial(Integer artcileid){
		Article art=articleService.selectArticleById(artcileid);
		return art;
	}
	
}

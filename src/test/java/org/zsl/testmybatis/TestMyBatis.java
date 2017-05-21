package org.zsl.testmybatis;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cn.hnust.dao.IArticleDao;
import com.cn.hnust.dao.IImagesDao;
import com.cn.hnust.dao.IRUserDao;
import com.cn.hnust.dao.IUserDao;
import com.cn.hnust.pojo.Article;
import com.cn.hnust.pojo.Images;
import com.cn.hnust.pojo.RUser;
import com.cn.hnust.pojo.User;
import com.cn.hnust.service.IArticleService;
import com.cn.hnust.service.IImagesService;
import com.cn.hnust.service.IRUserService;
import com.cn.hnust.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)		//表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})

public class TestMyBatis {
	private static Logger logger = Logger.getLogger(TestMyBatis.class);
//	private ApplicationContext ac = null;
	@Resource
	private IUserService userService ;
	@Resource
    private IImagesService imagesService;
	@Resource
    private IArticleService articleService;
	@Resource
	private IRUserService ruserDao;
	@Resource
	private IRUserDao userDao;
	@Resource
	private IImagesDao imagesDao;
	@Resource
	private IArticleDao aricleDao;
	//	@Before
//	public void before() {
//		ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//		userService = (IUserService) ac.getBean("userService");
//	}

	@Test
	public void test1() {
	//	User user = userService.getUserById(1);
	//	 System.out.println(user.getUserName());
		// logger.info("值："+user.getUserName());
	//	Images images = imagesService.selectImagesById(1);
	//	logger.info(JSON.toJSONString(user));
	//	Article art=articleService.selectArticleById(1);
    //    for(Images images:art.getImageslist()){
    //    	System.out.println(images.getImagehref());
     //   }	
	//	Date d = new Date();
	//	SimpleDateFormat sm = new SimpleDateFormat("yyyy.MM.dd");
   //		RUser user = new RUser();
	//	user.setPassword("123456");
	//	user.setUsername("admin");
	//	user.setUserphonenumber("11011011011");
	//	user.setCreatedate(d);
	//	ruserDao.insertUser(user);
		RUser u =new RUser();
		u.setUsername("admin");
		u.setPassword("123456");
	//	int a=userDao.insert(u);
	//	System.out.println("哈哈哈"+a);
		//Integer num=aricleDao.createNewArt();
	//	Integer num =articleService.getramId();
		List<Article> list=aricleDao.pageByUserid(0, 100, 1);
		for(Article art :list){
			System.out.println(art.getArticlebody());
		}
		//aricleDao.delectArticlebyid(2);
  		}
	}


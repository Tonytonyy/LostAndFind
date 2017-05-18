package com.cn.hnust.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hnust.dao.IArticleDao;
import com.cn.hnust.pojo.Article;
import com.cn.hnust.service.IArticleService;

@Service("articleService")
public class ArticleService implements IArticleService {
	@Resource
	private IArticleDao articleDAO;
	public Integer getramId(){
		Integer num=1;
		while(this.selectArticleById(num)!=null){
			 num=(int) (Math.random()*1000000000);
		};
		return num;
	}
	public Article selectArticleById(Integer artcileid) {
		// TODO Auto-generated method stub
		return articleDAO.selectArticleById(artcileid);
	}
	public void InsertAricle(Article article) {
		// TODO Auto-generated method stub
		articleDAO.insertArticle(article);
	}
	public List<Article> pageBylist(Integer star,Integer end,String title){
		return articleDAO.pageByTitle(star, end, title);
	}

	/**
	* <p>Title: ArticleService.java<／p>
	* <p>Description: <／p>
	* <p>Copyright: Copyright (c) 2007<／p>
	* <p>Company: LTGames<／p>
	* @author linrz
	* @date 2017年4月20日
	* @version 1.0
	*/
}

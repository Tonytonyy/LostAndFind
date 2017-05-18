package com.cn.hnust.service;

import java.util.List;

import com.cn.hnust.pojo.Article;

public interface IArticleService {
   public Article selectArticleById(Integer artcileid);
   public Integer getramId();
   public void InsertAricle(Article article);
   public List<Article> pageBylist(Integer star,Integer end,String title);
}

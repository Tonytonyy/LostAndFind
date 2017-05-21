package com.cn.hnust.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cn.hnust.pojo.Article;

public interface IArticleDao {
 
    public Article selectArticleById(Integer articleid);
    public Integer createNewArt();
    public void insertArticle(Article article);
    public List<Article> pageByTitle(@Param("star") Integer star,@Param("end") Integer end,@Param("title") String title);
    public List<Article> pageByUserid(@Param("star") Integer star,@Param("end") Integer end,@Param("userid") Integer userid);
    public void delectArticlebyid(Integer articleid);
}

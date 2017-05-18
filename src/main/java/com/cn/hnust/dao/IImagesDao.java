package com.cn.hnust.dao;

import java.util.List;

import com.cn.hnust.pojo.Images;

public interface IImagesDao {
  
	public Images selectImagesByid(Integer imagesid);
	public List<Images> selectImagesByArticleId(Integer articleid);
	public Integer insertImagelist(List<Images> images);
}

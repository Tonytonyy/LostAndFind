package com.cn.hnust.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hnust.dao.IImagesDao;
import com.cn.hnust.pojo.Images;
import com.cn.hnust.service.IImagesService;

@Service("imagesService")
public class ImagesServiceImple implements IImagesService {
    
	@Resource
	private IImagesDao iimagesDao;
	
	public Images selectImagesById(Integer imagesid) {
		// TODO Auto-generated method stub
		return iimagesDao.selectImagesByid(imagesid);
	}

	public Integer inserImagelist(List<Images> images) {
		// TODO Auto-generated method stub
		return iimagesDao.insertImagelist(images);
	}

	/**
	* <p>Title: ImagesServiceImple.java<／p>
	* <p>Description: <／p>
	* <p>Copyright: Copyright (c) 2007<／p>
	* <p>Company: LTGames<／p>
	* @author linrz
	* @date 2017年4月20日
	* @version 1.0
	*/
}

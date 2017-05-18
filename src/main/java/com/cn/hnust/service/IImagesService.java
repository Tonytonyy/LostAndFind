package com.cn.hnust.service;

import java.util.List;

import com.cn.hnust.pojo.Images;

public interface IImagesService {
   public Images selectImagesById(Integer imageid);
   public Integer inserImagelist(List<Images> images);
}

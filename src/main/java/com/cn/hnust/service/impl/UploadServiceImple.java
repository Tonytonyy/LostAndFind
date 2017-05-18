package com.cn.hnust.service.impl;

import org.springframework.stereotype.Service;

import com.cn.hnust.service.IUploadService;
import com.google.gson.Gson;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import com.qiniu.*;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;

@Service("uploadService")
public class UploadServiceImple implements IUploadService {
	private final String ACCESS_KEY = "tnj9TP78fvuEIoChN2ZGY_g8w0UK6g93SYx7paBU";
	private final String SECRET_KEY = "pcrvn9eDBmU8vGdVZd4fc7Nf-bJgXVQWeOlG5JWf";
	private final String bucketname = "yuxinimages";
   
	Zone z = Zone.autoZone();

	Configuration cfg = new Configuration(z);

    Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

    UploadManager uploadManager = new UploadManager(cfg);
    
    String upToken = auth.uploadToken(bucketname);
    
	public void upload(String localFilePath, String key) {
		// TODO Auto-generated method stub
		try {
		    Response response = uploadManager.put(localFilePath, key, upToken);
		    //解析上传成功的结果
		    DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
		    System.out.println(putRet.key);
		    System.out.println(putRet.hash);
		} catch (QiniuException ex) {
		    Response r = ex.response;
		    System.err.println(r.toString());
		    try {
		        System.err.println(r.bodyString());
		    } catch (QiniuException ex2) {
		        //ignore
		    }
	}}

	/**
	* <p>Title: UploadServiceImple.java<／p>
	* <p>Description: <／p>
	* <p>Copyright: Copyright (c) 2007<／p>
	* <p>Company: LTGames<／p>
	* @author linrz
	* @date 2017年4月14日
	* @version 1.0
	*/
}

package com.oucre.core.util;
import java.io.File;
import java.util.UUID;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;

/**
 * 七牛上传帮助类
 */
public class QiniuHelper {
	
    /**
     * 空间名
     */
    private static String Scope = PropertiesUtil.getProperties("C:/qiniu.properties", "Scope");
    
    /**
     * 域名
     */
    private static String Url = PropertiesUtil.getProperties("C:/qiniu.properties", "Url");
    
    /**
     * 公钥
     */
    private static String ACCESS_KEY = PropertiesUtil.getProperties("C:/qiniu.properties", "ACCESS_KEY");
    
    private static String SECRET_KEY = PropertiesUtil.getProperties("C:/qiniu.properties", "SECRET_KEY");
    
    /**
     * 上传附件
     * @throws QiniuException 
     */
    public static String UploadFile(File file) throws QiniuException {
    	
    	String key = UUID.randomUUID().toString().replaceAll("-", "");
    	
    	try {
    		Configuration cfg = new Configuration(Zone.zone0());
	    	//创建上传对象
	    	UploadManager uploadManager = new UploadManager(cfg);
	    	System.out.println("-----------"+ACCESS_KEY+"##"+SECRET_KEY+"------------");
	    	//密钥配置
	    	Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
	    	
	    	//上传文件
	    	Response res = uploadManager.put(file, key, auth.uploadToken(Scope, key));
	    	//解析上传成功的结果
	        DefaultPutRet putRet = new Gson().fromJson(res.bodyString(), DefaultPutRet.class);
	        System.out.println(putRet.key);
	        System.out.println(putRet.hash);
    	} catch (QiniuException e) {
    		Response r = e.response;
    	    System.err.println(r.toString());
    	    try {
    	        System.err.println(r.bodyString());
    	    } catch (QiniuException ex2) {
    	        //ignore
    	    }
    		return "";
    	}
    	return key;
    }
    
    /**
     * 获得url地址
     */
    public static String GetUrl(String key)
    {
        return String.format ("http://%s/%s", Url, key);
    }
}
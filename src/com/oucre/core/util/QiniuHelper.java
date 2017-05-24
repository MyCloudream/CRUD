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
 * ��ţ�ϴ�������
 */
public class QiniuHelper {
	
    /**
     * �ռ���
     */
    private static String Scope = "cloudream";
    
    /**
     * ����
     */
    private static String Url = "7xtc8l.com1.z0.glb.clouddn.com";
    
    /**
     * ��Կ
     */
    private static String ACCESS_KEY = "uHUWG9003TUUnD_VC7SzwEp3GdvGv32TrjHgyhwU";
    
    private static String SECRET_KEY = "6y66fnq_30XXif0q7bpMlvlIDEP05P6GlnVCBuwo";
    
    /**
     * �ϴ�����
     * @throws QiniuException 
     */
    public static String UploadFile(File file) throws QiniuException {
    	
    	String key = UUID.randomUUID().toString().replaceAll("-", "");
    	
    	try {
    		Configuration cfg = new Configuration(Zone.zone0());
	    	//�����ϴ�����
	    	UploadManager uploadManager = new UploadManager(cfg);
	    	
	    	//��Կ����
	    	Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
	    	
	    	//�ϴ��ļ�
	    	Response res = uploadManager.put(file, key, auth.uploadToken(Scope, key));
	    	//�����ϴ��ɹ��Ľ��
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
     * ���url��ַ
     */
    public static String GetUrl(String key)
    {
        return String.format ("http://%s/%s", Url, key);
    }
}
package com.li.pulljar;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.li.httphelper.HttpHelper;
import com.li.httphelper.ResponseContent;
import com.li.pulljar.util.Md5;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		/////22222
		/////11111
//		testString();
//		testGongJiJinLogin();
		
//		long time=1462867853406l;
//		Date date=new Date(time);
//		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		String str=format.format(date);
//		System.out.println(str);
		testMap();
	}
	
	
	public static void testMap(){
		Map<String, String> map = new HashMap<String,String>();
		map.put("a", "1");
		map.put("b", "2");
		
		Set<String> keys = map.keySet();
		for(String key :keys){
		     System.out.println(key+" "+map.get(key));
		}
		
		changeMap(map);
		Set<String> keyss = map.keySet();
		for(String key :keyss){
		     System.out.println(key+" "+map.get(key));
		}
	}
	
	public static void changeMap(Map<String, String> map){
		map.put("c", "3");
		
		Set<String> keyss = map.keySet();
		for(String key :keyss){
		     System.out.println(key+" "+map.get(key));
		}
	};
	
	
	
	
	
	public static void testString(){
		String testStr = "李欢 >>>住房公积金本年度账户明细";
		System.out.println(testStr.substring(0, testStr.indexOf(">")));
		
	}

	public static void testGongJiJinLogin() {
		String username = "woniu4500";
		String password = "lihuan450052016";
		String imagecode = "2856";
		String password_md5 = Md5.getMD5ofStrByLowerCase(password);
		String param = "?username="+username+"&password="+password+"&imagecode="+imagecode+"&password_md5="+password_md5;
//		https://persons.shgjj.com/SsoLogin?url=https://persons.shgjj.com/MainServlet?ID=1
		String url = "https://persons.shgjj.com/SsoLogin";
		ResponseContent responseContent = HttpHelper.postUrl(url, null);
		
		try {
			System.out.println(responseContent.getContent());
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/****
	 * 文件重命名
	 * 
	 * @param path
	 *            文件目录
	 * @param oldname
	 *            原来的文件名
	 * @param newname
	 *            新文件名
	 */
	public static void renameFile(String path, String oldname, String newname) {
		if (!oldname.equals(newname)) {// 新的文件名和以前文件名不同时,才有必要进行重命名
			File oldfile = new File(path + "/" + oldname);
			File newfile = new File(path + "/" + newname);
			if (!oldfile.exists()) {
				return;// 重命名文件不存在
			}
			if (newfile.exists())// 若在该目录下已经有一个文件和新文件名相同，则不允许重命名
				System.out.println(newname + "已经存在！");
			else {
				oldfile.renameTo(newfile);
			}
		} else {
			System.out.println("新文件名和旧文件名相同...");
		}
	}
}

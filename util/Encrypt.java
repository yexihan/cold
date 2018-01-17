package cn.itcast.jx.util;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.Sha1Hash;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.crypto.hash.Sha384Hash;
import org.apache.shiro.crypto.hash.Sha512Hash;

/**
 * @Description:
 * @Author:			传智袁新奇
 * @Company:		http://java.itcast.cn
 */
public class Encrypt {
	/*
	 * 散列算法一般用于生成数据的摘要信息，是一种不可逆的算法，一般适合存储密码之类的数据，
	 * 常见的散列算法如MD5、SHA等。一般进行散列时最好提供一个salt（盐），比如加密密码“admin”，
	 * 产生的散列值是“21232f297a57a5a743894a0e4a801fc3”，
	 * 可以到一些md5解密网站很容易的通过散列值得到密码“admin”，
	 * 即如果直接对密码进行散列相对来说破解更容易，此时我们可以加一些只有系统知道的干扰数据，
	 * 如用户名和ID（即盐）；这样散列的对象是“密码+用户名+ID”，这样生成的散列值相对来说更难破解。
	 */
	
	//高强度加密算法,不可逆
	public static String md5(String password, String salt){
		return new Md5Hash(password,salt,2).toString();
	}
	
	public static void main(String[] args) {
		/**
		 * "123456","tony",1：5c51b703b1399a874e12d38a4cf33e46
		 * "123456","tony",2：4eaf863bbc05d88cf4004f7a2da7877f
		 * "123456","KMNO4",2：c10dad70270769a04bb911b9b2e9ba3f
		 * 
		 */
		//第一个参数：密码明文
		//第二个参数：盐
		//第三根参数：几把
		System.out.println(new Md5Hash("123456","yuyu",2).toString());
//		
//		//sha1:766b1e8fa1ba1e72deab720d90d0ab42b1336e79
//		System.out.println(new Sha1Hash("123456", "KMNO4", 2).toString());
//		System.out.println(new Sha256Hash("123456", "KMNO4", 2).toString());
//		System.out.println(new Sha384Hash("123456", "KMN04", 2).toString());
//		System.out.println(new Sha512Hash("123456", "KMN04", 2).toString());
		
		
		
//		char[] pwd = {'a','b','c'};
//		
//		System.out.println(pwd.toString());//
//		System.out.println(new String(pwd));
//		
	}
	
	
}

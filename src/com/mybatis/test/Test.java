package com.mybatis.test;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis.vo.User;

public class Test {
	
	/**
	 * Mybatis 动态SQL/模糊查询/log4j
	 * 
	 * 1、动态sql，可以在mapper中添加<if/> <when/>等标签，做逻辑判断做动态Sql
	 * 2、模糊查询 
	 * 		方法1：and userName like '%${userName}%'   用${...} 
	 * 		方法2：and userName like CONCAT(CONCAT('%', #{userName}), '%');  CONCAT(CONCAT('%', #{xxx}), '%')
	 * 3、log4j：添加log4j相关包，加入xml/properties配置文件即可
	 * 
	 * @param args
	 */
	
	
	public static void main(String[] args) {
		
		
		InputStream is = Test.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
		
		System.out.println(is);
		
		SqlSessionFactory sessionFactory =  new SqlSessionFactoryBuilder().build(is);
		
		System.out.println(sessionFactory);
		
		SqlSession session = sessionFactory.openSession();
		
		System.out.println(session);
		
		
		String userNameSpace = "com.mybatis.vo.User";
		/*一对一嵌套结果*/
		String getUserByCondition = userNameSpace+".getUserByCondition";
		
		List<User> users = session.selectList(getUserByCondition,new User(1, "Tester2", 1));
		System.out.println(users);

		
	}
}

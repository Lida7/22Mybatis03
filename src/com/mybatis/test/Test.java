package com.mybatis.test;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis.vo.User;

public class Test {
	
	/**
	 * Mybatis ��̬SQL/ģ����ѯ/log4j
	 * 
	 * 1����̬sql��������mapper�����<if/> <when/>�ȱ�ǩ�����߼��ж�����̬Sql
	 * 2��ģ����ѯ 
	 * 		����1��and userName like '%${userName}%'   ��${...} 
	 * 		����2��and userName like CONCAT(CONCAT('%', #{userName}), '%');  CONCAT(CONCAT('%', #{xxx}), '%')
	 * 3��log4j�����log4j��ذ�������xml/properties�����ļ�����
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
		/*һ��һǶ�׽��*/
		String getUserByCondition = userNameSpace+".getUserByCondition";
		
		List<User> users = session.selectList(getUserByCondition,new User(1, "Tester2", 1));
		System.out.println(users);

		
	}
}

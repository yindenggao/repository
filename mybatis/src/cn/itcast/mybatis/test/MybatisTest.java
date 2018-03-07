package cn.itcast.mybatis.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.itcast.domain.Person;

public class MybatisTest {
	public static void main(String[] args) throws Exception {
		//根据全局配置文件获取SQLSessionFactory对象
		String resource = "conf/mybatis_configuration.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//根据factory对象获取SQLSession对象,能直接执行已经映射的SQL语句
		SqlSession openSession = sqlSessionFactory.openSession();
		/*
		 * parameter1：唯一标识
		 * parameter2:SQL语句需要的参数
		 */
		try {
			Person person = openSession.selectOne("cn.itcast.mybatis.PersonMapping.selectPerson",1);
			System.out.println(person);
		} finally {
			openSession.close();
		}
	}
	
	@Test
	public void test() throws IOException{
		String resource = "conf/mybatis_configuration.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession openSession = factory.openSession();
		//根据数据库会话对象获取接口实现类对象
		Mybatis mapper = openSession.getMapper(Mybatis.class);
		Person person = mapper.getPersonId(1);
		System.out.println(person);
		System.out.println(mapper);
		
	}
}

interface Mybatis{
	public Person getPersonId(Integer id);
}

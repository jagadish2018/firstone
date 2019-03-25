package com.demo.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.Portalback.App;
import com.demo.dao.Mainblogdao;
import com.demo.dao.Mainuserdao;
import com.demo.model.Mainblog;
import com.demo.model.Mainuser;

public class Mainblogtest {
	AnnotationConfigApplicationContext context;
	Mainblog mb;
	Mainblogdao mbd;
	
	@Before
	public void init()
	{
	context = new AnnotationConfigApplicationContext(App.class);
	context.scan("com.demo");
	mbd=(Mainblogdao)context.getBean("blogdao");
	mb=new Mainblog();
	}
	
	@Test
	public void test() {
		
	}

}

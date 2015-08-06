package com.jijiyan.deal.startpoint.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/context.xml" })
@WebAppConfiguration
public class BaseUnitTest {
	@Before
	public void init(){
		
	}
	
	@Test
	public void test(){}
	
}

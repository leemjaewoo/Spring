package kr.or.ddit.ranger.service;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.ranger.dao.IRangerDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:kr/or/ddit/config/spring/application-context.xml",
	"classpath:kr/or/ddit/config/spring/servlet-context.xml"})
public class RangerServiceTest {

	@Resource(name="rangerService")
	private IRangerService rangerService;
	
	@Test
	public void testgetRanger_minusIndex() {
		/***Given***/
		int index = 2;
		
		/***When***/
		String ranger = rangerService.getRanger(index);
		
		/***Then***/
		assertEquals("sally", ranger);
		
		
	}

}
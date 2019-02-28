package kr.or.ddit.ranger.dao;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.test.LogicTestConfig;

public class RangerDaoTest extends LogicTestConfig{

	@Resource(name="rangerDao")
	private IRangerDao rangerDao;
	
	@Test
	public void testgetRanger_minusIndex() {
		/***Given***/
		int index = 2;
		
		/***When***/
		String ranger = rangerDao.getRanger(index);
		
		/***Then***/
		assertEquals("sally", ranger);
		
		
	}

}

package kr.or.ddit.ranger.service;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.test.LogicTestConfig;

public class RangerServiceTest extends LogicTestConfig{

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

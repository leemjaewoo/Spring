package kr.or.ddit.ranger.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import kr.or.ddit.test.LogicTestConfig;

public class RangerDaoTest extends LogicTestConfig{

	@Resource(name="rangerDao")
	private IRangerDao rangerDao;
	
	@Resource(name="datasource")
	private DataSource datasource;
	
	@Before
	public void setup(){
		ResourceDatabasePopulator rdp = new ResourceDatabasePopulator();
		rdp.addScript(new ClassPathResource("kr/or/ddit/config/db/init.sql"));
		rdp.setContinueOnError(false);
		DatabasePopulatorUtils.execute(rdp, datasource);
	}
	
	@Test
	public void testgetRanger_minusIndex() {
		/***Given***/
		int index = 2;
		
		/***When***/
		String ranger = rangerDao.getRanger(index);
		
		/***Then***/
		assertEquals("sally", ranger);
		
		
	}
	
	
	@Test
	public void testGetRangerDb(){
		/***Given***/
		
		
		
		
		/***When***/
		
		List<Map<String, String>> rangerList = rangerDao.getRangersDb();
		
		/***Then***/
		
		assertEquals(5, rangerList.size());

	}
	
	/**
	* Method : testGetRangerId
	* 작성자 : leemjaewoo
	* 변경이력 :
	* Method 설명 : 레인저 검색
	*/
	@Test
	public void testGetRangerId(){
		/***Given***/
		
		
		
		
		/***When***/
		
		Map<String, String> ranger = rangerDao.getRanger("brown");
				
		
		/***Then***/
		
		assertEquals("브라운", ranger.get("NAME"));

	}
	
	/**
	* Method : testInsertRanger
	* 작성자 : leemjaewoo
	* 변경이력 :
	* Method 설명 : 신규 레인저 등록 테스트
	*/
	@Test
	public void testInsertRanger(){
		/***Given***/
		
		Map<String, String> ranger = new HashMap<String, String>();
		ranger.put("id", "ryon");
		ranger.put("name", "라이언");
		
		
		/***When***/
		
		int insertRanger = rangerDao.insertRanger(ranger);
				
		
		/***Then***/
		
		assertEquals(1, insertRanger);

	}
	
	/**
	* Method : testInsertRanger
	* 작성자 : leemjaewoo
	* 변경이력 :
	* Method 설명 : 레인저 삭제
	*/
	@Test
	public void testDeleteRanger(){
		/***Given***/
		rangerDao.deleteRangerDept("james");
		
		/***When***/
		
		int deleteCnt = rangerDao.deleteRanger("james");
				
		
		/***Then***/
		assertNotNull(deleteCnt);
		//assertEquals("1", deleteCnt);

	}
	
	
	
	

}

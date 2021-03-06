package kr.or.ddit.ioc;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.ranger.dao.IRangerDao;
import kr.or.ddit.ranger.service.IRangerService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:kr/or/ddit/ioc/application-context-annotation.xml")
//설정정보
public class AnnotationScanTest {
	
	private Logger logger = LoggerFactory.getLogger(CollectionBeanTest.class);
	
	@Resource(name="rangerDaoImpl")
	private IRangerDao rangerDaoImpl;
	
	//rangerDao주입
	//rangerService주입
	@Resource(name="rangerServiceImpl")
	private IRangerService rangerServiceImpl;
	//두개의 스프링 변이 정상적으로 생성 되었는지 테스트

	@Test
	public void test() {
	/***Given***/
		List<String> list = rangerDaoImpl.getRangers();
		
	/***When***/
		for(String s : list) {
			logger.debug(s);
		}
		
		
	/***Then***/
		
	
	}
	
	/**
	* Method : testRangerSeriviceBean
	* 작성자 : leemjaewoo
	* 변경이력 :
	* Method 설명 : rangerServiceBean
	*/
	@Test
	public void testRangerSeriviceBean() {
		
	/***Given***/
		List<String> list = rangerServiceImpl.getRangers();
	/***When***/
		for(String s : list) {
			logger.debug(s);
		}

	/***Then***/
		assertNotNull(rangerServiceImpl);
		
	}

}

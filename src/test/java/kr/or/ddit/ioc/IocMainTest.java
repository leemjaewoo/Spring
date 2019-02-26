package kr.or.ddit.ioc;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.ranger.dao.IRangerDao;
import kr.or.ddit.ranger.service.IRangerService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:kr/or/ddit/ioc/application-context.xml")
public class IocMainTest {

	
	//rangerDao, rangerService
	
	
	//DI(dependency Injection)
	@Resource(name="rangerDaoSpringBean")
	private IRangerDao rangerDaoSpringBean;
	
	@Resource(name="rangerService")
	private IRangerService rangerService;
	
	@Resource(name="rangerDaoSpringBean")
	private IRangerDao rangerDao2;
	
	
	@Resource(name="rangerDao")
	private IRangerDao rangerDao3;
	
	
	@Resource(name="rangerDaoprotoType")
	private IRangerDao rangerDaoprotoType1;
	
	@Resource(name="rangerDaoprotoType")
	private IRangerDao rangerDaoprotoType2;
	
	
	
	@Test
	public void testRangerDao() {
		//기존방법
		//ApplicationContext context = new ....
		//DL을 통해 스프링 컨테이너에 스프링 빈을 요청
		//IrangerDao rangerDao = context.getBean("rangerDao")
		
		
		//변경방법
		//스프링 컨테이너 생성을 junit runner에게 위임
		//우리가 사용하고자 하는 객체를 DI(Dependency Injection)을 통해 주입받는다
		//@Autowired(스프링), @Resource (java표준)
		
		//테스트 대상
		//1.스프링빈이 정상적으로 생성되고, 주입이 문제가 없는지
		
		assertNotNull(rangerDaoSpringBean);
	}
	
	@Test
	public void testSpringSingleTonBean() {
		
		/***Given***/
		
		
		/***When***/

		
		/***Then***/
		assertEquals(rangerDaoSpringBean, rangerService);
		
	}
	
	/**
	* Method : testSpringSingleTonScope
	* 작성자 : leemjaewoo
	* 변경이력 :
	* Method 설명 : 같은 클래스로 선언된 
	*/
	@Test
	public void testSpringSingleTonScope() {
		
		/***Given***/
		
		
		/***When***/

		
		/***Then***/
		//디자인 패턴에 의하면 같은 클래스로부터 하나의 인스턴스만 존재하게 하는 패턴이 싱글톤
		
		
		assertNotEquals(rangerDaoSpringBean, rangerDao3);
		
		
	}
	
	
	@Test
	public void testSpringProtoTypeBean() {
		
		/***Given***/
		
		
		/***When***/

		
		/***Then***/
		//디자인 패턴에 의하면 같은 클래스로부터 하나의 인스턴스만 존재하게 하는 패턴이 싱글톤
		
		
		assertNotEquals(rangerDaoprotoType1, rangerDaoprotoType2);
		
		
	}
	
	
	
	

}

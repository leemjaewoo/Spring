package kr.or.ddit.ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import kr.or.ddit.ranger.dao.IRangerDao;
import kr.or.ddit.ranger.dao.RangerDaoImpl;
import kr.or.ddit.ranger.service.IRangerService;
import kr.or.ddit.ranger.service.RangerServiceImpl;

//해당 자바파일이 스프링 빈 설정 클래스임을 알려주는 어노테이션
//@Configuration
public class SpringJavaConfig {
	
	
	//<bean name="">
	@Bean
	public IRangerDao getIRangerDao() {
		IRangerDao rangerDao = new RangerDaoImpl();
		
		return rangerDao;
	}
	
	@Bean
	public IRangerService getIRangerService() {
		//rangerService에 주입해야하는 rangerDao 객체는 
		//스피링에서 관리되는 빈을 주입해야한다
		//*** 주입할 rangerDao를 new 연산자를 통해서 생성하면 된다
		
		IRangerService rangerservice = new RangerServiceImpl(getIRangerDao());
		
		
		
		return rangerservice;
	}
	
	

}

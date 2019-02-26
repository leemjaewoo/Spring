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


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:kr/or/ddit/ioc/application-context-placeholder.xml")
public class DbPropertiesTest {
	@Resource(name="dbProperties")
	private DbProperties dbProperties;
	private Logger logger = LoggerFactory.getLogger(DbPropertiesTest.class);
	
	@Test
	public void testPlaceholder() {
		/***Given***/
		String url = dbProperties.getUrl();
		String username = dbProperties.getUsername();
		String password = dbProperties.getPassword();
		String driverclassname = dbProperties.getDriverClassName();
		
		
		logger.debug("url : {}",url);
		logger.debug("url : {}",username);
		logger.debug("url : {}",password);
		logger.debug("url : {}",driverclassname);
		/***When***/

		
		
		/***Then***/
		
		

	}

}

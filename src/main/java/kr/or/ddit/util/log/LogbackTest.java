package kr.or.ddit.util.log;


import org.slf4j.LoggerFactory;

import java.util.HashMap;

import org.slf4j.Logger;

public class LogbackTest {
	
	private Logger logger = LoggerFactory.getLogger(LogbackTest.class);
	//<logger name="kr.or.ddit" level="DEBUG"/>
	
	public LogbackTest() {
		System.out.println("sysout :" + "Test");
		logger.trace("trace :" + "test");
		logger.debug("debug :" + "test");
		logger.info("info :" + "test");
		logger.warn("warn :" + "test");
		logger.error("error :" + "test");
		
		
		
		logger.error("error {}, {}, {}", "test" , "test", new HashMap<>());
		
		
	}
	
	public static void main(String[] args) {
		
		
		LogbackTest logbackTest = new LogbackTest();
		
		
		
	}

}

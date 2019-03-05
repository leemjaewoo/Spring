package kr.or.ddit.lprod.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProdVO{
	private Logger logger = LoggerFactory.getLogger(ProdVO.class);
	private String prod_id;
	private String prod_name;
	private String prod_lgu;
	private String prod_buyer;
	
	
	
	public String getProd_id() {
		return prod_id;
	}
	public void setProd_id(String prod_id) {
		this.prod_id = prod_id;
	}
	public String getProd_name() {
		return prod_name;
	}
	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}
	public String getProd_lgu() {
		return prod_lgu;
	}
	public void setProd_lgu(String prod_lgu) {
		this.prod_lgu = prod_lgu;
	}
	public String getProd_buyer() {
		return prod_buyer;
	}
	public void setProd_buyer(String prod_buyer) {
		this.prod_buyer = prod_buyer;
	}
	/*@Override
	public void valueBound(HttpSessionBindingEvent event) {
		HttpSession session = event.getSession();
		logger.debug("ProdVO valueBound : {}", session.getId() );
		
	}
	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		HttpSession session = event.getSession();
		logger.debug("ProdVO valueBound : {}", session.getId() );
		
	}*/
	

}

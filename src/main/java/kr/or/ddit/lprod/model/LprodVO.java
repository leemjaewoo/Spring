package kr.or.ddit.lprod.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LprodVO {
	
	private Logger logger = LoggerFactory.getLogger(LprodVO.class);
	
	private String lprod_id;
	private String lprod_gu;
	private String lprod_nm;
	
	
	public String getLprod_id() {
		return lprod_id;
	}
	public void setLprod_id(String lprod_id) {
		this.lprod_id = lprod_id;
	}
	public String getLprod_gu() {
		return lprod_gu;
	}
	public void setLprod_gu(String lprod_gu) {
		this.lprod_gu = lprod_gu;
	}
	public String getLprod_nm() {
		return lprod_nm;
	}
	public void setLprod_nm(String lprod_nm) {
		this.lprod_nm = lprod_nm;
	}
	
	
	@Override
	public String toString() {
		return "LprodVO [lprod_id=" + lprod_id + ", lprod_gu=" + lprod_gu + ", lprod_nm=" + lprod_nm + "]";
	}
	/*@Override
	public void valueBound(HttpSessionBindingEvent event) {
		HttpSession session = event.getSession();
		logger.debug("LprodVO valueBound : {}", session.getId() );
		
	}
	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		HttpSession session = event.getSession();
		logger.debug("LprodVO valueBound : {}", session.getId() );
		
	}*/
	
	
	

}

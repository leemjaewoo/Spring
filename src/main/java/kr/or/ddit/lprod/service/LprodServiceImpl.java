package kr.or.ddit.lprod.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.lprod.dao.ILprodDao;
import kr.or.ddit.lprod.model.LprodVO;
import kr.or.ddit.lprod.model.ProdVO;
import kr.or.ddit.util.model.PageVO;

@Service("lprodService")
public class LprodServiceImpl implements ILprodService {
	
	@Resource(name="lprodDao")
	private ILprodDao dao;
	public LprodServiceImpl() {
	}
	
	
	
	
	@Override
	public List<LprodVO> getAllLprod() {
		return dao.getAllLprod();
	}
	
	
	@Override
	public List<ProdVO> selectLprod(String lprod_gu) {
		List<ProdVO> a = dao.selectLprod(lprod_gu);
		 return a;
	}




	@Override
	public Map<String, Object> selectUserPagingList(PageVO pagevo) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		List<LprodVO> a = dao.selectLprodPagingList(pagevo);
		int b = dao.getLprodCnt();
		
		
		
		resultMap.put("lprodList",a);
		resultMap.put("lprodCnt",b);
		
		return resultMap;
	}
	
	


}

package kr.or.ddit.lprod.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.lprod.model.LprodVO;
import kr.or.ddit.lprod.model.ProdVO;
import kr.or.ddit.util.model.PageVO;

public interface ILprodService {
	
	/**
	* Method : getAllUser
	* 작성자 : leemjaewoo
	* 변경이력 :
	* @return
	* Method 설명 : 전체 사용자 조회
	*/
	List<LprodVO> getAllLprod();
	
	List<ProdVO> selectLprod(String lprod_gu);
	
	Map<String, Object> selectUserPagingList(PageVO pagevo);

}

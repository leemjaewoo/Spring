package kr.or.ddit.lprod.dao;

import java.util.List;

import kr.or.ddit.lprod.model.LprodVO;
import kr.or.ddit.lprod.model.ProdVO;
import kr.or.ddit.user.model.UserVO;
import kr.or.ddit.util.model.PageVO;

public interface ILprodDao {
	
	/**
	* Method : getAllUser
	* 작성자 : leemjaewoo
	* 변경이력 :
	* @return
	* Method 설명 : 전체 사용자 조회
	*/
	List<LprodVO> getAllLprod();
	List<ProdVO> selectLprod(String prod_lgu);
	
	
	/**
	* Method : selectUserPagingList
	* 작성자 : leemjaewoo
	* 변경이력 :
	* @param pagevo
	* @return
	* Method 설명 : 제품 페이징 리스트 조회
	*/
	List<LprodVO> selectLprodPagingList(PageVO pagevo);
	
	
	
	/**
	* Method : getUserCnt
	* 작성자 : leemjaewoo
	* 변경이력 :
	* @return
	* Method 설명 : 전체 제품 수를 조회
	*/
	int getLprodCnt();

}

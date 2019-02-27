package kr.or.ddit.ranger.dao;

import java.util.List;

public interface IRangerDao {
	
	 List<String> getRangers();
	 
	 /**
	* Method : getRanger
	* 작성자 : leemjaewoo
	* 변경이력 :
	* @param listIndex
	* @return
	* Method 설명 :listIndex에 해당하는 레이전 이름을 반환
	*/
	String getRanger(int listIndex);
		

}

package kr.or.ddit.user;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.user.model.UserVO;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.util.model.PageVO;

@RequestMapping("/user")
@Controller
public class UserController {
	
	@Resource(name="userService")
	private IUserService userService;
	
	/**
	* Method : userAllList
	* 작성자 : leemjaewoo
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 전체 리스트 조회
	*/
	@RequestMapping("/userAllList")
	public String userAllList(Model model){
		
		List<UserVO> userList = userService.getAllUser();
		
		
		model.addAttribute("userList", userList);
		
		return "user/userAllList";
		
	}
	
	
	@RequestMapping("/userPagingList")
	public String userPagingList(PageVO pageVo, Model model ){
		
		
		//PageVO pageVo = new PageVO(page, pageSize);
		
		Map<String, Object> resultMap =  userService.selectUserPagingList(pageVo);
		model.addAllAttributes(resultMap);
		
		model.addAttribute("pageSize", pageVo.getPageSize());
		model.addAttribute("page", pageVo.getPage());
		
		return "user/userPagingList";
		
	
	}

}

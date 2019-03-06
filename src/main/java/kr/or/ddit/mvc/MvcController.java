package kr.or.ddit.mvc;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.exception.NoFileException;
import kr.or.ddit.user.model.UserVO;
import kr.or.ddit.user.model.UserVoValidator;

@Controller
public class MvcController {
	private Logger logger = LoggerFactory.getLogger(MvcController.class);

	/**
	 * Method : view 작성자 : leemjaewoo 변경이력 :
	 * 
	 * @return Method 설명 : part를 테스트할 view 요청
	 */
	@RequestMapping("/mvc/view")
	public String view() {
		return "mvc/view";
	}

	/**
	* Method : fileupload
	* 작성자 : leemjaewoo
	* 변경이력 :
	* @return
	* Method 설명 : fileupload 처리 요청 테스트
	*/
	
	//파라미터 : userId (text), profile (file)
	@RequestMapping("/mvc/fileupload")
	public String fileupload(@RequestParam("userId") String userId, @RequestParam("profile")MultipartFile multipartFile){ 
		logger.debug("userId : {}", userId);
		logger.debug("getOriginalFileName : {}", multipartFile.getOriginalFilename());
		logger.debug("getName : {}", multipartFile.getName());
		logger.debug("size() : {}", multipartFile.getSize());
		
		String filename = multipartFile.getOriginalFilename() + ""
				+ UUID.randomUUID().toString();
		
		
		File profile = new File("c:\\picture\\" + filename);


		try {
			multipartFile.transferTo(profile);
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//multipartFile.transferTo(dest);
		
		
		return "mvc/view";
	}
	
	@RequestMapping("/textView")
	public String textView(){
		
		
		return "mvc/textView";
	}
	
	
	//@RequestParam 어노테이션 적용하지 않아도 인스턴스명이랑 동일하면 바인딩
	//파라미터명이랑 인스턴스 명이랑 다를경우 -->@RequestParam
	
	//BindingResult객체는 command객체 (vo)에 바인딩 과정에서 발생한 결과를 담는
	//객체로 반드시 command객체 매소드 인자 뒤에 위치 해야한다
	//O : UserVO userVo,BindingResult result ,Model model
	//X : UserVO userVo ,Model model,BindingResult result
	@RequestMapping("/textReq")
	public String textReq(UserVO userVo,BindingResult result ,Model model){
		new UserVoValidator().validate(userVo, result);
		logger.debug("userId : {}", userVo.getUserId());
		logger.debug("pass : {}", userVo.getPass());
		
		
		if(result.hasErrors()){
			logger.debug("has error");
			return "mvc/textView";
			
		}
		
		//pass : 8자리이상 
//		if( pass.length() < 8 ){
//			model.addAttribute("passwordLengthMsg", "비밀번호는 8자리 이상이어야 합니다");
//		}
		
		
		
		return "mvc/textView";
	}
	
	
	
	
	@RequestMapping("/textReqJsr303")
	public String textReqJsr303(@Valid UserVO userVo, BindingResult result){
		logger.debug("has Error(Jsr303) : {}",result.hasErrors()); 
		return "mvc/textView";
	}
	
	
	@RequestMapping("/textReqValJsr303")
	public String textReqValJsr303(@Valid UserVO userVo, BindingResult result){
		logger.debug("has Error(ValJsr303) : {}",result.hasErrors()); 
		return "mvc/textView";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.addValidators(new UserVoValidator());
	}
	
	
	/**
	* Method : throwArtihmeticException
	* 작성자 : leemjaewoo
	* 변경이력 :
	* @return
	* Method 설명 : arithmetic 예외 강제 발생
	*/
	@RequestMapping("/throwArith")
	public String throwArtihmeticException(){
		
		if(1==1)
		throw new ArithmeticException();
		return "mvc/textView";
	}
	
	
	
	@RequestMapping("/throwNoFileException")
	public String throwNoFileException() throws NoFileException{
		Resource resource = new ClassPathResource("kr/or/ddit/config/spring/no-exsits.xml");
		
		try {
			resource.getFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new NoFileException();
		}
		
		return "mvc/textView";
	}
	
	
	
	
	
	
	
	
	
	

}

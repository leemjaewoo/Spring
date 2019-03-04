package kr.or.ddit.mvc;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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

}

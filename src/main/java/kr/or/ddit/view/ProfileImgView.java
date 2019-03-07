package kr.or.ddit.view;

import java.io.File;
import java.io.FileInputStream;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.View;

import kr.or.ddit.user.model.UserVO;
import kr.or.ddit.user.service.IUserService;

public class ProfileImgView implements View{
	@Resource(name="userService")
	private IUserService userService;
	@Override
	public String getContentType() {
		return "image";
	}
	
	//개발자는 이미지 경로를 model객체에 "path"라는 속성으로 설정한다
	
	//개발자는 사용자 아이디를 model객체에 userId라는 속성으로 설정한다
	@Override
	public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		//response.setHeader("content-Disposition", "attachment; filename=profile.png"); 
		response.setContentType("image/png"); 
		
		//response.setContentType("image");
		//response.setContentType("application/octet-stream");
		
		String userId = (String)model.get("userId");
		
		UserVO vo = userService.selectUser(userId);
		FileInputStream fis;
		if(vo != null && vo.getRealFilename() != null) {
			 fis = new FileInputStream(new File(vo.getRealFilename()));
		}else {
			ServletContext application =  request.getServletContext();
			String noimgPath = application.getRealPath("/upload/noimage.jpg");
			fis = new FileInputStream(new File(noimgPath));
		}
		
		ServletOutputStream sos = response.getOutputStream();
		
		
		byte[] buff = new byte[512];
		int len = 0;
		while( (len = fis.read(buff)) > -1 ) {
			sos.write(buff);
		}
		
		sos.close();
		fis.close();
		
	}

}

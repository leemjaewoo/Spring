package kr.or.ddit.user.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UserVoValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return UserVO.class.isAssignableFrom(clazz);
		
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserVO userVo = (UserVO)target;
		
		//비밀번호는 8자리 이상어야 한다
		if(userVo.getPass().length() < 8){
			errors.rejectValue("pass", "passLen");

			
		}
		
		//사용자 아이디 검증 (반값이면 안된다)
		if(userVo.getUserId().equals("")){
			errors.rejectValue("userId", "required");
			
		}
		
		//사용자 아이디는 6자리 이상이어야 한다
		if(userVo.getUserId().length() < 6){
			errors.rejectValue("userId", "userIdLen");
		}
		
		
	}

}

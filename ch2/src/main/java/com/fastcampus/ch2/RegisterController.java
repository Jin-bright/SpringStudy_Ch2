package com.fastcampus.ch2;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

	//1) 회원가입 폼 전송 페이지 컨트롤러인데, 이 메서드는 회원가입창에 들어가는거니까 get 만해도 됨  
	// 그리고 이 메서드는 사실 하는 일이 없어서 view controller로 바꿔도된다 ? 
//	@RequestMapping("/register/add")
	
	/*
	 * @GetMapping("/register/add") public String register() { return
	 * "registerForm"; }
	 */
	
	
	//2) 폼이 전송되면 넘어간 페이지의 컨트롤러 (그 뷰단이랑 이어주는) 
//	@RequestMapping(value="/register/save", method=RequestMethod.POST) //post 요청으로만 되게끔하기 

	// 스프링 버전 4.3부터 지원 -- postmapping 
	@PostMapping("/register/save")
	public String save(User user, Model model) throws Exception {
		// 여기 선언한 모델은 register/save에 쓰는 모델이라서 딴데 리다이렉트해서 딴 페이지로 가면 쓸수없다 ex)에러메세지
		// 근데 메세지같은 경우는 spring에서 알아서 리턴하는 페이지로 해당 메세지를 넘겨줌 왜냠 .. .
		
		//1. 폼에 입력한 값이 정확한 값인지 유효성 검사를 하고 이 값들을 가져와서 모델에 저장 ? 그래야 꺼내쓰나 ? (근데 이거 jsp에서 한거 또하나?) 
		if(!isValid(user)) {
			
			String msg = URLEncoder.encode("id를 잘못입력하셨습니다","utf-8"); // 이걸 jsp에서도 decode를 해줘야 잘나옴

			model.addAttribute("msg", msg);			
			return "redirect:/register/add";//url재작성 		
//			return "redirect:/register/add?msg="+msg;//url재작성 
		}
		
		
		//2. 회원정보 DB에 저장 
		return "registerInfo";
	}

	private boolean isValid(User user) {
		return true;
	}
	
}

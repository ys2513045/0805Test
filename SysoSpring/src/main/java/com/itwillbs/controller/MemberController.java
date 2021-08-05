package com.itwillbs.controller;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itwillbs.domain.ItemVO;
import com.itwillbs.domain.MemberVO;
import com.itwillbs.service.MemberService;

@Controller
public class MemberController {

	@Inject
	private MemberService service;

	@RequestMapping(value = "/member/join", method = RequestMethod.GET)
	public String join() {
		System.out.println("MainController /join");

		return "./member/joinForm";
	}

	@RequestMapping(value = "/member/joinPro", method = RequestMethod.POST)
	public String join(@ModelAttribute("vo") MemberVO vo) {
		System.out.println("joinPro 왔음");

		System.out.println(vo.getMember_id());
		System.out.println(vo.getMember_name());

		service.memberJoinProcess(vo);

		return "redirect:certification";
	}

	@RequestMapping(value = "/certification", method = RequestMethod.GET)
	public String cert() {
		System.out.println("MainController /join");

		return "./member/certification";
	}

	@RequestMapping(value = "/joinconfirm", method = RequestMethod.GET)
	public String emailConfirm(@ModelAttribute("vo") MemberVO vo, Model model) throws Exception {
		System.out.println(vo.getMember_email() + ": auth confirmed");
		vo.setMember_authStatus(1); // authstatus를 1로,, 권한 업데이트
		service.updateAuthstatus(vo);

		model.addAttribute("name", vo.getMember_name());

		return "./member/joinconfirm";
	}

	@RequestMapping(value = "/checkDup", method = RequestMethod.POST)
	public @ResponseBody int checkDup(@RequestBody MemberVO vo) {

		System.out.println("member_id : " + vo.getMember_id());

		int cnt = service.checkDup(vo.getMember_id());
		System.out.println("cnt :  " + cnt);

		return cnt;
	}

	// 로그인
	@RequestMapping(value = "/member/login", method = RequestMethod.GET)
	public String login(MemberVO vo) {
		System.out.println("MainController /login");

		return "/member/loginForm";
	}

	@RequestMapping(value = "/member/loginPro", method = RequestMethod.POST)
	public String loginPro(MemberVO vo, HttpSession session, Model model) {

		MemberVO vo2 = service.userCheck(vo);

		if (vo2 != null) {
			// id, pass 일치시
			// session 값 생성
			session.setAttribute("id", vo.getMember_id());
			return "redirect:/home";

		} else {
			// id, pass 불일치
			// 메시지 뿌리고 뒤로이동
			model.addAttribute("msg", "입력하신 정보는 틀립니다.");

			return "/member/msg/msg";

		}

	}

	// logout
	@RequestMapping(value = "/member/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		System.out.println("MainController /logout");

		session.invalidate();

		return "redirect:/home";
	}

//	@RequestMapping(value = "/member/update", method = RequestMethod.GET)
//	public String update(HttpSession session, Model model) {
//		
//		MemberVO vo = service.getMember((String)session.getAttribute("id")); 
//		
//		model.addAttribute("vo", vo);
//		
//		return "/member/updateForm";
//	}
//	
//	@RequestMapping(value = "/member/updatePro", method = RequestMethod.POST)
//	public String updatePro(MemberVO vo, Model model) {
//		
//		MemberVO mb2 = memberService.userCheck(vo);
//		
//		if(mb2 != null) {
//			service.updateMember(vo);
//			return "redirect:/member/main";
//		} else {
//			model.addAttribute("msg", "입력하신 정보가 틀립니다.");
//			return "/member/msg";
//		}
//		
//	}

}
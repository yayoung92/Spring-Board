package com.lcomputerstudy.example.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lcomputerstudy.example.domain.Board;
import com.lcomputerstudy.example.domain.User;
import com.lcomputerstudy.example.service.BoardService;
import com.lcomputerstudy.example.service.UserService;

@org.springframework.stereotype.Controller
public class Controller {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired UserService userservice;
	@Autowired BoardService boardservice;
	@Autowired PasswordEncoder passwordEncoder;
	
	/*public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}*/
	
	@RequestMapping("/")
	public String home(Model model) {
		List<Board> list = boardservice.selectBoardList();
		model.addAttribute("list", list);
		logger.debug("debug");
		logger.info("info");
		logger.error("error");
		return "/index";
	}
	@RequestMapping("/beforeSignUp")
	public String beforeSignUp() {
		return "/signup";
	}
	@RequestMapping("/signup")
	public String signup(User user) {
		//비밀번호 암호화
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		//유저 데이터 세팅
		user.setPassword(encodedPassword);
		user.setAccountNonExpired(true);	//계정이 만료되지 않았다(true)
		user.setEnabled(true);				//계정이 사용가능하다(true) 계정 활성화여부
		user.setAccountNonLocked(true);		//계정이 잠겨있지 않다(true)
		user.setCredentialsNonExpired(true);//계정의 패스워드가 만료되지 않았다(true)
		user.setAuthorities(AuthorityUtils.createAuthorityList("ROLE_USER"));
		//유저 생성
		userservice.createUser(user);
		//유저 권한 생성
		userservice.createAuthorities(user);
		return "/login";
	}
	@RequestMapping(value="/login")
	public String beforeLogin(Model model) {
		return "/login";
	}
//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public String login(@RequestParam("username") String username, 
//	                    @RequestParam("password") String password,
//	                    HttpSession session) {
//
//	        session.setAttribute("user", username);
//	        return "/login"; 
//	}

	@Secured({"ROLE_ADMIN"})
	@RequestMapping(value="/admin")
	public String admin(Model model) {
		return "/admin";
	}
	@Secured({"ROLE_USER"})
	@RequestMapping(value="/user/info")
	public String userInfo(Model model) {
		return "/user_info";
	}
	@RequestMapping(value="/denied")
	public String denied(Model model) {
		return "/denied";
	}
	@RequestMapping("insert-view")
	public String insert(Model model) {
		return "/insert";
	}
	@RequestMapping(value="/insertBoard")
	public String insertBoard(Board board){
	//	String userId = (String) session.getAttribute("user");
	//	board.setbWriter(userId);
		boardservice.insertBoard(board);
		return "/insert-result";
	}
	@RequestMapping("/list")
	public String list(Model model) {
		List<Board> list = boardservice.selectBoardList();
		model.addAttribute("list", list);
		return "/list";
	}
	
}

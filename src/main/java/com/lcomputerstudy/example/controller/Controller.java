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
		//��й�ȣ ��ȣȭ
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		//���� ������ ����
		user.setPassword(encodedPassword);
		user.setAccountNonExpired(true);	//������ ������� �ʾҴ�(true)
		user.setEnabled(true);				//������ ��밡���ϴ�(true) ���� Ȱ��ȭ����
		user.setAccountNonLocked(true);		//������ ������� �ʴ�(true)
		user.setCredentialsNonExpired(true);//������ �н����尡 ������� �ʾҴ�(true)
		user.setAuthorities(AuthorityUtils.createAuthorityList("ROLE_USER"));
		//���� ����
		userservice.createUser(user);
		//���� ���� ����
		userservice.createAuthorities(user);
		return "/login";
	}
	@RequestMapping(value="/login")
	public String beforeLogin(Model model) {
		return "/login";
	}
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
	public String insertBoard(Board board) {
		boardservice.insertBoard(board);
		return "/insert-result";
	}
	@RequestMapping("/list")
	public String list(Model model) {
		List<Board> list = boardservice.selectBoardList();
		model.addAttribute("list", list);
		return "/list";
	}
	@RequestMapping("/detail")
	public String detailBoard(@RequestParam("bId") int bId, Model model) {
		boardservice.viewsBoard(bId);
		Board board = boardservice.detailBoard(bId);
		
		model.addAttribute("board", board);
		
		return "/detail";
	}
	@RequestMapping("/update-view")
	public String getBoard(@RequestParam("bId") int bId, Model model) {
		Board board = boardservice.getBoard(bId);
		model.addAttribute("board", board);
		return "/update";
	}
	@RequestMapping("/updateBoard")
	public String updateBoard(Board board) {
		boardservice.updateBoard(board);
		return "/update-result";
	}
	@RequestMapping("/delete")
	public String deleteBoard(@RequestParam("bId") int bId, Model model) {
		boardservice.deleteBoard(bId);
		return "/delete";
	}
	@RequestMapping("/reply-view")
	public String reply(@RequestParam("bId") int bId, Model model) {
		model.addAttribute("bId", bId);
		return "/reply";
	}
	@RequestMapping("/reBoard")
	public String reBoard(@RequestParam("bId") int bId, Board board) {
		Board board1 = boardservice.getBoard(bId);
		board.setbGroup(board1.getbId());
		boardservice.reBoard(board);
		return "/insert-result";
	}
	
}

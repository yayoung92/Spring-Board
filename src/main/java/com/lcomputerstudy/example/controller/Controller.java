package com.lcomputerstudy.example.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.lcomputerstudy.example.domain.Board;
import com.lcomputerstudy.example.domain.User;
import com.lcomputerstudy.example.domain.Files;
import com.lcomputerstudy.example.domain.Comment;
import com.lcomputerstudy.example.domain.LevelVO;
import com.lcomputerstudy.example.domain.Pagination;
import com.lcomputerstudy.example.domain.SearchVO;
import com.lcomputerstudy.example.service.BoardService;
import com.lcomputerstudy.example.service.UserService;
import com.lcomputerstudy.example.service.FilesService;
import com.lcomputerstudy.example.service.CommentService;

@org.springframework.stereotype.Controller
public class Controller {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired UserService userservice;
	@Autowired BoardService boardservice;
	@Autowired FilesService filesservice;
	@Autowired CommentService commentservice;
	@Autowired PasswordEncoder passwordEncoder;
	
	/*public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}*/
	@RequestMapping("/form")
	public String form() {
		return "/form";
	}
	@RequestMapping("/")
	public String home(Model model) {
		List<Board> list = boardservice.BoardList();
		model.addAttribute("list", list);
		logger.debug("debug");
		logger.info("info");
		logger.error("error");
		return "/index";
	}
	@RequestMapping("/beforeSignUp")
	public String beforeSignUp(User user) {
		userservice.levelupdate(user);
		return "/signup";
	}
	@RequestMapping("/signup")
	public String signup(User user) {
		//占쏙옙橘占싫� 占쏙옙호화
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		//占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙
		user.setPassword(encodedPassword);
		user.setAccountNonExpired(true);	//占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙占� 占십았댐옙(true)
		user.setEnabled(true);				//占쏙옙占쏙옙占쏙옙 占쏙옙諛∽옙占쏙옙求占�(true) 占쏙옙占쏙옙 활占쏙옙화占쏙옙占쏙옙
		user.setAccountNonLocked(true);		//占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙占� 占십댐옙(true)
		user.setCredentialsNonExpired(true);//占쏙옙占쏙옙占쏙옙 占싻쏙옙占쏙옙占썲가 占쏙옙占쏙옙占쏙옙占� 占십았댐옙(true)
		user.setAuthorities(AuthorityUtils.createAuthorityList("ROLE_USER"));
		//占쏙옙占쏙옙 占쏙옙占쏙옙
		userservice.createUser(user);
		//占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙
		userservice.createAuthorities(user);
		userservice.levelupdate(user);
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
	@RequestMapping("/u_list")
	public String userlist(Model model, Pagination pagination) {
		int total = userservice.getUserCount();
		
		pagination.setCount(total);
		pagination.init();
		List<User> list = userservice.getUser(pagination);
		for(User user: list) {
			userservice.levelupdate(user);
			if(user.getuLevel() >= 5) {
				user.setuLevelname("관리자");
			} else if(user.getuLevel() == 3 || user.getuLevel() == 4) {
				user.setuLevelname("우수회원");
			} else {
				user.setuLevelname("일반회원");
			}
		}
		model.addAttribute("list", list);
		model.addAttribute("pagination", pagination);
		
		return "/u_list";
	}
	@RequestMapping("aj-user-level")
	public String userlevelupdate(Model model, LevelVO levelVO, Pagination pagination) {
		int total = userservice.getUserCount();
		
		pagination.setCount(total);
		pagination.init();
		
		userservice.levelUser(levelVO);
		
		List<User> list = userservice.getUser(pagination);
		for(User user1: list) {
			userservice.levelupdate(user1);
			if(user1.getuLevel() >= 5) {
				user1.setuLevelname("관리자");
			} else if(user1.getuLevel() == 3 || user1.getuLevel() == 4) {
				user1.setuLevelname("우수회원");
			} else {
				user1.setuLevelname("일반회원");
			}
		}
		model.addAttribute("list", list);
		model.addAttribute("pagination", pagination);
		return "/u_listt";
	}
	@RequestMapping("insert-view")
	public String insert(Model model) {
		return "/insert";
	}
	//Part 이용한 파일 업로드
	/*
	@RequestMapping("/insertBoard")
	public String insertBoard(Board board, @RequestParam("filename") Part part){
		
		String filename = boardservice.getFilename(part);
		try {
			if(!filename.isEmpty()) {
				part.write("C:\\Users\\L10B\\Documents\\work2\\lcomputerstudyyy\\static\\img\\" + filename);
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		board.setfName(filename);
		boardservice.insertBoard(board);
		int bId = board.getbId();
		boardservice.groupUpdate(bId);
		return "/insert-result";
	}
	*/
	@RequestMapping("/insertBoard")
	public String insertBoard(Board board, @RequestParam("files") MultipartFile[] file){
		boardservice.insertBoard(board);
		int bId = board.getbId();
		boardservice.groupUpdate(bId);
		
		for(MultipartFile files : file) {
			if(!files.isEmpty()) {
				filesservice.uploadFile(file, bId);
			}
		}
		return "/insert-result";
	}
	@RequestMapping("/list")
	public String list(Model model, SearchVO searchvo, Pagination pagination) {
		int total = boardservice.getTotal(searchvo);
		
		pagination.setSearchVO(searchvo);
		
		pagination.setCount(total);
		pagination.init();
		
		List<Board> list = boardservice.selectBoardList(pagination);
		model.addAttribute("list", list);
		model.addAttribute("pagination", pagination);
		return "/list";
	}
	@RequestMapping("/detail")
	public String detailBoard(@RequestParam("bId") int bId, Model model) {
		boardservice.viewsBoard(bId);
		Board board = boardservice.detailBoard(bId);
		List<Comment> comment = commentservice.CommentList(bId);
		List<Files> files = filesservice.FilesList(bId);
		model.addAttribute("board", board);
		model.addAttribute("comment", comment);
		model.addAttribute("file", files);
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
		filesservice.deleteFiles(bId);
		return "/delete";
	}
	@RequestMapping("/reply-view")
	public String reply(@RequestParam("bId") int bId, Model model) {
		model.addAttribute("bId", bId);
		return "/reply";
	}
	@RequestMapping("reBoard")
	public String reBoard(@RequestParam("bId") int bId, Board board) {
		Board board1 = boardservice.getBoard(bId);
		board.setbGroup(board1.getbGroup());
		board.setbOrder(board1.getbOrder());
		board.setbDepth(board1.getbDepth());
		boardservice.reGroupUpdate(board);
		boardservice.reBoard(board);
		return "/insert-result";
	}
	@RequestMapping("/insertComment")
	public String insertComment(@RequestParam("bId") int bId, Comment comment) {
		commentservice.insertComment(comment);
		int cId = comment.getcId();
		commentservice.groupCupdate(cId);
		return "redirect:/detail?bId=" + bId;
	}
	@RequestMapping("deleteComment")
	public String deleteComment(@RequestParam("cId") int cId, @RequestParam("bId") int bId, Model model) {
		commentservice.deleteComment(cId);
		return "redirect:/detail?bId=" + bId;
	}
	@RequestMapping("/aj-comment-reReply")
	public String reComment(@RequestParam("cId") int cId, @RequestParam("bId") int bId, Comment comment, Model model) {
		Comment comment1 = commentservice.getComment(cId);
		comment.setcGroup(comment1.getcGroup());
		comment.setcOrder(comment1.getcOrder());
		comment.setcDepth(comment1.getcDepth());
		commentservice.reCCroupUpdate(comment);
		commentservice.reComment(comment);
		
		List<Comment> comment11 = commentservice.CommentList(bId);
		model.addAttribute("comment", comment11);
		return "/c_list";
	}
	@RequestMapping("/aj-comment-reDelete")
	public String deleteReComment(@RequestParam("cId") int cId, @RequestParam("bId") int bId, Model model) {
		commentservice.deleteComment(cId);
		
		List<Comment> comment11 = commentservice.CommentList(bId);
		model.addAttribute("comment", comment11);
		return "/c_list";
	}
	@RequestMapping("/aj-comment-reUpdate")
	public String updateReComment(@RequestParam("bId") int bId, Comment comment, Model model) {
		commentservice.updateComment(comment);
		
		List<Comment> comment11 = commentservice.CommentList(bId);
		model.addAttribute("comment", comment11);
		return "/c_list";
	}
}

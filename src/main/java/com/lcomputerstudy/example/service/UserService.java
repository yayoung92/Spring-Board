package com.lcomputerstudy.example.service;

import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.lcomputerstudy.example.domain.LevelVO;
import com.lcomputerstudy.example.domain.Pagination;
import com.lcomputerstudy.example.domain.User;

public interface UserService extends UserDetailsService {
	//�����б�
	public User readUser(String username);
	
	//��������
	public void createUser(User user);
	
	//���ѻ���
	public void createAuthorities(User user);
	
	//��ť��Ƽ ���� ���
	Collection<GrantedAuthority> getAuthorities(String username);
	//유저 레벨 업데이트
	public void levelupdate(User user);
		
	//유저 레벨
	public void levelUser(LevelVO levelVO);
		
	//유저 세기
	public int getUserCount();
		
	//유저리스트
	public List<User> getUser(Pagination pagination);
}

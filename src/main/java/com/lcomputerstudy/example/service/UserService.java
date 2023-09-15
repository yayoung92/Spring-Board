package com.lcomputerstudy.example.service;

import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
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
}

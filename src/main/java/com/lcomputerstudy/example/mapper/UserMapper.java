package com.lcomputerstudy.example.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.security.core.GrantedAuthority;
import com.lcomputerstudy.example.domain.User;

@Mapper
public interface UserMapper {
	//�����б�
	public User readUser(String username);
	
	//��������
	public void createUser(User user);
	
	//���� �б�
	public List<GrantedAuthority> readAuthorities(String username);
	
	//���� ����
	public void createAuthority(User user);
}

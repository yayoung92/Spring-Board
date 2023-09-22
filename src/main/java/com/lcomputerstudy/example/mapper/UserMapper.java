package com.lcomputerstudy.example.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.security.core.GrantedAuthority;

import com.lcomputerstudy.example.domain.LevelVO;
import com.lcomputerstudy.example.domain.Pagination;
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
	
	//유저 레벨 업데이트
	public void levelupdate(User user);
	
	//유저 레벨
	public void levelUser(LevelVO levelVO);
	
	//유저 세기
	public int getUserCount();
	
	//유저리스트
	public List<User> getUser(Pagination pagination);
	
}

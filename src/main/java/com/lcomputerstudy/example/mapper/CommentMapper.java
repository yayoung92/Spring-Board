package com.lcomputerstudy.example.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.lcomputerstudy.example.domain.Comment;

@Mapper
public interface CommentMapper {
	public List<Comment> CommentList(int bId);
	//��� �ۼ�
	public void insertComment(Comment comment);
	//��� ����
	public void deleteComment(int cId);
	//��� ����
	public void updateComment(Comment comment);
	//��� �ۼ� �� group ����
	public void groupCupdate(int cId);
	//���� �ۼ� �� group ����
	public void reCCroupUpdate(Comment comment);
	//���� �ۼ�
	public void reComment(Comment comment);
	//��� ����
	public Comment getComment(int cId);
}

package com.lcomputerstudy.example.service;

import java.util.List;
import com.lcomputerstudy.example.domain.Comment;

public interface CommentService {
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

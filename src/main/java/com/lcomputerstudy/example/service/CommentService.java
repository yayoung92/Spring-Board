package com.lcomputerstudy.example.service;

import java.util.List;
import com.lcomputerstudy.example.domain.Comment;

public interface CommentService {
	public List<Comment> CommentList(int bId);
	//댓글 작성
	public void insertComment(Comment comment);
	//댓글 삭제
	public void deleteComment(int cId);
	//댓글 수정
	public void updateComment(Comment comment);
	//댓글 작성 시 group 정리
	public void groupCupdate(int cId);
	//대댓글 작성 시 group 정리
	public void reCCroupUpdate(Comment comment);
	//대댓글 작성
	public void reComment(Comment comment);
	//댓글 선택
	public Comment getComment(int cId);
}

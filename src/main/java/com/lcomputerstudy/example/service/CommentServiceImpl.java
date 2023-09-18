package com.lcomputerstudy.example.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lcomputerstudy.example.domain.Comment;
import com.lcomputerstudy.example.mapper.CommentMapper;

@Service("CommentServiceImpl")
public class CommentServiceImpl implements CommentService {
	@Autowired CommentMapper commentmapper;
	@Override
	public List<Comment> CommentList(int bId) {
		return commentmapper.CommentList(bId);
	}
	@Override
	public void insertComment(Comment comment) {
		commentmapper.insertComment(comment);
	}
	@Override
	public void deleteComment(int cId) {
		commentmapper.deleteComment(cId);
	}
	@Override
	public void updateComment(Comment comment) {
		commentmapper.updateComment(comment);
	}
	@Override
	public void groupCupdate(int cId) {
		commentmapper.groupCupdate(cId);
	}
	@Override
	public void reCCroupUpdate(Comment comment) {
		commentmapper.reCCroupUpdate(comment);
	}
	@Override
	public void reComment(Comment comment) {
		commentmapper.reComment(comment);
	}
	@Override
	public Comment getComment(int cId) {
		return commentmapper.getComment(cId);
	}

}

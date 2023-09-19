package com.lcomputerstudy.example.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lcomputerstudy.example.domain.Board;
import com.lcomputerstudy.example.mapper.BoardMapper;

@Service("BoardServiceImpl")
public class BoardServiceImpl implements BoardService {
	@Autowired BoardMapper boardmapper;
	@Override
	public List<Board> BoardList() {
		return boardmapper.BoardList();
	}
	@Override
	public List<Board> selectBoardList(Board board) {
		return boardmapper.selectBoardList(board);
	}
	@Override
	public void insertBoard(Board board) {
		boardmapper.insertBoard(board);
	}
	@Override
	public Board detailBoard(int bId) {
		return boardmapper.detailBoard(bId);
	}
	@Override
	public void deleteBoard(int bId) {
		boardmapper.deleteBoard(bId);
	}
	@Override
	public void viewsBoard(int bId) {
		boardmapper.viewsBoard(bId);
	}
	@Override
	public void updateBoard(Board board) {
		boardmapper.updateBoard(board);
	}
	@Override
	public Board getBoard(int bId) {
		return boardmapper.getBoard(bId);
	}
	@Override
	public void groupUpdate(int bId) {
		boardmapper.groupUpdate(bId);
	}
	@Override
	public void reBoard(Board board) {
		boardmapper.reBoard(board);
	}
	@Override
	public void reGroupUpdate(Board board) {
		boardmapper.reGroupUpdate(board);
	}
}

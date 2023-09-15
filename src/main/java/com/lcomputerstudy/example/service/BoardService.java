package com.lcomputerstudy.example.service;

import java.util.List;
import com.lcomputerstudy.example.domain.Board;

public interface BoardService {
	public List<Board> selectBoardList();
	//게시글 작성
	public void insertBoard(Board board);
	//게시글 리스트
	public List<Board> getBoards();
}

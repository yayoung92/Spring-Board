package com.lcomputerstudy.example.service;

import java.util.List;
import com.lcomputerstudy.example.domain.Board;

public interface BoardService {
	public List<Board> selectBoardList();
	//�Խñ� �ۼ�
	public void insertBoard(Board board);
	//�Խñ� ����Ʈ
	public List<Board> getBoards();
}

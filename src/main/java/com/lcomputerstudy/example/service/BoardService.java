package com.lcomputerstudy.example.service;

import java.util.List;
import com.lcomputerstudy.example.domain.Board;
import com.lcomputerstudy.example.domain.SearchVO;
import com.lcomputerstudy.example.domain.Pagination;

public interface BoardService {
	public List<Board> BoardList();
	public List<Board> selectBoardList(Pagination pagination);
	//�Խñ� �ۼ�
	public void insertBoard(Board board);
	//�Խñ� ��������
	public Board detailBoard(int bId);
	//�Խñ� ����
	public void deleteBoard(int bId);
	//�Խñ� Ŭ����
	public void viewsBoard(int bId);
	//�Խñ� �����ϱ�
	public void updateBoard(Board board);
	//�Խñ� ����
	public Board getBoard(int bId);
	//group update
	public void groupUpdate(int bId);
	//��� �ۼ�
	public void reBoard(Board board);
	//��� group update
	public void reGroupUpdate(Board board);
	//총 게시물 갯수
	public int getTotal(SearchVO searchvo);
}

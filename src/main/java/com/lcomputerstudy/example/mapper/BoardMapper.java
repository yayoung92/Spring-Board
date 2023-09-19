package com.lcomputerstudy.example.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.lcomputerstudy.example.domain.Board;

@Mapper
public interface BoardMapper {
	public List<Board> BoardList();
	public List<Board> selectBoardList(Board board);
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
	//��� �ޱ�
	public void reBoard(Board board);
	//��� group update
	public void reGroupUpdate(Board board);
}

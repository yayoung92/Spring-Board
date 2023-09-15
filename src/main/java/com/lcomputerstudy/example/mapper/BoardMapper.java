package com.lcomputerstudy.example.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.lcomputerstudy.example.domain.Board;

@Mapper
public interface BoardMapper {
	public List<Board> selectBoardList();
	//�Խñ� �ۼ�
	public void insertBoard(Board board);
	//�Խñ� ����Ʈ
	public List<Board> getBoards();
}

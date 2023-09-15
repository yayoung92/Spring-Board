package com.lcomputerstudy.example.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.lcomputerstudy.example.domain.Board;

@Mapper
public interface BoardMapper {
	public List<Board> selectBoardList();
	//게시글 작성
	public void insertBoard(Board board);
	//게시글 리스트
	public List<Board> getBoards();
}

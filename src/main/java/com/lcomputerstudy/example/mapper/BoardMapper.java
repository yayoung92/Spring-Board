package com.lcomputerstudy.example.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.lcomputerstudy.example.domain.Board;

@Mapper
public interface BoardMapper {
	public List<Board> selectBoardList();
	//게시글 작성
	public void insertBoard(Board board);
	//게시글 상세페이지
	public Board detailBoard(int bId);
	//게시글 삭제
	public void deleteBoard(int bId);
	//게시글 클릭수
	public void viewsBoard(int bId);
	//게시글 수정하기
	public void updateBoard(Board board);
	//게시글 선택
	public Board getBoard(int bId);
	//group update
	public void groupUpdate(int bId);
	//답글 달기
	public void reBoard(Board board);
	//답글 group update
	public void reGroupUpdate(Board board);
}

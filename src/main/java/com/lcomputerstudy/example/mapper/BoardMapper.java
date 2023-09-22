package com.lcomputerstudy.example.mapper;

import java.util.List;

import javax.servlet.http.Part;

import org.apache.ibatis.annotations.Mapper;
import com.lcomputerstudy.example.domain.Board;
import com.lcomputerstudy.example.domain.Pagination;
import com.lcomputerstudy.example.domain.SearchVO;

@Mapper
public interface BoardMapper {
	public List<Board> BoardList();
	public List<Board> selectBoardList(Pagination pagination);
	//占쌉시깍옙 占쌜쇽옙
	public void insertBoard(Board board);
	//占쌉시깍옙 占쏙옙占쏙옙占쏙옙占쏙옙
	public Board detailBoard(int bId);
	//占쌉시깍옙 占쏙옙占쏙옙
	public void deleteBoard(int bId);
	//占쌉시깍옙 클占쏙옙占쏙옙
	public void viewsBoard(int bId);
	//占쌉시깍옙 占쏙옙占쏙옙占싹깍옙
	public void updateBoard(Board board);
	//占쌉시깍옙 占쏙옙占쏙옙
	public Board getBoard(int bId);
	//group update
	public void groupUpdate(int bId);
	//占쏙옙占� 占쌨깍옙
	public void reBoard(Board board);
	//占쏙옙占� group update
	public void reGroupUpdate(Board board);
	//珥� 寃뚯떆臾� 媛��닔
	public int getTotal(SearchVO searchvo);
	//파일업로드
	public String getFilename(Part part);
}

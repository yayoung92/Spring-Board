package com.lcomputerstudy.example.service;

import java.util.List;

import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lcomputerstudy.example.domain.Board;
import com.lcomputerstudy.example.domain.Pagination;
import com.lcomputerstudy.example.domain.SearchVO;
import com.lcomputerstudy.example.mapper.BoardMapper;

@Service("BoardServiceImpl")
public class BoardServiceImpl implements BoardService {
	@Autowired BoardMapper boardmapper;
	@Override
	public List<Board> BoardList() {
		return boardmapper.BoardList();
	}
	@Override
	public List<Board> selectBoardList(Pagination pagination) {
		return boardmapper.selectBoardList(pagination);
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
	@Override
	public int getTotal(SearchVO searchvo) {
		return boardmapper.getTotal(searchvo);
	}
	@Override
	public String getFilename(Part part) {
		String contentDisp = part.getHeader("content-disposition");
        String[] split = contentDisp.split(";");
        for (int i = 0; i < split.length; i++) {
            String temp = split[i];
            if (temp.trim().startsWith("filename")) {
                return temp.substring(temp.indexOf("=") + 2, temp.length() - 1);
            }
        }
        return "";
	}
}

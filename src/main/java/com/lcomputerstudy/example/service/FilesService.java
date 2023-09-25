package com.lcomputerstudy.example.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import com.lcomputerstudy.example.domain.Files;

public interface FilesService {
	//파일 업로드
	public void uploadFile(MultipartFile[] file, int bId);
	//파일 리스트
	public List<Files> FilesList(int bId);
	//파일 등록
	public void insertFiles(Files files);
	//파일 삭제
	public void deleteFiles(int bId);
	public void selectdeleteFiles(int fId);
	//파일 선택
	public Files getFiles(int fId);
	//파일 수정
	public void updateFiles(Files files);
}

package com.lcomputerstudy.example.service;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.lcomputerstudy.example.domain.Files;
import com.lcomputerstudy.example.mapper.FilesMapper;

@Service("FilesServiceImpl")
public class FilesServiceImpl implements FilesService {
	@Autowired FilesMapper filesmapper;
	@Autowired
	private ResourceLoader resourceLoader;
	
	LocalDateTime now = LocalDateTime.now();
	String formateNow = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ee"));
	@Override
	public void uploadFile(MultipartFile[] files, int bId) {
		for(MultipartFile file : files) {
			if(!file.isEmpty()) {
				try {
					String originalFileName = file.getOriginalFilename();
					String fileName = formateNow + UUID.randomUUID().toString();
					Files newfiles = new Files();
					newfiles.setfName(fileName);
					newfiles.setfOrigin(originalFileName);
					newfiles.setbId(bId);
					
					String uploadDir = "/static/img/";
					
					Resource resource = resourceLoader.getResource("classpath:" + uploadDir);
					String uploadPath = resource.getFile().getAbsolutePath();
					
					File uploadDirFile = new File(uploadPath);
					if(!uploadDirFile.exists()) {
						uploadDirFile.mkdirs();
					}
					File f = new File(uploadDirFile, fileName);
					file.transferTo(f);
					
					filesmapper.insertFiles(newfiles);
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	@Override
	public List<Files> FilesList(int bId) {
		return filesmapper.FilesList(bId);
	}
	@Override
	public void insertFiles(Files files) {
		filesmapper.insertFiles(files);
	}
	@Override
	public void deleteFiles(int bId) {
		filesmapper.deleteFiles(bId);
	}
	@Override
	public void selectdeleteFiles(int fId) {
		filesmapper.selectdeleteFiles(fId);
	}
	@Override
	public Files getFiles(int fId) {
		return filesmapper.getFiles(fId);
	}
	@Override
	public void updateFiles(Files files) {
		filesmapper.updateFiles(files);
	}
}

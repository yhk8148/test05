package com.care.root.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.care.root.dto.ShoesDTO;
import com.care.root.mybatis.FileMapper;

@Service
public class FileServiceImpl implements FileService{
	@Autowired FileMapper fm;
	
	public void fileProcess(MultipartHttpServletRequest mul) {
		MultipartFile file = mul.getFile("file");
		
		ShoesDTO dto = new ShoesDTO();
		dto.setId(mul.getParameter("id"));
		dto.setName(mul.getParameter("name"));
		
		if(file.getSize() != 0) { //!file.isEmpty()
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss-"); //yyyyMMddHHss- (20210626140130-img.png
			Calendar calendar = Calendar.getInstance();
			String sysFileName = format.format(calendar.getTime()) + file.getOriginalFilename();
			File saveFile = new File(IMAGE_REPO+"\\"+sysFileName);
			dto.setImgName(sysFileName);
			try {
				file.transferTo(saveFile);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else {
			dto.setImgName("nan");
		}
		fm.saveData(dto);
	}
		
	public void getShoesImage(Model model) {
		model.addAttribute("list", fm.getShoesImage());
	}
}

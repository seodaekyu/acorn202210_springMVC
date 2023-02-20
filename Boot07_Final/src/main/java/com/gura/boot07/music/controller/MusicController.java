package com.gura.boot07.music.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.gura.boot07.music.dto.MusicDto;
import com.gura.boot07.music.service.MusicService;

@Controller
public class MusicController {
	
	@Autowired MusicService service;
	
	// 음악파일 업로드 폼 요청 처리
	@RequestMapping("/music/insertform")
	public String insertform() {
		
		return "music/insertform";
	}
	// 음악파일 업로드 요청처리
	@RequestMapping("/music/insert")
	public String insert(MultipartFile file, HttpServletRequest request) {
		
		service.saveFile(file, request);
		
		return "redirect:/music/list";
	}
	// 음악 파일 목록 요청처리
	@RequestMapping("/music/list")
	public ModelAndView list(ModelAndView mView, HttpSession session) {
		
		service.getList(mView, session);
		
		mView.setViewName("music/list");
		return mView;
	}
	/*
	 * 	get 방식 파라미터로 전달되는 num 에 해당하는 음악 하나의 정보를 json 형식의 문자열로 응답하는 컨트롤러 메소드
	 * 	{"writer" : "xxx", "orgFileName : "xxx", "saveFileName : "xxx", ....}
	 */
	@RequestMapping("/music/detail")
	@ResponseBody
	public MusicDto checkDetail(int num, HttpServletRequest request) {
		
		return service.getDetail(num);
	}
	
	@GetMapping("/music/delete")
	public String checkDelete(int num, HttpServletRequest request) {
		
		service.deleteFile(num, request);
		
		return "redirect:/music/list";
	}
}

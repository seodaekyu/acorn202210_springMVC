package com.gura.boot07.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gura.boot07.gallery.dao.GalleryDao;
import com.gura.boot07.gallery.dto.GalleryDto;

/*
 * 	안드로이드 app 의 요청을 처리할 컨트롤러
 */

@Controller
public class AndroidContoller {
	
	//@RequestMapping("/api/music/list")
	@ResponseBody
	public List<Map<String, Object>> getMusicList() {
		Map<String, Object> song1 = new HashMap<>();
		song1.put("title", "쇼팽 녹턴");
		song1.put("fileName", "mp3piano.mp3");
		
		Map<String, Object> song2 = new HashMap<>();
		song2.put("title", "Over the Horizon");
		song2.put("fileName", "Over_the_Horizon.mp3");
		
		List<Map<String, Object>> list = new ArrayList<>();
		list.add(song1);
		list.add(song2);
		
		return list;
	}
	
	
	/*
	 * 	JSON 문자열 응답하기
	 * 
	 * 	1. @ResponseBody 어노테이션
	 *  2. Map or List or Dto 를 리턴하면 자동으로 JSON 문자열로 변환되어 응답된다.
	 */
	
	@RequestMapping("/api/send")
	@ResponseBody
	public Map<String, Object> send(String msg) {
		System.out.println(msg);
		Map<String, Object> map = new HashMap<>();
		map.put("isSuccess", true);
		map.put("response", "hello client!");
		map.put("num", 1);
		
		return map;
	}
	
	@RequestMapping("/api/list")
	@ResponseBody
	public List<String> list(int pageNum) {
		List<String> names = new ArrayList<>();
		names.add("김구라");
		names.add("해골");
		names.add("원숭이");
		
		return names;
	}
	
	// 로그인 여부를 JSON 으로 응답하는 메소드
	@RequestMapping("/api/logincheck")
	@ResponseBody
	public Map<String, Object> logincheck(HttpSession session){
		// 테스트로 session 의 아이디를 출력해보기
		System.out.println("세션 아이디:"+session.getId());
		
		Map<String, Object> map = new HashMap<>();
		String id = (String)session.getAttribute("id");
		// 만일 로그인을 하지 않았다면
		if(id == null) {
			map.put("isLogin", false);
			System.out.println("로그인중이 아닙니다");
		}else {
			map.put("isLogin", true);
			map.put("id", id);
			System.out.println(id+" 로그인중...");
		}
		
		return map;
	}
   
	@RequestMapping("/api/login")
	@ResponseBody
	public Map<String, Object> login(String id, String pwd, HttpSession session){
		// 세션(로그인 유지) 시간
		session.setMaxInactiveInterval(60*60*24*365); // 60*60 은 1시간 * 24 는 하루 * 365 는 1년
		
		System.out.println(id+"|"+pwd);
		Map<String, Object> map = new HashMap<>();
		if(id.equals("gura") && pwd.equals("1234")) {
			map.put("isSuccess", true);
			map.put("id", id);
			session.setAttribute("id", id);
		}else {
			map.put("isSuccess", false);
		}
		
		return map;
	}
   
	@RequestMapping("/api/logout")
	@ResponseBody
	public Map<String, Object> logout(HttpSession session){
		session.invalidate();
		Map<String, Object> map = new HashMap<>();
		map.put("isSuccess", true);
		
		return map;
	}
	
	@Autowired GalleryDao dao;
	
	@RequestMapping("/api/gallery/list")
	@ResponseBody
	public List<GalleryDto> galleryList() {
		// 최신 Gallery data 10 개만 가지고 오기 위해 
		GalleryDto dto = new GalleryDto();
		dto.setStartRowNum(1);
		dto.setEndRowNum(10);
		
		return dao.getList(dto);
	}
}

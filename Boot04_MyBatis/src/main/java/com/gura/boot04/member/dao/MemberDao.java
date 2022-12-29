package com.gura.boot04.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// 1. @RestController 를 이용해서 Controller 를 만들고
@Repository
public class MemberDao {
	
	@Autowired SqlSession session;
	
	// 2. 메소드에서 어떤 data 를 리턴하면 리턴되는 데이터가 클라이언트에게 바로 응답된다.
	// String 은 내용 그대로 응답되고, dto, Map, List 등은 JSON 문자열로 변환되어 응답된다.
	
	public List<MemberDto> getList(){
		return session.selectList("member.getList");
	}
}

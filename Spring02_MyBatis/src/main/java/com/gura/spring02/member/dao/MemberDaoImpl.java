package com.gura.spring02.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gura.spring02.member.dto.MemberDto;

// Component scan 을 통해서 spring 이 관리하는 bean 이 될 수 있도록 어노테이션 붙여놓기
@Repository // 보통 Dao 경우에는 Repository 가 붙음
public class MemberDaoImpl implements MemberDao{
	
	@Autowired
	private SqlSession session; // select, insert, update, delete 작업을 하기 위한 핵심 의존 객체
						// 위의 session 은 sqlSessionTemplate 과도 같다.
	@Override
	public void insert(MemberDto dto) {
		/*
		 * 	mapper's namespace => member
		 * 	sql's id => insert
		 * 	parameterType => MemberDto 
		 */
		session.insert("member.insert", dto);
		
	}

	@Override
	public void update(MemberDto dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MemberDto getData(int num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MemberDto> getList() {
		/*
		 * 	mapper's namespace => member
		 * 	sql's id => getList
		 * 	resultType => MemberDto
		 * 	return type => List
		 */
		
		// MyBatis 를 배운다는것은 SqlSession 사용법을 배운다는것과 같음
		List<MemberDto> list = session.selectList("member.getList"); 
		
		return list;
	}
	
}

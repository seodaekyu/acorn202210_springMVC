package com.gura.spring02.todo.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gura.spring02.todo.dto.TodoDto;

//Component scan 을 통해서 spring 이 관리하는 bean 이 될 수 있도록 어노테이션 붙여놓기
@Repository // 보통 Dao 경우에는 Repository 가 붙음
public class TodoDaoImpl implements TodoDao{

	@Autowired
	private SqlSession session; // select, insert, update, delete 작업을 하기 위한 핵심 의존 객체
						// 위의 session 은 sqlSessionTemplate 과도 같다.
	
	@Override
	public void insert(TodoDto dto) {
		session.insert("todo.insert", dto);
		
	}

	@Override
	public void update(TodoDto dto) {
		session.update("todo.update", dto);
		
	}

	@Override
	public void delete(int num) {
		session.delete("todo.delete", num);
		
	}

	@Override
	public TodoDto getData(int num) {
		TodoDto dto = session.selectOne("todo.getData", num);
		return dto;
	}

	@Override
	public List<TodoDto> getList() {
		List<TodoDto> list = session.selectList("todo.getList");
		
		return list;
	}

}

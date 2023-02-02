package com.gura.boot07.api;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// Dao 에 붙여야 하는 어노테이션
@Repository
public class TodoDaoImpl implements TodoDao{
	
	// 의존객체 주입(DI)
	@Autowired
	private SqlSession session; // MyBatis 

	@Override
	public void insert(TodoDto dto) {
		/*
		 * 	Mapper's namespace => todo
		 * 	sql's id => insert
		 * 	parameter type => TodoDto
		 */
		session.insert("todo.insert", dto);
	}

	@Override
	public List<TodoDto> getList() {
		/*
		 * 	Mapper's namespace => todo
		 * 	sql's id => getList
		 * 	parameter type => 없음
		 * 	resultType => TodoDto
		 */
		return session.selectList("todo.getList");
	}

	@Override
	public void delete(int num) {
		/*
		 * 	Mapper's namespace => todo
		 * 	sql's id => delete
		 * 	parameterType => int
		 */
		session.delete("todo.delete", num);
	}

}

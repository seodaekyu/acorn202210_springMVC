package com.gura.spring02.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring02.todo.dao.TodoDao;
import com.gura.spring02.todo.dto.TodoDto;

//component scan 을 통해서 스프링이 관리하는 bean 이 되게 하기 위해 필요한 어노테이션
@Service
public class TodoServiceImpl implements TodoService{
	
	// 핵심 의존 객체 주입받기
	@Autowired
	private TodoDao dao;

	@Override
	public void addTodo(TodoDto dto) {
		dao.insert(dto);
		
	}

	@Override
	public void updateTodo(TodoDto dto) {
		dao.update(dto);
		
	}

	@Override
	public void deleteTodo(int num) {
		dao.delete(num);
		
	}

	@Override
	public void getTodo(int num, ModelAndView mView) {
		TodoDto dto = dao.getData(num);
		
		mView.addObject("dto", dto);
		
	}

	@Override
	public void getListTodo(ModelAndView mView) {
		List<TodoDto> list = dao.getList();
		
		mView.addObject("list", list);
		
	}
}

package com.gura.boot07.api;

import java.util.List;

public interface TodoDao {
	// 할일 추가
	public void insert(TodoDto dto);
	// 할일 목록
	public List<TodoDto> getList();
	// 할일 삭제
	public void delete(int num);
	
}

package com.gura.boot07.music.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gura.boot07.music.dto.MusicDto;

@Repository
public class MusicDaoImpl implements MusicDao{

	@Autowired SqlSession session;
	
	@Override
	public void insert(MusicDto dto) {
		/*
		 * 	mapper's namespace => music
		 * 	sql's id => insert
		 * 	parameter type => MusicDto
		 */
		session.insert("music.insert", dto);
	}

	@Override
	public List<MusicDto> getList(String id) {
		/*
		 * 	parameterType => String
		 * 	resultType => MusicDto
		 */
		return session.selectList("music.getList", id);
	}

	@Override
	public MusicDto getdata(int num) {
		/*
		 * 	parameterType => int
		 * 	resultType => MusicDto
		 */
		return session.selectOne("music.getData", num);
	}

	@Override
	public void delete(int num) {
		session.delete("music.delete", num);
		
	}

}

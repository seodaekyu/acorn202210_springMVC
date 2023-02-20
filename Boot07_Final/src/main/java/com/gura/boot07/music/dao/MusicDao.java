package com.gura.boot07.music.dao;

import java.util.List;

import com.gura.boot07.music.dto.MusicDto;

public interface MusicDao {
	public void insert(MusicDto dto);
	public List<MusicDto> getList(String id);
	public MusicDto getdata(int num);
	public void delete(int num);
}

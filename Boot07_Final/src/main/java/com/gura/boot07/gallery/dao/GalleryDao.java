package com.gura.boot07.gallery.dao;

import java.util.List;

import com.gura.boot07.gallery.dto.GalleryDto;


public interface GalleryDao {
	//gallery 리스트 가져오기
	public List<GalleryDto> getList(GalleryDto dto);
	//모든 ROW 의 개수
	public int getCount();
	//갤러리에 사진 저장하기
	public void insert(GalleryDto dto);
	//pk num 에 해당하는 DB 에서 gallery 게시글 하나의 data 가져오기
	public GalleryDto getData(int num);
	// gallery 모든 리스트 가져오기
	public List<GalleryDto> getListAll();
	// 갤러리 삭제
	public void delete(int num);

}
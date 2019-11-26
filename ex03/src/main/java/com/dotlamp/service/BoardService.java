package com.dotlamp.service;

import java.util.List;

import com.dotlamp.domain.BoardVO;
import com.dotlamp.domain.Criteria;

public interface BoardService {

	public void register(BoardVO board);
	
	public BoardVO get(Long bno);
	
	public boolean modify(BoardVO board);
	
	public boolean remove(Long bno);
	
	//public List<BoardVO> getList();
	
	public List<BoardVO> getList(Criteria cri); //페이지별 목록
	
	public int getTotal(Criteria cri); //페이지 전체갯수
}

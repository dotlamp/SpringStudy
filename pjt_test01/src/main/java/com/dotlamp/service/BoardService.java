package com.dotlamp.service;

import java.util.List;

import com.dotlamp.domain.BoardAttachVO;
import com.dotlamp.domain.BoardVO;
import com.dotlamp.domain.Criteria;

public interface BoardService {

	public void register(BoardVO board);
	
	public BoardVO get(Long bno);
	
	public boolean modify(BoardVO board);
	
	public boolean remove(Long bno);
	
	public List<BoardVO> getList(Criteria cri);
	
	public int getTotal(Criteria cri); //전체글갯수
	
	public List<BoardAttachVO> getAttachList(Long bno);
}

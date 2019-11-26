package com.dotlamp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dotlamp.domain.BoardVO;
import com.dotlamp.domain.Criteria;
import com.dotlamp.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService{

	//sping 4.3 이상 자동 처리
	@Setter(onMethod_ = @Autowired )
	private BoardMapper mapper;

	@Override
	public void register(BoardVO board) {
		log.info("register..." + board);
		mapper.insertSelectKey(board);
	}

	@Override
	public BoardVO get(Long bno) {
		log.info("get....... " + bno);
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		log.info("moodify......" + board);
		return mapper.update(board) == 1;
	}

	@Override
	public boolean remove(Long bno) {
		log.info("remove....." + bno);
		return mapper.delete(bno) == 1;
	}

	@Override
	public List<BoardVO> getList(Criteria cri) {
		log.info("get List with Criteria: " + cri);
		return mapper.getListWithPaging(cri);
	}

	@Override
	public int getTotal(Criteria cri) {
		log.info("get Total Count: " + cri);
		return mapper.getTotalCount(cri);
	}

//	@Override
//	public List<BoardVO> getList() {
//		log.info("get List.....");
//		return mapper.getList();
//	}
	
	
	
	
	
}

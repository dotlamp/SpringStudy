package com.dotlamp.service;

import java.util.List;

import com.dotlamp.domain.Criteria;
import com.dotlamp.domain.ReplyPageDTO;
import com.dotlamp.domain.ReplyVO;

public interface ReplyService {

	public int register(ReplyVO vo);
	
	public ReplyVO get(Long vo);
	
	public int modify(ReplyVO vo);
	
	public int remove(Long rno);
	
	public List<ReplyVO> getList(Criteria cri, Long bno);
	
	public ReplyPageDTO getListPage(Criteria cri, Long bno);
}

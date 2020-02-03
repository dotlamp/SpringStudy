package com.dotlamp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.dotlamp.domain.BoardVO;
import com.dotlamp.domain.Criteria;

public interface BoardMapper {

//	@Select("select * from tbl_board where bno < 10")
	public List<BoardVO> getList();
	
	public List<BoardVO> getListWithPaging(Criteria cri);
	
	public void insert(BoardVO board);
	
	public void insertSelectKey(BoardVO board);
	
	public BoardVO read(Long bno);
	
	public int delete(Long bno); //int -> 1: 삭제O, 0:삭제x(삭제할 게시물x)
	
	public int update(BoardVO board);
	
	public int getTotalCount(Criteria cri);
	
	public void updateReplyCnt(@Param("bno") Long bno, @Param("amount") int amount);
	
}

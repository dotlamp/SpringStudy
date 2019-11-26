package com.dotlamp.mapper;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dotlamp.domain.BoardVO;
import com.dotlamp.domain.Criteria;
import com.dotlamp.service.BoardService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {com.dotlamp.config.RootConfig.class})
@Log4j
public class BoardServiceTests {

	@Setter(onMethod_ = @Autowired)
	private BoardService service;
	
	/* BoardService 객체가 제대로 주입이 가능한지 확인하는 작업 */
//	@Test
//	public void testExist() {
//		log.info(service);
//		assertNotNull(service);
//	}
	
	/* insert */
//	@Test
//	public void testRegister() {
//		BoardVO board = new BoardVO();
//		board.setTitle("새로작성하는글");
//		board.setContent("새로작성하는내용");
//		board.setWriter("뉴우비");
//		service.register(board);
//		log.info("생성된 게시물의 번호: " +  board.getBno());
//	}
	
	/* select * */
	@Test
	public void testGetList() {
//		service.getList().forEach(borad -> log.info(borad));
		service.getList(new Criteria(2, 10)).forEach(board -> log.info(board));
	}
	
	/* select * where */
//	@Test
//	public void testGet() {
//		log.info(service.get(2L));
//	}
	
	
	/* update */
//	@Test
//	public void testUpdate() {
//		BoardVO board = service.get(1L);
//		
//		if(board == null) {
//			return;
//		}
//		
//		board.setTitle("제목 수정");
//		board.setContent("내용 수정");
//		log.info("modify result: " + service.modify(board));
//	}
	
	/* delete * where */
//	@Test
//	public void testDelete() {
//		log.info("remove result: " + service.remove(9L));
//	}
	
	
}

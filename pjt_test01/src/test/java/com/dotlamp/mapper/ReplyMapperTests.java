package com.dotlamp.mapper;


import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dotlamp.domain.Criteria;
import com.dotlamp.domain.ReplyVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {com.dotlamp.config.RootConfig.class})
@Log4j
public class ReplyMapperTests {

	@Autowired
	private ReplyMapper mapper;
	
	@Test
	public void testMapper() {
		log.info(mapper);
	}
	
	private Long[] bnoArr = {499L, 498L, 497L, 496L, 495L};
//	@Test
//	public void testCreate() {
//		IntStream.rangeClosed(1, 10).forEach(i->{
//			ReplyVO vo = new ReplyVO();
//			
//			vo.setBno(bnoArr[i %5]);
//			vo.setReply("댓글테스트"+i);
//			vo.setReplyer("replyer"+i);
//			
//			mapper.insert(vo);
//		});
//	}
	
//	@Test
//	public void testRead() {
//		Long targetRno = 10L;
//		ReplyVO vo = mapper.read(targetRno);
//		log.info(vo);
//	}
	
//	@Test
//	public void testDelete() {
//		Long targetRno = 10L;
//		mapper.delete(targetRno);
//	}
	
//	@Test
//	public void testUpdate() {
//		Long targetRno = 9L;
//		ReplyVO vo = mapper.read(targetRno);
//		vo.setReply("updateReply");
//		int count = mapper.update(vo);
//		log.info("updateCount:"+count);
//	}
	
//	@Test
//	public void testList() {
//		Criteria cri = new Criteria();
//		List<ReplyVO> replies = mapper.getListWithPaging(cri, bnoArr[1]);
//		replies.forEach(reply -> log.info(reply));
//	}
	
//	@Test
//	public void testList2() {
//		Criteria cri = new Criteria(2, 10); 
//		List<ReplyVO> replies = mapper.getListWithPaging(cri, 499L);
//		replies.forEach(reply -> log.info(reply));
//	}
}

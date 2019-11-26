package com.dotlamp.mapper;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.dotlamp.domain.Criteria;
import com.dotlamp.domain.ReplyVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {com.dotlamp.config.RootConfig.class})
@Log4j
public class ReplyMapperTests {

	private Long[] bnoArr = {160L,144L,143L,142L,141L};
	
	@Setter(onMethod_ = @Autowired)
	private ReplyMapper mapper;
	
//	@Test
//	public void testMapper() {
//		log.info(mapper);
//	}
	
//	@Test
//	public void testCreate() {
//		IntStream.rangeClosed(1, 10).forEach(i -> { ReplyVO vo = new ReplyVO();
//			vo.setBno(bnoArr[i%5]);
//			vo.setReply("tester " + i);
//			vo.setReplyer("test " + i);
//		mapper.insert(vo);
//		});
//	}
	
//	@Test
//	public void testRead() {
//		Long targetRno = 160L;
//		ReplyVO vo = mapper.read(targetRno);
//		log.info(vo);
//	}

//	@Test
//	public void testDelete() {
//		Long targetRno = 1L;
//		mapper.delete(targetRno);
//	}
	
//	@Test
//	public void testUpdate() {
//		Long targetRno = 3L;
//		ReplyVO vo = mapper.read(targetRno);
//		vo.setReply("update");
//		int count = mapper.update(vo);
//		log.info("update count: " + count);
//	}
	
//	@Test
//	public void testList() {
//		Criteria cri = new Criteria();
//		List<ReplyVO> replies = mapper.getListWithPaging(cri, bnoArr[0]);
//		replies.forEach(reply -> log.info(reply));
//	}
	
	@Test
	public void testList2() {
		Criteria cri = new Criteria(2,10);
		Long targetRno = 160L;
		List<ReplyVO> replies = mapper.getListWithPaging(cri, targetRno);	
		replies.forEach(reply -> log.info(reply));
	}
	
}

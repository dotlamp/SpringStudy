package com.dotlamp.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.dotlamp.domain.MemberVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@Log4j
public class MemberMapperTests {

//	@Setter(onMethod_ = @Autowired)
	@Autowired
	private MemberMapper mapper;
	  
	  @Test
	  public void read() {
		  MemberVO vo = mapper.read("admin90");
			log.info(vo);
			vo.getAuthList().forEach(authVO -> log.info(authVO));
	  }
}

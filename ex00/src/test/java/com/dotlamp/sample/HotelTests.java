package com.dotlamp.sample;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dotlamp.config.RootConfig;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {RootConfig.class})
@Log4j
public class HotelTests {

	@Setter(onMethod_ = {@Autowired})
	private SampleHotel sampleHotel;
	
	@Test
	public void testExist() {
		assertNotNull(sampleHotel);
		
		log.info(sampleHotel);
		log.info("----------------------");
		log.info(sampleHotel.getChef());
		
	}

}

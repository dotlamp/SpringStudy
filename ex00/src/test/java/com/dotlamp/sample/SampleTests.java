package com.dotlamp.sample;

import static org.junit.Assert.assertNull;

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
public class SampleTests {
	
	@Setter(onMethod = @__({ @Autowired }))
	private Restaurant restaurant;
	
	@Test
	public void testExist() {
		//assertNull(restaurant);
		
		log.info(restaurant);
		log.info("-----------------");
		log.info(restaurant.getChef());
	}
}

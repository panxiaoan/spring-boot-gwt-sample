package com.pxa.sample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pxa.sample.server.service.LocationService;

/** 
 * @author <a href="mailto:xiaoan.pan@qq.com">潘小安</a> 
 * @since 2018-10-13 15:06 
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LocationServiceTest {
	
	@Autowired
	protected LocationService locationService;

	@Test
	public void contextLoads() {
//		locationService.init();
		locationService.query();
	}
}

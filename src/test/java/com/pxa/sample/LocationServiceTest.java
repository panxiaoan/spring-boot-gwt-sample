package com.pxa.sample;

import com.pxa.sample.server.service.LocationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author <a href="mailto:xiaoan.pan@qq.com">潘小安</a>
 * @since 2018-10-13 15:06
 */
@SpringBootTest
public class LocationServiceTest {

    @Autowired
    protected LocationService locationService;

    @Test
    public void contextLoads() {
//		locationService.init();
		//		locationService.query();
        locationService.load();
    }
}

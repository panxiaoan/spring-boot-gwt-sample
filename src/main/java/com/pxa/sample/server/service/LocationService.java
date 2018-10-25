package com.pxa.sample.server.service;

import com.pxa.sample.server.model.entity.City;
import com.pxa.sample.server.model.entity.Province;
import com.pxa.sample.server.repository.CityRepository;
import com.pxa.sample.server.repository.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/** 
 * @author <a href="mailto:xiaoan.pan@qq.com">潘小安</a> 
 * @since 2018-10-13 14:54 
 */
@Service
@Transactional(readOnly = true)
public class LocationService {

	@Autowired
	protected ProvinceRepository provinceRepository;
	
	@Autowired
	protected CityRepository cityRepository;
	
	@Transactional(readOnly = false)
	public void init() {
		Province province = new Province();
		province.setCode("HN");
		province.setName("湖南省");
		
		provinceRepository.save(province);
		
		Province province2 = new Province();
		province2.setCode("sh");
		province2.setName("上海市");
		provinceRepository.save(province2);
		
		City city = new City();
		city.setProvinceId(province.getId());
		city.setCode("cs");
		city.setName("长沙市");
		cityRepository.save(city);
		
		City city2 = new City();
		city2.setProvinceId(province.getId());
		city2.setCode("yy");
		city2.setName("岳阳");
		cityRepository.save(city2);
		
		City city3 = new City();
		city3.setCode("ld");
		city3.setName("娄底");
		cityRepository.save(city3);
		
	}
	
	public void query() {
		List<Object[]> list = cityRepository.queryCity();
		for (Object[] objs : list) {
			
			StringBuffer row = new StringBuffer();
			for (Object obj : objs) {
				row.append(obj).append(",");
			}
			System.err.println(row.toString());
		}
	}

    public void load() {
        Optional<Province> province = provinceRepository.findById(1L);
    }
	
}

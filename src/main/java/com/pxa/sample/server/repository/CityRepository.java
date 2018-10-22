package com.pxa.sample.server.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.pxa.sample.server.model.entity.City;

/**
 * @author <a href="mailto:xiaoan.pan@qq.com">潘小安</a>
 * @since 2018-10-13 14:52
 */
@Repository
public interface CityRepository
		extends PagingAndSortingRepository<City, Long>, JpaSpecificationExecutor<City> {

	@Query("select c.id, c.code, c.name, p.code, p.name from City c left join Province p with (p.id = c.provinceId)")
	List<Object[]> queryCity();
}

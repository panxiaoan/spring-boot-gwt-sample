package com.pxa.sample.server.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.pxa.sample.server.model.entity.Province;

/**
 * @author <a href="mailto:xiaoan.pan@qq.com">潘小安</a>
 * @since 2018-10-13 14:52
 */
@Repository
public interface ProvinceRepository
		extends PagingAndSortingRepository<Province, Long>, JpaSpecificationExecutor<Province> {

}

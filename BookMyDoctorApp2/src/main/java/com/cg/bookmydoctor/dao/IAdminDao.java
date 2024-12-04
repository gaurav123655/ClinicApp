package com.cg.bookmydoctor.dao;

import com.cg.bookmydoctor.dto.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAdminDao extends CrudRepository<Admin, Integer> {
	
}
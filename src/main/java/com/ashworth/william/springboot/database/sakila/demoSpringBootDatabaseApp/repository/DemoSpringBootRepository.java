package com.ashworth.william.springboot.database.sakila.demoSpringBootDatabaseApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashworth.william.springboot.database.sakila.demoSpringBootDatabaseApp.model.DemoSpringBootDataModel;

@Repository
public interface DemoSpringBootRepository extends JpaRepository<DemoSpringBootDataModel, Long>
{
	
}

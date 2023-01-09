package com.ogya.lokakarya.usermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ogya.lokakarya.usermanagement.entity.RoleMenu;

public interface RoleMenuRepository extends JpaRepository<RoleMenu, Long>{
	
}
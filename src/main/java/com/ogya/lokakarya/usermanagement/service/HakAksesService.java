package com.ogya.lokakarya.usermanagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.ogya.lokakarya.usermanagement.entity.HakAkses;
import com.ogya.lokakarya.usermanagement.entity.Login;
import com.ogya.lokakarya.usermanagement.entity.Roles;
import com.ogya.lokakarya.usermanagement.repository.HakAksesRepository;
import com.ogya.lokakarya.usermanagement.repository.LoginRepository;
import com.ogya.lokakarya.usermanagement.repository.RolesRepository;
import com.ogya.lokakarya.usermanagement.wrapper.HakAksesWrapper;

@Service
@Transactional
public class HakAksesService {
	@Autowired
	HakAksesRepository hakAksesRepository;
	
	@Autowired
	LoginRepository usersRepository;
	
	@Autowired
	RolesRepository rolesRepository;

	private HakAksesWrapper toWrapper(HakAkses entity) {
		HakAksesWrapper wrapper = new HakAksesWrapper();
		wrapper.setHakAksesId(entity.getHakAksesId());
		wrapper.setUserId(entity.getUsers() != null ? entity.getUsers().getUserId() : null);
		wrapper.setRoleId(entity.getRoles() != null ? entity.getRoles().getRoleId() : null);
		wrapper.setProgramName(entity.getProgramName());
		wrapper.setCreatedDate(entity.getCreatedDate());
		wrapper.setCreatedBy(entity.getCreatedBy());
		wrapper.setUpdatedDate(entity.getUpdatedDate());
		wrapper.setUpdatedBy(entity.getUpdatedBy());
		return wrapper;
	}

	private List<HakAksesWrapper> toWrapperList(List<HakAkses> entityList) {
		List<HakAksesWrapper> wrapperList = new ArrayList<HakAksesWrapper>();
		for (HakAkses entity : entityList) {
			HakAksesWrapper wrapper = toWrapper(entity);
			wrapperList.add(wrapper);
		}
		return wrapperList;
	}

	public List<HakAksesWrapper> findAll() {
		List<HakAkses> hakAksesList = hakAksesRepository.findAll(Sort.by(Order.by("hakAksesId")).ascending());
		return toWrapperList(hakAksesList);
	}

	private HakAkses toEntity(HakAksesWrapper wrapper) {
		HakAkses entity = new HakAkses();
		if (wrapper.getHakAksesId() != null) {
			entity = hakAksesRepository.getReferenceById(wrapper.getHakAksesId());
		}
		Optional<Login> optionalUsers = usersRepository.findById(wrapper.getUserId());
		Login users = optionalUsers.isPresent() ? optionalUsers.get() : null;
		entity.setUsers(users);
		Optional<Roles> optionalRoles = rolesRepository.findById(wrapper.getRoleId());
		Roles roles = optionalRoles.isPresent() ? optionalRoles.get() : null;
		entity.setRoles(roles);
		entity.setProgramName(wrapper.getProgramName());
		entity.setCreatedDate(wrapper.getCreatedDate());
		entity.setCreatedBy(wrapper.getCreatedBy());
		entity.setUpdatedDate(wrapper.getUpdatedDate());
		entity.setUpdatedBy(wrapper.getUpdatedBy());
		return entity;
	}

	public HakAksesWrapper save(HakAksesWrapper wrapper) {
		HakAkses hakAkses = hakAksesRepository.save(toEntity(wrapper));
		return toWrapper(hakAkses);
	}

	public void delete(Long id) {
		hakAksesRepository.deleteById(id);
	}
}
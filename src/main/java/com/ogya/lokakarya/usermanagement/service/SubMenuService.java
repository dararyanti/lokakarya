package com.ogya.lokakarya.usermanagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.ogya.lokakarya.usermanagement.entity.Menu;
import com.ogya.lokakarya.usermanagement.entity.SubMenu;
import com.ogya.lokakarya.usermanagement.repository.MenuRepository;
import com.ogya.lokakarya.usermanagement.repository.SubMenuRepository;
import com.ogya.lokakarya.usermanagement.wrapper.SubMenuWrapper;

@Service
@Transactional
public class SubMenuService {
	@Autowired
	SubMenuRepository subMenuRepository;
	
	@Autowired
	MenuRepository menuRepository;
	
	private SubMenuWrapper toWrapper(SubMenu entity) {
		SubMenuWrapper wrapper = new SubMenuWrapper();
		wrapper.setSubMenuId(entity.getSubMenuId());
		wrapper.setMenuId(entity.getMenu() != null ? entity.getMenu().getMenuId() : null);
		wrapper.setNama(entity.getNama());
		wrapper.setIcon(entity.getIcon());
		wrapper.setUrl(entity.getUrl());
		wrapper.setProgramName(entity.getProgramName());
		wrapper.setCreatedDate(entity.getCreatedDate());
		wrapper.setCreatedBy(entity.getCreatedBy());
		wrapper.setUpdatedDate(entity.getUpdatedDate());
		wrapper.setUpdatedBy(entity.getUpdatedBy());
		return wrapper;
	}

	private List<SubMenuWrapper> toWrapperList(List<SubMenu> entityList) {
		List<SubMenuWrapper> wrapperList = new ArrayList<SubMenuWrapper>();
		for (SubMenu entity : entityList) {
			SubMenuWrapper wrapper = toWrapper(entity);
			wrapperList.add(wrapper);
		}
		return wrapperList;
	}

	public List<SubMenuWrapper> findAll() {
		List<SubMenu> subMenuList = subMenuRepository.findAll(Sort.by(Order.by("subMenuId")).ascending());
		return toWrapperList(subMenuList);
	}

	private SubMenu toEntity(SubMenuWrapper wrapper) {
		SubMenu entity = new SubMenu();
		if (wrapper.getSubMenuId() != null) {
			entity = subMenuRepository.getReferenceById(wrapper.getSubMenuId());
		}
		Optional<Menu> optionalMenu = menuRepository.findById(wrapper.getMenuId());
		Menu menu = optionalMenu.isPresent() ? optionalMenu.get() : null;
		entity.setMenu(menu);
		entity.setNama(wrapper.getNama());
		entity.setIcon(wrapper.getIcon());
		entity.setUrl(wrapper.getUrl());
		entity.setProgramName(wrapper.getProgramName());
		entity.setCreatedDate(wrapper.getCreatedDate());
		entity.setCreatedBy(wrapper.getCreatedBy());
		entity.setUpdatedDate(wrapper.getUpdatedDate());
		entity.setUpdatedBy(wrapper.getUpdatedBy());
		return entity;
	}

	public SubMenuWrapper save(SubMenuWrapper wrapper) {
		SubMenu subMenu = subMenuRepository.save(toEntity(wrapper));
		return toWrapper(subMenu);
	}

	public void delete(Long id) {
		subMenuRepository.deleteById(id);
	}
}
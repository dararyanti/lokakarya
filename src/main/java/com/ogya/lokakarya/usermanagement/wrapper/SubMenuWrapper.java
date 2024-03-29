package com.ogya.lokakarya.usermanagement.wrapper;

import java.util.Date;


public class SubMenuWrapper {
	private Long subMenuId;
	private String nama;
	private String icon;
	private String url;
	private Long MenuId;
	private String programName;
	private Date createdDate;
	private String createdBy;
	private Date updatedDate;
	private String updatedBy;
	

	public Long getSubMenuId() {
		return subMenuId;
	}
	public void setSubMenuId(Long subMenuId) {
		this.subMenuId = subMenuId;
	}
	//--------------------------------------------------------------------------------------------------------

	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	//--------------------------------------------------------------------------------------------------------




	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	//--------------------------------------------------------------------------------------------------------



	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	//--------------------------------------------------------------------------------------------------------



	public String getProgramName() {
		return programName;
	}
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	//--------------------------------------------------------------------------------------------------------


	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	//--------------------------------------------------------------------------------------------------------


	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	//--------------------------------------------------------------------------------------------------------


	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	//--------------------------------------------------------------------------------------------------------


	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public Long getMenuId() {
		return MenuId;
	}
	public void setMenuId(Long menuId) {
		MenuId = menuId;
	}
	@Override
	public String toString() {
		return "SubMenuWrapper [subMenuId=" + subMenuId + ", nama=" + nama + ", icon=" + icon + ", url=" + url
				+ ", MenuId=" + MenuId + ", programName=" + programName + ", createdDate=" + createdDate
				+ ", createdBy=" + createdBy + ", updatedDate=" + updatedDate + ", updatedBy=" + updatedBy + "]";
	}
	
	

	//--------------------------------------------------------------------------------------------------------
	
	
	
	
	

	
	
	
}

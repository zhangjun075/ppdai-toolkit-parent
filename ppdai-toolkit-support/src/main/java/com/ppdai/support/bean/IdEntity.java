package com.ppdai.support.bean;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

/**
 * Entity父类
 */
@Component
public abstract class IdEntity implements Serializable {

	private static final long serialVersionUID = 2838602796104327148L;

	/** 主键. */
	private Long id;
	
	private String extId;

	/** 创建时间. */
	private Date createTime;

	/** 更新时间. */
	private Date updateTime;

	/** 更新人. */
	private String updater;

	/** 创建人. */
	private String creator;

	/**
	 * 获取 对象字符串格式数据
	 * 
	 * @return 对象字符串格式数据
	 */
	public String toString() {
		return id + " : " + ToStringBuilder.reflectionToString(this);
	}

	/**
	 * 获取 对象Json格式数据
	 * 
	 * @return 对象Json格式数据
	 */
	public String toJson() {
		return JSON.toJSONString(this);
	}

	// getter setter

	/**
	 * 获取 主键.
	 *
	 * @return the 主键
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 设置 主键.
	 *
	 * @param id the new 主键
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 获取 额外字段Id.
	 *
	 * @return the 额外字段Id
	 */
	public String getExtId() {
		return extId;
	}

	/**
	 * 设置 额外字段Id.
	 *
	 * @param extId the new 额外字段Id
	 */
	public void setExtId(String extId) {
		this.extId = extId;
	}

	/**
	 * 获取 创建时间.
	 *
	 * @return the 创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * 设置 创建时间.
	 *
	 * @param createDate the new 创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * 获取 更新时间.
	 *
	 * @return the 更新时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * 设置 更新时间.
	 *
	 * @param updateDate the new 更新时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * 获取 更新人.
	 *
	 * @return the 更新人
	 */
	public String getUpdater() {
		return updater;
	}

	/**
	 * 设置 更新人.
	 *
	 * @param updater the new 更新人
	 */
	public void setUpdater(String updater) {
		this.updater = updater;
	}

	/**
	 * 获取 创建人.
	 *
	 * @return the 创建人
	 */
	public String getCreator() {
		return creator;
	}

	/**
	 * 设置 创建人.
	 *
	 * @param creator the new 创建人
	 */
	public void setCreator(String creator) {
		this.creator = creator;
	}
}

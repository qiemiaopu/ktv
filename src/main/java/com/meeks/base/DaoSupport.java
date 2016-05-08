package com.meeks.base;

import java.util.List;

import com.meeks.domain.ListDO;
import com.meeks.domain.PageBean;
import com.meeks.util.QueryHelper;

public interface DaoSupport<T> {

	/**
	 * 保存实体
	 * 
	 * @param entity
	 */
	void save(T entity);

	/**
	 * 删除实体
	 * 
	 * @param id
	 */
	void delete(Integer id);

	/**
	 * 更新实体
	 * 
	 * @param entity
	 */
	void update(T entity);

	/**
	 * 按id查询
	 * 
	 * @param id
	 * @return
	 */
	T getById(Integer id);

	/**
	 * 按id查询
	 * 
	 * @param ids
	 * @return
	 */
	List<T> getByIds(Integer[] ids);

	/**
	 * 查询所有
	 * 
	 * @return
	 */
	List<T> findAll();

	PageBean getPageBean(int pageNum, int pageSize, QueryHelper queryHelper);

	ListDO getBeanList(QueryHelper queryHelper);
}

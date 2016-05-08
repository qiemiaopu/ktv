package com.meeks.base;

import com.meeks.domain.ListDO;
import com.meeks.domain.PageBean;
import com.meeks.util.QueryHelper;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.List;

//@Transactional注解可以被继承
//@Transactional注解对父类中声明的方法无效
@Transactional
@SuppressWarnings("unchecked")
public abstract class DaoSupportImpl<T> implements DaoSupport<T> {

    @Resource
    private SessionFactory sessionFactory;
    private Class<T> clazz;

    public DaoSupportImpl() {
        // 使用反射技术得到T的真实类型
        ParameterizedType pt = (ParameterizedType) this.getClass()
                .getGenericSuperclass(); // 获取当前new的对象的 泛型的父类 类型
        this.clazz = (Class<T>) pt.getActualTypeArguments()[0]; // 获取第一个类型参数的真实类型
    }

    /**
     * 获取当前可用的Session
     *
     * @return
     */
    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void save(T entity) {
        getSession().save(entity);
    }

    public void update(T entity) {
        getSession().update(entity);
    }

    public void delete(Integer id) {
        Object obj = getById(id);
        if (obj != null) {
            getSession().delete(obj);
        }
    }

    public T getById(Integer id) {
        if (id == null) {
            return null;
        } else {
            return (T) getSession().get(clazz, id);
        }
    }

    public List<T> getByIds(Integer[] ids) {
        if (ids == null || ids.length == 0) {
            return Collections.EMPTY_LIST;
        } else {
            return getSession().createQuery(//
                    "FROM " + clazz.getSimpleName() + " WHERE id IN (:ids)")//
                    .setParameterList("ids", ids)//
                    .list();
        }
    }

    public List<T> findAll() {
        return getSession().createQuery(//
                "FROM " + clazz.getSimpleName())//
                .list();
    }

    // 公共的查询分页信息的方法（最终版）
    public PageBean getPageBean(int pageNum, int pageSize,
                                QueryHelper queryHelper) {

        // 参数列表
        List<Object> parameters = queryHelper.getParameters();

        // 查询本页的数据列表
        Query listQuery = getSession().createQuery(
                queryHelper.getListQueryHql()); // 创建查询对象
        if (parameters != null) { // 设置参数
            for (int i = 0; i < parameters.size(); i++) {
                listQuery.setParameter(i, parameters.get(i));
            }
        }
        listQuery.setFirstResult((pageNum - 1) * pageSize);
        listQuery.setMaxResults(pageSize);
        List list = listQuery.list(); // 执行查询

        // 查询总记录数量
        Query countQuery = getSession().createQuery(
                queryHelper.getCountQueryHql());
        if (parameters != null) { // 设置参数
            for (int i = 0; i < parameters.size(); i++) {
                countQuery.setParameter(i, parameters.get(i));
            }
        }
        Long count = (Long) countQuery.uniqueResult(); // 执行查询

        return new PageBean(pageNum, pageSize, count.intValue(), list);
    }

    @Override
    public ListDO getBeanList(QueryHelper queryHelper) {
        // 参数列表
        List<Object> parameters = queryHelper.getParameters();

        // 查询本页的数据列表
        Query listQuery = getSession().createQuery(
                queryHelper.getListQueryHql()); // 创建查询对象
        if (parameters != null) { // 设置参数
            for (int i = 0; i < parameters.size(); i++) {
                listQuery.setParameter(i, parameters.get(i));
            }
        }
        List beans = listQuery.list();
        return new ListDO(beans); // 执行查询
    }
}

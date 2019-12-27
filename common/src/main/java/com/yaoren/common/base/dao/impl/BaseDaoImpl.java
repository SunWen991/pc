package com.yaoren.common.base.dao.impl;

import com.yaoren.common.base.dao.BaseDao;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * @ClassName: BaseDaoImpl
 * @Description: 数据访问基类
 * @author zxh
 * @date 2016-7-7
 * 
 */
@Repository("baseDao")
public class BaseDaoImpl<M extends Serializable, PK extends Serializable> implements BaseDao<M, PK> {
	/**
	 * 基本包名
	 */
	public static final String BASE_PACKAGE_NAME = "com.heidian.";

	/**
	 * 基本包名
	 */
	public static final String EXCLUDE_STRING_1 = "domain.";

	/**
	 * 点
	 */
	public static final String DOT = ".";

	/**
	 * 模型对象
	 */
	protected Class<M> entityClass;

	/**
	 * Mybatis中SQL声明的前缀
	 */
	protected String statementName;

	/**
	 * sqlSession
	 */
	protected SqlSessionTemplate sqlSession;

	/**
	 * @return sqlSession
	 */
	public SqlSessionTemplate getSqlSession() {
		return sqlSession;
	}

	/**
	 * @param sqlSession
	 * 要注入的sqlSession
	 */
	@Autowired
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	@PostConstruct
	@SuppressWarnings("unchecked")
	public void init() {
		try {
			// 通过反射获取注解"M"(模型对象)的类类型
			this.entityClass = (Class<M>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

			this.statementName = this.entityClass.getName().substring(BASE_PACKAGE_NAME.length()).replace(EXCLUDE_STRING_1, "")+ DOT;
		} catch (Exception e) {

		}
	}

	@Override
	public int save(M model) {
		return this.sqlSession.insert(statementName + "save", model);
	}

	@Override
	public int batchSave(List<M> list) {
		return this.sqlSession.insert(statementName + "batchSave", list);
	}

	@Override
	public int update(M model) {
		return this.sqlSession.update(statementName + "update", model);
	}

	@Override
	public int delete(PK id) {
		return this.sqlSession.delete(statementName + "delete", id);
	}

	@Override
	public int batchDelete(List<PK> list) {
		return this.sqlSession.delete(statementName + "batchDelete", list);
	}

	@Override
	public int softDelete(PK id) {
		return this.sqlSession.update(statementName + "softDelete", id);
	}

	@Override
	public int batchSoftDelete(List<PK> list) {
		return this.sqlSession.update(statementName + "batchSoftDelete", list);
	}

	@Override
	public M get(PK id) {
		return this.sqlSession.selectOne(statementName + "get", id);
	}

	@Override
	public M getOne(M model) {
		return this.sqlSession.selectOne(statementName + "getOne", model);
	}
	
	@Override
	public List<M> getMany(List<PK> list) {
		return this.sqlSession.selectList(statementName + "getMany", list);
	}
	
	@Override
	public int countAll(M model) {
		return this.sqlSession.selectOne(statementName + "countAll", model);
	}

	@Override
	public List<M> listAll() {
		return this.sqlSession.selectList(statementName + "listAll");
	}

	@Override
	public List<M> listByPage(M model) {
		return this.sqlSession.selectList(statementName + "listByPage", model);
	}

	@Override
	public List<M> listByModel(M model) {
		return this.sqlSession.selectList(statementName + "listByModel", model);
	}

	@Override
	public int getItemIndex(M model) {
		return this.sqlSession.selectOne(statementName + "getItemIndex", model);
	}

	@Override
	public int batchUpdate(List<M> list) {
		return this.sqlSession.update(statementName + "batchUpdate", list);
	}

}

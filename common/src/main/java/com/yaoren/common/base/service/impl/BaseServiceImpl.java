package com.yaoren.common.base.service.impl;

import com.yaoren.common.base.constant.BaseConstants;
import com.yaoren.common.base.dao.BaseDao;
import com.yaoren.common.base.service.BaseService;
import com.yaoren.common.framework.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @ClassName: BaseServiceImpl
 * @Description: 通用服务实现类
 * @author zxh
 * @date 2014-8-29
 * 
 */
@Transactional
@Service("baseService")
public class BaseServiceImpl<M extends Serializable, PK extends Serializable> implements
        BaseService<M, PK>
{
    /**
     * 通用数据访问对象
     */
    private BaseDao<M, PK> baseDao;

    /**
     * @return baseDao
     */
    public BaseDao<M, PK> getBaseDao()
    {
        return baseDao;
    }

    /**
     * @param baseDao 要设置的 baseDao
     */
    @Autowired
    public void setBaseDao(BaseDao<M, PK> baseDao)
    {
        this.baseDao = baseDao;
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public int save(M model)
    {
        return this.getBaseDao().save(model);
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public int update(M model)
    {
        return this.getBaseDao().update(model);
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public int delete(PK id)
    {
        return this.getBaseDao().delete(id);
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public int batchDelete(List<PK> list)
    {
        return this.getBaseDao().batchDelete(list);
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public int softDelete(PK id)
    {
        return this.getBaseDao().softDelete(id);
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public int batchSoftDelete(List<PK> list)
    {
        return this.getBaseDao().batchSoftDelete(list);
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = true)
    public M get(PK id)
    {
        return this.getBaseDao().get(id);
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = true)
    public M getOne(M model)
    {
        return this.getBaseDao().getOne(model);
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = true)
    public List<M> getMany(List<PK> list)
    {
        return this.getBaseDao().getMany(list);
    }
    
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = true)
    public int countAll(M model)
    {
        return this.getBaseDao().countAll(model);
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = true)
    public List<M> listAll()
    {
        return this.getBaseDao().listAll();
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = true)
    public List<M> listByPage(M model)
    {
        return this.getBaseDao().listByPage(model);
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = true)
    public List<M> listByModel(M model)
    {
        return this.getBaseDao().listByModel(model);
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = true)
    public int getItemIndex(M model)
    {
        return getBaseDao().getItemIndex(model);
    }
    
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public int batchSave(List<M> list)
    {
        return this.getBaseDao().batchSave(list);
    }
    
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public int batchUpdate(List<M> list)
    {
        return this.getBaseDao().batchUpdate(list);
    }
    
    public Object getUserInSession()
    {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession().getAttribute(BaseConstants.USER_SESSION);
    }
    public String generateHeaderCode(String prefix){
    	return prefix+DateUtil.getDateTime(new Date(), DateUtil.DEFAULT_FULLDATETIME_FORMAT)+String.format("%06d",(int)(Math.random()*1000000));
    }
}

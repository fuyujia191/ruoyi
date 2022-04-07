package com.ruoyi.patent.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.patent.mapper.PCustomersMapper;
import com.ruoyi.patent.domain.PCustomers;
import com.ruoyi.patent.service.IPCustomersService;

/**
 * 客户列表Service业务层处理
 * 
 * @author jwinin
 * @date 2022-04-07
 */
@Service
public class PCustomersServiceImpl implements IPCustomersService 
{
    @Autowired
    private PCustomersMapper pCustomersMapper;

    /**
     * 查询客户列表
     * 
     * @param id 客户列表主键
     * @return 客户列表
     */
    @Override
    public PCustomers selectPCustomersById(Long id)
    {
        return pCustomersMapper.selectPCustomersById(id);
    }

    /**
     * 查询客户列表列表
     * 
     * @param pCustomers 客户列表
     * @return 客户列表
     */
    @Override
    public List<PCustomers> selectPCustomersList(PCustomers pCustomers)
    {
        return pCustomersMapper.selectPCustomersList(pCustomers);
    }

    /**
     * 新增客户列表
     * 
     * @param pCustomers 客户列表
     * @return 结果
     */
    @Override
    public int insertPCustomers(PCustomers pCustomers)
    {
        return pCustomersMapper.insertPCustomers(pCustomers);
    }

    /**
     * 修改客户列表
     * 
     * @param pCustomers 客户列表
     * @return 结果
     */
    @Override
    public int updatePCustomers(PCustomers pCustomers)
    {
        return pCustomersMapper.updatePCustomers(pCustomers);
    }

    /**
     * 批量删除客户列表
     * 
     * @param ids 需要删除的客户列表主键
     * @return 结果
     */
    @Override
    public int deletePCustomersByIds(Long[] ids)
    {
        return pCustomersMapper.deletePCustomersByIds(ids);
    }

    /**
     * 删除客户列表信息
     * 
     * @param id 客户列表主键
     * @return 结果
     */
    @Override
    public int deletePCustomersById(Long id)
    {
        return pCustomersMapper.deletePCustomersById(id);
    }
}

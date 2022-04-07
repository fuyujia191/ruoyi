package com.ruoyi.patent.service;

import java.util.List;
import com.ruoyi.patent.domain.PCustomers;

/**
 * 客户列表Service接口
 * 
 * @author jwinin
 * @date 2022-04-07
 */
public interface IPCustomersService 
{
    /**
     * 查询客户列表
     * 
     * @param id 客户列表主键
     * @return 客户列表
     */
    public PCustomers selectPCustomersById(Long id);

    /**
     * 查询客户列表列表
     * 
     * @param pCustomers 客户列表
     * @return 客户列表集合
     */
    public List<PCustomers> selectPCustomersList(PCustomers pCustomers);

    /**
     * 新增客户列表
     * 
     * @param pCustomers 客户列表
     * @return 结果
     */
    public int insertPCustomers(PCustomers pCustomers);

    /**
     * 修改客户列表
     * 
     * @param pCustomers 客户列表
     * @return 结果
     */
    public int updatePCustomers(PCustomers pCustomers);

    /**
     * 批量删除客户列表
     * 
     * @param ids 需要删除的客户列表主键集合
     * @return 结果
     */
    public int deletePCustomersByIds(Long[] ids);

    /**
     * 删除客户列表信息
     * 
     * @param id 客户列表主键
     * @return 结果
     */
    public int deletePCustomersById(Long id);
}

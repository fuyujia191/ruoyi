package com.ruoyi.patent.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.patent.domain.PCustomers;
import com.ruoyi.patent.service.IPCustomersService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 客户列表Controller
 * 
 * @author jwinin
 * @date 2022-04-07
 */
@RestController
@RequestMapping("/patent/customers")
public class PCustomersController extends BaseController
{
    @Autowired
    private IPCustomersService pCustomersService;

    /**
     * 查询客户列表列表
     */
    @PreAuthorize("@ss.hasPermi('patent:customers:list')")
    @GetMapping("/list")
    public TableDataInfo list(PCustomers pCustomers)
    {
        startPage();
        List<PCustomers> list = pCustomersService.selectPCustomersList(pCustomers);
        return getDataTable(list);
    }

    /**
     * 导出客户列表列表
     */
    @PreAuthorize("@ss.hasPermi('patent:customers:export')")
    @Log(title = "客户列表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PCustomers pCustomers)
    {
        List<PCustomers> list = pCustomersService.selectPCustomersList(pCustomers);
        ExcelUtil<PCustomers> util = new ExcelUtil<PCustomers>(PCustomers.class);
        util.exportExcel(response, list, "客户列表数据");
    }

    /**
     * 获取客户列表详细信息
     */
    @PreAuthorize("@ss.hasPermi('patent:customers:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(pCustomersService.selectPCustomersById(id));
    }

    /**
     * 新增客户列表
     */
    @PreAuthorize("@ss.hasPermi('patent:customers:add')")
    @Log(title = "客户列表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PCustomers pCustomers)
    {
        return toAjax(pCustomersService.insertPCustomers(pCustomers));
    }

    /**
     * 修改客户列表
     */
    @PreAuthorize("@ss.hasPermi('patent:customers:edit')")
    @Log(title = "客户列表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PCustomers pCustomers)
    {
        return toAjax(pCustomersService.updatePCustomers(pCustomers));
    }

    /**
     * 删除客户列表
     */
    @PreAuthorize("@ss.hasPermi('patent:customers:remove')")
    @Log(title = "客户列表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(pCustomersService.deletePCustomersByIds(ids));
    }
}

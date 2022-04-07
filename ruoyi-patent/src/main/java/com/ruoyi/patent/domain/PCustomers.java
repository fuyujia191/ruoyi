package com.ruoyi.patent.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 客户列表对象 p_customers
 * 
 * @author jwinin
 * @date 2022-04-07
 */
public class PCustomers extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String customerName;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long type;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String address;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String relationPerson;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String mobile;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String tel;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String relationPerson2;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String mobile2;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String tel2;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long departId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long personId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date adddate;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date editdate;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long status;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date limitdate;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date lastrelationtime;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long relationPersonid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String wx;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String qq;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long followStatus;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCustomerName(String customerName) 
    {
        this.customerName = customerName;
    }

    public String getCustomerName() 
    {
        return customerName;
    }
    public void setType(Long type) 
    {
        this.type = type;
    }

    public Long getType() 
    {
        return type;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setRelationPerson(String relationPerson) 
    {
        this.relationPerson = relationPerson;
    }

    public String getRelationPerson() 
    {
        return relationPerson;
    }
    public void setMobile(String mobile) 
    {
        this.mobile = mobile;
    }

    public String getMobile() 
    {
        return mobile;
    }
    public void setTel(String tel) 
    {
        this.tel = tel;
    }

    public String getTel() 
    {
        return tel;
    }
    public void setRelationPerson2(String relationPerson2) 
    {
        this.relationPerson2 = relationPerson2;
    }

    public String getRelationPerson2() 
    {
        return relationPerson2;
    }
    public void setMobile2(String mobile2) 
    {
        this.mobile2 = mobile2;
    }

    public String getMobile2() 
    {
        return mobile2;
    }
    public void setTel2(String tel2) 
    {
        this.tel2 = tel2;
    }

    public String getTel2() 
    {
        return tel2;
    }
    public void setDepartId(Long departId) 
    {
        this.departId = departId;
    }

    public Long getDepartId() 
    {
        return departId;
    }
    public void setPersonId(Long personId) 
    {
        this.personId = personId;
    }

    public Long getPersonId() 
    {
        return personId;
    }
    public void setAdddate(Date adddate) 
    {
        this.adddate = adddate;
    }

    public Date getAdddate() 
    {
        return adddate;
    }
    public void setEditdate(Date editdate) 
    {
        this.editdate = editdate;
    }

    public Date getEditdate() 
    {
        return editdate;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }
    public void setLimitdate(Date limitdate) 
    {
        this.limitdate = limitdate;
    }

    public Date getLimitdate() 
    {
        return limitdate;
    }
    public void setLastrelationtime(Date lastrelationtime) 
    {
        this.lastrelationtime = lastrelationtime;
    }

    public Date getLastrelationtime() 
    {
        return lastrelationtime;
    }
    public void setRelationPersonid(Long relationPersonid) 
    {
        this.relationPersonid = relationPersonid;
    }

    public Long getRelationPersonid() 
    {
        return relationPersonid;
    }
    public void setWx(String wx) 
    {
        this.wx = wx;
    }

    public String getWx() 
    {
        return wx;
    }
    public void setQq(String qq) 
    {
        this.qq = qq;
    }

    public String getQq() 
    {
        return qq;
    }
    public void setFollowStatus(Long followStatus) 
    {
        this.followStatus = followStatus;
    }

    public Long getFollowStatus() 
    {
        return followStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("customerName", getCustomerName())
            .append("type", getType())
            .append("address", getAddress())
            .append("relationPerson", getRelationPerson())
            .append("mobile", getMobile())
            .append("tel", getTel())
            .append("relationPerson2", getRelationPerson2())
            .append("mobile2", getMobile2())
            .append("tel2", getTel2())
            .append("departId", getDepartId())
            .append("personId", getPersonId())
            .append("adddate", getAdddate())
            .append("editdate", getEditdate())
            .append("remark", getRemark())
            .append("status", getStatus())
            .append("limitdate", getLimitdate())
            .append("lastrelationtime", getLastrelationtime())
            .append("relationPersonid", getRelationPersonid())
            .append("wx", getWx())
            .append("qq", getQq())
            .append("followStatus", getFollowStatus())
            .toString();
    }
}

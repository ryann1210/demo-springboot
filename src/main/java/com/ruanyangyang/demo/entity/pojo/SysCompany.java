package com.ruanyangyang.demo.entity.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 公司表
 * </p>
 *
 * @author ryan
 * @since 2020-06-15
 */
public class SysCompany implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 公司名称
     */
    private String name;

    /**
     * 企业性质
     */
    private String nature;

    /**
     * 固定电话
     */
    private String mobile;

    /**
     * 详细地址
     */
    private String address;

    /**
     * 联系人姓名
     */
    private String contactName;

    /**
     * 联系人手机
     */
    private String contactPhone;

    /**
     * 企业人数
     */
    private Integer employeeNum;

    /**
     * 企业行业
     */
    private String industry;

    /**
     * 省份
     */
    private String province;

    /**
     * 城市
     */
    private String city;

    /**
     * 区县
     */
    private String area;

    /**
     * 经营范围
     */
    private String businessScope;

    /**
     * 公司邮箱
     */
    private String email;

    /**
     * 货主资质图片
     */
    private String shipperPicUrl;

    /**
     * 是否货主审核 0审核中 1审核通过 2审核失败
     */
    private Integer shiperValid;

    /**
     * 司机资质图片
     */
    private String driverPicUrl;

    /**
     * 是否司机审核 0审核中 1审核通过 2审核失败
     */
    private Integer driverValid;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public Integer getEmployeeNum() {
        return employeeNum;
    }

    public void setEmployeeNum(Integer employeeNum) {
        this.employeeNum = employeeNum;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getBusinessScope() {
        return businessScope;
    }

    public void setBusinessScope(String businessScope) {
        this.businessScope = businessScope;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getShipperPicUrl() {
        return shipperPicUrl;
    }

    public void setShipperPicUrl(String shipperPicUrl) {
        this.shipperPicUrl = shipperPicUrl;
    }

    public Integer getShiperValid() {
        return shiperValid;
    }

    public void setShiperValid(Integer shiperValid) {
        this.shiperValid = shiperValid;
    }

    public String getDriverPicUrl() {
        return driverPicUrl;
    }

    public void setDriverPicUrl(String driverPicUrl) {
        this.driverPicUrl = driverPicUrl;
    }

    public Integer getDriverValid() {
        return driverValid;
    }

    public void setDriverValid(Integer driverValid) {
        this.driverValid = driverValid;
    }

    @Override
    public String toString() {
        return "SysCompany{" +
        "id=" + id +
        ", name=" + name +
        ", nature=" + nature +
        ", mobile=" + mobile +
        ", address=" + address +
        ", contactName=" + contactName +
        ", contactPhone=" + contactPhone +
        ", employeeNum=" + employeeNum +
        ", industry=" + industry +
        ", province=" + province +
        ", city=" + city +
        ", area=" + area +
        ", businessScope=" + businessScope +
        ", email=" + email +
        ", shipperPicUrl=" + shipperPicUrl +
        ", shiperValid=" + shiperValid +
        ", driverPicUrl=" + driverPicUrl +
        ", driverValid=" + driverValid +
        "}";
    }
}

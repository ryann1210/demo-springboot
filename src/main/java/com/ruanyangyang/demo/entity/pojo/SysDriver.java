package com.ruanyangyang.demo.entity.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author ryan
 * @since 2020-06-15
 */
public class SysDriver implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 姓名
     */
    private String driverName;

    /**
     * 公司id
     */
    private Integer companyId;

    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 性别 0女 1男
     */
    private Boolean sex;

    /**
     * 驾驶证号
     */
    private String driverLicense;

    /**
     * 驾照种类
     */
    private String driverType;

    /**
     * 驾照（起）
     */
    private Long driverLicenseStart;

    /**
     * 驾照（止）
     */
    private Long driverLicenseEnd;

    /**
     * 驾照图片url
     */
    private String driverLicenseUrl;

    /**
     * 从业资格证
     */
    private String driverNvq;

    /**
     * 从业资格证url
     */
    private String driverNvqUrl;

    /**
     * 从业资格证（起）
     */
    private Long driverNvqStart;

    /**
     * 从业资格证（止）
     */
    private Long driverNvqEnd;

    /**
     * 是否审核 0审核中 1审核通过 2审核拒绝
     */
    private Integer vaild;

    /**
     * 是否营运 0暂停营运 1营运中
     */
    private Integer status;

    /**
     * 是否锁定 0未锁定 1锁定
     */
    private Integer locked;

    /**
     * 评分
     */
    private Integer score;

    /**
     * 被评价次数
     */
    private Integer scoreNum;

    /**
     * 删除标识 0未删除 1已删除
     */
    private Boolean deleteFlag;

    /**
     * 接单次数
     */
    private Integer orderNum;

    /**
     * 接单公里数
     */
    private Double orderKm;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getDriverLicense() {
        return driverLicense;
    }

    public void setDriverLicense(String driverLicense) {
        this.driverLicense = driverLicense;
    }

    public String getDriverType() {
        return driverType;
    }

    public void setDriverType(String driverType) {
        this.driverType = driverType;
    }

    public Long getDriverLicenseStart() {
        return driverLicenseStart;
    }

    public void setDriverLicenseStart(Long driverLicenseStart) {
        this.driverLicenseStart = driverLicenseStart;
    }

    public Long getDriverLicenseEnd() {
        return driverLicenseEnd;
    }

    public void setDriverLicenseEnd(Long driverLicenseEnd) {
        this.driverLicenseEnd = driverLicenseEnd;
    }

    public String getDriverLicenseUrl() {
        return driverLicenseUrl;
    }

    public void setDriverLicenseUrl(String driverLicenseUrl) {
        this.driverLicenseUrl = driverLicenseUrl;
    }

    public String getDriverNvq() {
        return driverNvq;
    }

    public void setDriverNvq(String driverNvq) {
        this.driverNvq = driverNvq;
    }

    public String getDriverNvqUrl() {
        return driverNvqUrl;
    }

    public void setDriverNvqUrl(String driverNvqUrl) {
        this.driverNvqUrl = driverNvqUrl;
    }

    public Long getDriverNvqStart() {
        return driverNvqStart;
    }

    public void setDriverNvqStart(Long driverNvqStart) {
        this.driverNvqStart = driverNvqStart;
    }

    public Long getDriverNvqEnd() {
        return driverNvqEnd;
    }

    public void setDriverNvqEnd(Long driverNvqEnd) {
        this.driverNvqEnd = driverNvqEnd;
    }

    public Integer getVaild() {
        return vaild;
    }

    public void setVaild(Integer vaild) {
        this.vaild = vaild;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getLocked() {
        return locked;
    }

    public void setLocked(Integer locked) {
        this.locked = locked;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getScoreNum() {
        return scoreNum;
    }

    public void setScoreNum(Integer scoreNum) {
        this.scoreNum = scoreNum;
    }

    public Boolean getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public Double getOrderKm() {
        return orderKm;
    }

    public void setOrderKm(Double orderKm) {
        this.orderKm = orderKm;
    }

    @Override
    public String toString() {
        return "SysDriver{" +
        "id=" + id +
        ", userId=" + userId +
        ", driverName=" + driverName +
        ", companyId=" + companyId +
        ", companyName=" + companyName +
        ", sex=" + sex +
        ", driverLicense=" + driverLicense +
        ", driverType=" + driverType +
        ", driverLicenseStart=" + driverLicenseStart +
        ", driverLicenseEnd=" + driverLicenseEnd +
        ", driverLicenseUrl=" + driverLicenseUrl +
        ", driverNvq=" + driverNvq +
        ", driverNvqUrl=" + driverNvqUrl +
        ", driverNvqStart=" + driverNvqStart +
        ", driverNvqEnd=" + driverNvqEnd +
        ", vaild=" + vaild +
        ", status=" + status +
        ", locked=" + locked +
        ", score=" + score +
        ", scoreNum=" + scoreNum +
        ", deleteFlag=" + deleteFlag +
        ", orderNum=" + orderNum +
        ", orderKm=" + orderKm +
        "}";
    }
}

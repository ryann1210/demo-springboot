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
public class SysVehicle implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 司机id
     */
    private Integer driverId;

    /**
     * 车牌号
     */
    private String plateNum;

    /**
     * 车辆类型
     */
    private String vehicleType;

    /**
     * 是否冷藏 0非冷藏 1冷藏
     */
    private Integer coldStorage;

    /**
     * 载重量（t）
     */
    private Double loadCapacity;

    /**
     * 是否带挂车
     */
    private Integer trailerFlag;

    /**
     * 挂车车牌
     */
    private String trailerPlateNum;

    /**
     * 所有人（可为公司名）
     */
    private String ownerName;

    /**
     * 行驶证
     */
    private String vehicleLicense;

    /**
     * 道路运输许可证
     */
    private String roadTransport;

    /**
     * 道路运输许可证url
     */
    private String roadTransportUrl;

    /**
     * 车辆照片
     */
    private String picture;

    /**
     * 创建时间
     */
    private Long createTime;

    /**
     * 创建人
     */
    private Long createUser;

    /**
     * 修改时间
     */
    private Long updateTime;

    /**
     * 修改人
     */
    private Long updateUser;

    /**
     * 审核状态 0审核中 1审核通过 2审核拒绝
     */
    private Integer valid;

    /**
     * 出厂日期
     */
    private Long factoryTime;

    /**
     * 是否删除 0未删除 1删除
     */
    private Boolean deleteFlag;

    /**
     * 是否升降尾门 0非 1是
     */
    private Boolean liftGate;

    /**
     * 公司id
     */
    private Long companyId;

    /**
     * 公司名称
     */
    private String companyName;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDriverId() {
        return driverId;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }

    public String getPlateNum() {
        return plateNum;
    }

    public void setPlateNum(String plateNum) {
        this.plateNum = plateNum;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Integer getColdStorage() {
        return coldStorage;
    }

    public void setColdStorage(Integer coldStorage) {
        this.coldStorage = coldStorage;
    }

    public Double getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(Double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    public Integer getTrailerFlag() {
        return trailerFlag;
    }

    public void setTrailerFlag(Integer trailerFlag) {
        this.trailerFlag = trailerFlag;
    }

    public String getTrailerPlateNum() {
        return trailerPlateNum;
    }

    public void setTrailerPlateNum(String trailerPlateNum) {
        this.trailerPlateNum = trailerPlateNum;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getVehicleLicense() {
        return vehicleLicense;
    }

    public void setVehicleLicense(String vehicleLicense) {
        this.vehicleLicense = vehicleLicense;
    }

    public String getRoadTransport() {
        return roadTransport;
    }

    public void setRoadTransport(String roadTransport) {
        this.roadTransport = roadTransport;
    }

    public String getRoadTransportUrl() {
        return roadTransportUrl;
    }

    public void setRoadTransportUrl(String roadTransportUrl) {
        this.roadTransportUrl = roadTransportUrl;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public Long getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }

    public Long getFactoryTime() {
        return factoryTime;
    }

    public void setFactoryTime(Long factoryTime) {
        this.factoryTime = factoryTime;
    }

    public Boolean getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Boolean getLiftGate() {
        return liftGate;
    }

    public void setLiftGate(Boolean liftGate) {
        this.liftGate = liftGate;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "SysVehicle{" +
        "id=" + id +
        ", driverId=" + driverId +
        ", plateNum=" + plateNum +
        ", vehicleType=" + vehicleType +
        ", coldStorage=" + coldStorage +
        ", loadCapacity=" + loadCapacity +
        ", trailerFlag=" + trailerFlag +
        ", trailerPlateNum=" + trailerPlateNum +
        ", ownerName=" + ownerName +
        ", vehicleLicense=" + vehicleLicense +
        ", roadTransport=" + roadTransport +
        ", roadTransportUrl=" + roadTransportUrl +
        ", picture=" + picture +
        ", createTime=" + createTime +
        ", createUser=" + createUser +
        ", updateTime=" + updateTime +
        ", updateUser=" + updateUser +
        ", valid=" + valid +
        ", factoryTime=" + factoryTime +
        ", deleteFlag=" + deleteFlag +
        ", liftGate=" + liftGate +
        ", companyId=" + companyId +
        ", companyName=" + companyName +
        "}";
    }
}

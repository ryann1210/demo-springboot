package com.ruanyangyang.demo.entity.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 操作日志
 * </p>
 *
 * @author ryan
 * @since 2020-06-15
 */
public class SysOperateLog implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户id（-1为未登录用户操作）
     */
    private Integer userId;

    /**
     * ip
     */
    private String ip;

    /**
     * 操作类型 执行动作
     */
    private String operateType;

    /**
     * 操作详情
     */
    private String operateDetail;

    /**
     * 功能模块
     */
    private String module;

    /**
     * 操作来源
     */
    private String source;

    /**
     * 创建时间
     */
    private Long createTime;


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

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getOperateType() {
        return operateType;
    }

    public void setOperateType(String operateType) {
        this.operateType = operateType;
    }

    public String getOperateDetail() {
        return operateDetail;
    }

    public void setOperateDetail(String operateDetail) {
        this.operateDetail = operateDetail;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "SysOperateLog{" +
        "id=" + id +
        ", userId=" + userId +
        ", ip=" + ip +
        ", operateType=" + operateType +
        ", operateDetail=" + operateDetail +
        ", module=" + module +
        ", source=" + source +
        ", createTime=" + createTime +
        "}";
    }
}

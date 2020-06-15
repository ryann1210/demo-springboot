package com.ruanyangyang.demo.entity.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("operate_log")
public class OperateLog implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("用户id")
    @TableField(value = "user_id")
    private Long userId;

    @ApiModelProperty("ip")
    @TableField(value = "ip")
    private String ip;

    @ApiModelProperty("操作类型,执行动作")
    @TableField(value = "operate_type")
    private String operateType;

    @ApiModelProperty("操作详情")
    @TableField(value = "operate_detail")
    private String operateDetail;

    @ApiModelProperty("功能模块")
    @TableField(value = "module")
    private String module;

    @ApiModelProperty("操作来源")
    @TableField(value = "source")
    private String source;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "create_time")
    private Long createTime;
}

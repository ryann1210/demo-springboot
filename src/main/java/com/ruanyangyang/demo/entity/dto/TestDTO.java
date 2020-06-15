package com.ruanyangyang.demo.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("测试请求参数")
public class TestDTO {

    @ApiModelProperty("测试条件1")
    private String cond1;

    @ApiModelProperty("测试条件2")
    private String cond2;

}

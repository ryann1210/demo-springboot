package com.ruanyangyang.demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@ApiModel("列表数据结构")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultList<T> implements Serializable {

    @ApiModelProperty("列表数据")
    private List<T> list;

    @ApiModelProperty("数量")
    private Integer count;

}

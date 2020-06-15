package com.ruanyangyang.demo.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.ruanyangyang.demo.entity.ResultCode.OK;

@ApiModel("REST API 响应工具")
@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result<T> {

    @ApiModelProperty("业务错误码")
    private long code;

    @ApiModelProperty("描述")
    private String message;

    @ApiModelProperty("结果集")
    private T data;

    public static <T> Result<T> ok(){
        return restResult(OK, null);
    }

    public static <T> Result<T> ok(T data){
        return restResult(OK, data);
    }

    public static <T> Result<T> error(IResultCode resultCode){
        return restResult(resultCode, null);
    }

    private static <T> Result<T> restResult(IResultCode resultCode, T data) {
        return restResult(resultCode.getCode(), resultCode.getMsg(), data);
    }

    private static <T> Result<T> restResult(long code, String msg, T data) {
        Result<T> apiResult = new Result<>();
        apiResult.setCode(code);
        apiResult.setMessage(msg);
        apiResult.setData(data);
        return apiResult;
    }
}

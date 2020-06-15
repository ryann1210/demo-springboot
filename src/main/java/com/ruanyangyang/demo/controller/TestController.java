package com.ruanyangyang.demo.controller;

import com.ruanyangyang.demo.common.annotation.OperationLog;
import com.ruanyangyang.demo.entity.Result;
import com.ruanyangyang.demo.entity.dto.TestDTO;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/test")
@Api(tags = {"测试模块"})
@CrossOrigin(origins = "*", maxAge = 3600)
public class TestController extends BaseController{

    @ApiOperation(value="测试接口", notes="测试接口")
    @RequestMapping(path = "/test", method = RequestMethod.POST)
    @OperationLog(module = "测试模块", method = "测试方法")
    public Result<TestDTO> test(@RequestBody TestDTO dto) {
        log.info(dto.toString());
        return Result.ok(dto);
    }
}

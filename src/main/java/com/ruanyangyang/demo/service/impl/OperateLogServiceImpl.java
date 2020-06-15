package com.ruanyangyang.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruanyangyang.demo.dao.OperateLogMapper;
import com.ruanyangyang.demo.entity.pojo.OperateLog;
import com.ruanyangyang.demo.service.OperateLogService;
import org.springframework.stereotype.Service;

@Service
public class OperateLogServiceImpl extends ServiceImpl<OperateLogMapper, OperateLog> implements OperateLogService {
}

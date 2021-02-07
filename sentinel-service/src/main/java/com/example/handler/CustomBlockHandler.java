package com.example.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.example.config.CommonResult;

public class CustomBlockHandler {
    public static CommonResult handleException(BlockException exception){
        return new CommonResult("自定义限流处理",200);
    }
}

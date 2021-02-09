package com.example.controller;

import com.example.config.CommonResult;
import com.example.entity.vo.UserVo;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Validated
@Controller
@RequestMapping("/validator")
public class ValidatorController {
    @GetMapping("/age")
    @ResponseBody
    public CommonResult age(@Min(value = 10,message = "年龄最小为10")@Max(value = 100,message = "年龄最大为100")@NotNull(message = "年龄不能为空") @RequestParam("age") Integer age) {
        return CommonResult.success("this is age");
    }

    @PostMapping("/user")
    @ResponseBody
    public CommonResult user(@Validated @RequestBody UserVo userVo) {
        System.out.println(userVo.toString());
        return CommonResult.success("very good");
    }
}

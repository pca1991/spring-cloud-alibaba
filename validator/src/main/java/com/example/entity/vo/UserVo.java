package com.example.entity.vo;

import com.example.annotations.FlagValidator;
import lombok.Data;

import javax.validation.constraints.*;
@Data
public class UserVo {
    @Size(min = 2,max = 10,message = "name:姓名长度必须为1到10")
    private String name;

    //@Range(min=10, max=100,message = "年龄需位于10到100之间")
    @Min(value = 10,message = "age:年龄最小为10")
    @Max(value = 100,message = "age:年龄最大为100")
    private int age;

    @NotNull(message = "mobile:手机号码不能为空")
    @Size(min = 11, max = 11, message = "mobile:手机号码必须为11位")
    @Pattern(regexp="^[1]\\d{10}$", message="mobile:手机号码格式错误")
    private String mobile;

    @NotBlank(message = "email:邮箱不能为空")
    @Email(message = "email:邮箱格式错误")
    private String email;

    @FlagValidator(value = {"0","1"},message = "state:状态只能为0或1")
    @NotNull(message = "state:状态不能为空")
    private Integer state;
}

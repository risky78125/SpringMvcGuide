package com.wuqi.dev.entity;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;

public class UserInfo {

    public interface LoginGroup {}
    public interface RegisterGroup {}

    @NotBlank(message = "用户名不能为空", groups = {LoginGroup.class, RegisterGroup.class})
    @Length(min = 8, max = 20, message = "用户名长度必须在8-20位之间", groups = {LoginGroup.class, RegisterGroup.class})
    private String username;

    @NotBlank(message = "密码不能为空", groups = {LoginGroup.class, RegisterGroup.class})
    @Length(min = 8, max = 20, message = "密码长度必须在8-20位之间", groups = {LoginGroup.class, RegisterGroup.class})
    private String password;

    @NotBlank(message = "手机号不能为空", groups = {RegisterGroup.class})
    @Pattern(regexp = "1[3-9][0-9]{9}", message = "手机号码不符合规则", groups = {RegisterGroup.class})
    private String mobile;

    @NotBlank(message = "邮箱不能为空", groups = {RegisterGroup.class})
    @Email(message = "邮箱格式不正确", groups = {RegisterGroup.class})
    private String email;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "生日不能为空", groups = {RegisterGroup.class})
    @Past(message = "需要填写一个过去的时间", groups = {RegisterGroup.class})
    private Date birthday;


    private String idCardNo;

    @AssertTrue(message = "请同意协议", groups = {RegisterGroup.class})
    private boolean agree;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getIdCardNo() {
        return idCardNo;
    }

    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }

    public boolean isAgree() {
        return agree;
    }

    public void setAgree(boolean agree) {
        this.agree = agree;
    }
}

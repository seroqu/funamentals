package com.fundamentos.springboot.fundamentos.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
@ConfigurationProperties(prefix = "user")
public class UserPojo {

    private String email;
    private String psw;
    private int age;

    public UserPojo(String email, String psw, int age) {
        this.email = email;
        this.psw = psw;
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

package com.example.ben_d.minipro.service;

/**
 * Created by ben_d on 16.10.2017.
 */

public class LoginToken {
    private String customerId;
    private String securityToken;

    public String getSecurityToken() {
        return securityToken;
    }

    public void setSecurityToken(String securityToken) {
        this.securityToken = securityToken;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}

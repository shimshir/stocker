package org.admir.security.model;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

/**
 * Created by memicadm on 22.05.2014.
 */
public class DbUser {
    /**
     * The username
     */
    private String username;

    /**
     * The password as an MD5 value
     */
    private String password;

    /**
     * Access level of the user.
     * 1 = Admin user
     * 2 = Regular user
     */
    private Integer access;

    public DbUser() {
    }

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

    public Integer getAccess() {
        return access;
    }

    public void setAccess(Integer access) {
        this.access = access;
    }
}

package by.itacademy.javaenterprise.goralchuk.entity;

import lombok.Getter;

public enum RoleUser {
    ROLE_USER("user"),
    ROLE_ADMIN("admin"),
    ROLE_DOCTOR("doctor"),
    ROLE_MANAGER("manager"),
    ROLE_PATIENT("patient");

    @Getter
    private final String code;

    RoleUser(String code) {
        this.code = code;
    }
}

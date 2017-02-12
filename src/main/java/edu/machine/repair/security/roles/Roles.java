package edu.machine.repair.security.roles;

public enum Roles {

    ADMIN("ROLE_ADMIN"),
    MANAGER("ROLE_MANAGER"),
    CLIENT("ROLE_CLIENT");

    private String value;

    Roles(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}

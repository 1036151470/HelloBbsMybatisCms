package com.hellobbs.database;

public class Permission {
    private int id;
    private String username;
    private String userroles;
    private String permissions;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserroles() {
        return userroles;
    }

    public void setUserroles(String userroles) {
        this.userroles = userroles;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", userroles='" + userroles + '\'' +
                ", permissions='" + permissions + '\'' +
                '}';
    }
}

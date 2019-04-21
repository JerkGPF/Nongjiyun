package com.example.administrator.myapplication.utils;

/**
 * Created by Administrator on 2018/5/15.
 */

public class UserMessage {

    /**
     * user_info_id : 1
     * account : 15751185382
     * role : 普通农户
     * nickname : test1
     * avatar : null
     * organization_name : null
     * education : null
     * sex : null
     * email : null
     * city : 南京市
     * distrit : 栖霞区
     * del_flag : 0
     * status : 0
     * create_time : null
     * update_time : 1525918526000
     * sort_time : null
     * info_complete : 0
     */

    private int user_info_id;
    private String account;
    private String role;
    private String nickname;
    private Object avatar;
    private Object organization_name;
    private Object education;
    private Object sex;
    private Object email;
    private String city;
    private String distrit;
    private int del_flag;
    private int status;
    private Object create_time;
    private long update_time;
    private Object sort_time;
    private int info_complete;

    public int getUser_info_id() {
        return user_info_id;
    }

    public void setUser_info_id(int user_info_id) {
        this.user_info_id = user_info_id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Object getAvatar() {
        return avatar;
    }

    public void setAvatar(Object avatar) {
        this.avatar = avatar;
    }

    public Object getOrganization_name() {
        return organization_name;
    }

    public void setOrganization_name(Object organization_name) {
        this.organization_name = organization_name;
    }

    public Object getEducation() {
        return education;
    }

    public void setEducation(Object education) {
        this.education = education;
    }

    public Object getSex() {
        return sex;
    }

    public void setSex(Object sex) {
        this.sex = sex;
    }

    public Object getEmail() {
        return email;
    }

    public void setEmail(Object email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrit() {
        return distrit;
    }

    public void setDistrit(String distrit) {
        this.distrit = distrit;
    }

    public int getDel_flag() {
        return del_flag;
    }

    public void setDel_flag(int del_flag) {
        this.del_flag = del_flag;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Object create_time) {
        this.create_time = create_time;
    }

    public long getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(long update_time) {
        this.update_time = update_time;
    }

    public Object getSort_time() {
        return sort_time;
    }

    public void setSort_time(Object sort_time) {
        this.sort_time = sort_time;
    }

    public int getInfo_complete() {
        return info_complete;
    }

    public void setInfo_complete(int info_complete) {
        this.info_complete = info_complete;
    }

    @Override
    public String toString() {
        return "UserMessage{" +
                "user_info_id=" + user_info_id +
                ", account='" + account + '\'' +
                ", role='" + role + '\'' +
                ", nickname='" + nickname + '\'' +
                ", avatar=" + avatar +
                ", organization_name=" + organization_name +
                ", education=" + education +
                ", sex=" + sex +
                ", email=" + email +
                ", city='" + city + '\'' +
                ", distrit='" + distrit + '\'' +
                ", del_flag=" + del_flag +
                ", status=" + status +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                ", sort_time=" + sort_time +
                ", info_complete=" + info_complete +
                '}';
    }
}

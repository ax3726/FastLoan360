package com.xjd.a360fastloan.model.mine;

/**
 * Created by shiqingqing on 2019/7/16.
 */

public class CardModel {

    /**
     * id : 1
     * user_id : 2
     * number : 6222620290001716639
     * mobile : 15170183726
     * logo : https://apimg.alipay.com/combo.png?d=cashier&t=COMM
     * name : 交通银行
     * type : 储蓄卡
     * code : null
     * date : null
     * created_at : 2019-07-15 22:39:17
     * updated_at : 2019-07-15 22:39:17
     */

    private int id;
    private int user_id;
    private String number;
    private String mobile;
    private String logo;
    private String name;
    private String type;
    private Object code;
    private Object date;
    private String created_at;
    private String updated_at;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getCode() {
        return code;
    }

    public void setCode(Object code) {
        this.code = code;
    }

    public Object getDate() {
        return date;
    }

    public void setDate(Object date) {
        this.date = date;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
}

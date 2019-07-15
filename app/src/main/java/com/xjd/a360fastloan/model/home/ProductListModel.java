package com.xjd.a360fastloan.model.home;

public class ProductListModel {

    /**
     * id : 1
     * name : 360极速借
     * icon : /storage/files/PtnGH2bPS3Y4r3uPcccwRXBPNDByFTkKnM9tU8bl.png
     * min : 1000
     * max : 15000
     * rebate : 0.60
     * cycle : 90天
     * price : 198.00
     * v_click : 500万
     * url : null
     * created_at : 2019-06-20 13:19:26
     * updated_at : 2019-06-20 13:19:26
     * deleted_at : null
     * iconsrc : http://cash.local/storage/files/PtnGH2bPS3Y4r3uPcccwRXBPNDByFTkKnM9tU8bl.png
     */
    private boolean is_select = false;

    private int    id;
    private String name;
    private String icon;
    private int    min;
    private int    max;
    private String rebate;
    private String cycle;
    private double price;
    private String v_click;
    private String url;
    private String created_at;
    private String updated_at;
    private String deleted_at;
    private String iconsrc;

    public boolean isIs_select() {
        return is_select;
    }

    public void setIs_select(boolean is_select) {
        this.is_select = is_select;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public String getRebate() {
        return rebate;
    }

    public void setRebate(String rebate) {
        this.rebate = rebate;
    }

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getV_click() {
        return v_click;
    }

    public void setV_click(String v_click) {
        this.v_click = v_click;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public String getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(String deleted_at) {
        this.deleted_at = deleted_at;
    }

    public String getIconsrc() {
        return iconsrc;
    }

    public void setIconsrc(String iconsrc) {
        this.iconsrc = iconsrc;
    }
}

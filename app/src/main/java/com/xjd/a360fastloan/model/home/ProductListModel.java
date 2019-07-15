package com.xjd.a360fastloan.model.home;

public class ProductListModel {


    /**
     * id : 2
     * name : 快贷网
     * icon : files/Ovfa82v8Z0ni7aXBxp4Hn4FIFIzDuClqmAUI8XyN.png
     * min : 1000
     * max : 30000
     * rebate : 1.00
     * cycle : 90天
     * price : 9.00
     * v_click : 500万
     * url : https://pan.baidu.com/play/video#/video?path=%2Fxfx.mkv&t=-1
     * created_at : 2019-07-15 20:29:53
     * updated_at : 2019-07-15 20:36:53
     * deleted_at : null
     * iconsrc : http://cash.free.idcfengye.com/storage/files/Ovfa82v8Z0ni7aXBxp4Hn4FIFIzDuClqmAUI8XyN.png
     */
//<<<<<<< HEAD
//
//    private boolean is_select = false;
//
//    private int    id;
//=======
    private boolean is_select;
    private int id;
    private String name;
    private String icon;
    private int min;
    private int max;
    private String rebate;
    private String cycle;
    private String price;
    private String v_click;
    private String url;
    private String created_at;
    private String updated_at;
    private Object deleted_at;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
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

    public Object getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(Object deleted_at) {
        this.deleted_at = deleted_at;
    }

    public String getIconsrc() {
        return iconsrc;
    }

    public void setIconsrc(String iconsrc) {
        this.iconsrc = iconsrc;
    }
}

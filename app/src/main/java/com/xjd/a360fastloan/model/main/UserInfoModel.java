package com.xjd.a360fastloan.model.main;

import java.util.List;

public class UserInfoModel {

    /**
     * id : 2
     * mobile : 15170193726
     * balance : 0.00
     * remember_token : null
     * created_at : 2019-07-14 02:05:10
     * updated_at : 2019-07-14 02:05:10
     * deleted_at : null
     * product : {"id":1,"name":"360极速借","icon":"/storage/files/PtnGH2bPS3Y4r3uPcccwRXBPNDByFTkKnM9tU8bl.png","min":1000,"max":15000,"rebate":"0.60","cycle":"90天","price":"198.00","v_click":"500万","url":null,"created_at":"2019-06-20 13:19:26","updated_at":"2019-06-20 13:19:26","deleted_at":null,"iconsrc":"https://e160c1b6.ngrok.io//storage/files/PtnGH2bPS3Y4r3uPcccwRXBPNDByFTkKnM9tU8bl.png"}
     * info : null  判断是否填写资料
     * card : []
     */

    private int id;
    private String mobile;
    private String balance;
    private Object remember_token;
    private String created_at;
    private String updated_at;
    private Object deleted_at;
    private ProductBean product;
    private Object info;
    private List<?> card;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public Object getRemember_token() {
        return remember_token;
    }

    public void setRemember_token(Object remember_token) {
        this.remember_token = remember_token;
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

    public ProductBean getProduct() {
        return product;
    }

    public void setProduct(ProductBean product) {
        this.product = product;
    }

    public Object getInfo() {
        return info;
    }

    public void setInfo(Object info) {
        this.info = info;
    }

    public List<?> getCard() {
        return card;
    }

    public void setCard(List<?> card) {
        this.card = card;
    }

    public static class ProductBean {
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
         * iconsrc : https://e160c1b6.ngrok.io//storage/files/PtnGH2bPS3Y4r3uPcccwRXBPNDByFTkKnM9tU8bl.png
         */

        private int id;
        private String name;
        private String icon;
        private int min;
        private int max;
        private String rebate;
        private String cycle;
        private String price;
        private String v_click;
        private Object url;
        private String created_at;
        private String updated_at;
        private Object deleted_at;
        private String iconsrc;

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

        public Object getUrl() {
            return url;
        }

        public void setUrl(Object url) {
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
}

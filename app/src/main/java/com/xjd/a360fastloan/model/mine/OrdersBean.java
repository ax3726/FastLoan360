package com.xjd.a360fastloan.model.mine;

/**
 * Created by shiqingqing on 2019/7/16.
 */

public class OrdersBean {

    /**
     * id : 10
     * user_id : 2
     * product_id : 1
     * amount : 198
     * paylog : null
     * created_at : 2019-07-16 21:13:51
     * updated_at : 2019-07-16 21:13:51
     * product : {"id":1,"name":"360极速借","icon":"files/bdacS0dBZDlkp5r0mki8BLBi004B4b4itKFUa3Du.png","min":1000,"max":15000,"rebate":"0.60","cycle":"90天","price":"198.00","v_click":"500万","url":null,"created_at":"2019-06-20 13:19:26","updated_at":"2019-07-15 20:37:27","deleted_at":null,"iconsrc":"http://cash.free.idcfengye.com/storage/files/bdacS0dBZDlkp5r0mki8BLBi004B4b4itKFUa3Du.png"}
     */

    private int id;
    private int user_id;
    private int product_id;
    private String amount;
    private Object paylog;
    private String created_at;
    private String updated_at;
    private ProductBean product;

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

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Object getPaylog() {
        return paylog;
    }

    public void setPaylog(Object paylog) {
        this.paylog = paylog;
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

    public ProductBean getProduct() {
        return product;
    }

    public void setProduct(ProductBean product) {
        this.product = product;
    }

    public static class ProductBean {
        /**
         * id : 1
         * name : 360极速借
         * icon : files/bdacS0dBZDlkp5r0mki8BLBi004B4b4itKFUa3Du.png
         * min : 1000
         * max : 15000
         * rebate : 0.60
         * cycle : 90天
         * price : 198.00
         * v_click : 500万
         * url : null
         * created_at : 2019-06-20 13:19:26
         * updated_at : 2019-07-15 20:37:27
         * deleted_at : null
         * iconsrc : http://cash.free.idcfengye.com/storage/files/bdacS0dBZDlkp5r0mki8BLBi004B4b4itKFUa3Du.png
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

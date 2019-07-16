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
     * product : {"id":1,"name":"360极速借","icon":"files/bdacS0dBZDlkp5r0mki8BLBi004B4b4itKFUa3Du.png","min":1000,"max":15000,"rebate":"0.60","cycle":"90天","price":"198.00","v_click":"500万","url":null,"created_at":"2019-06-20 13:19:26","updated_at":"2019-07-15 20:37:27","deleted_at":null,"iconsrc":"http://cash.free.idcfengye.com/storage/files/bdacS0dBZDlkp5r0mki8BLBi004B4b4itKFUa3Du.png"}
     * info : {"id":1,"user_id":2,"name":"黎明","sex":"男","id_card":"360734199602211310","address":"这个是hi地址","education":"本科","marriage":"未婚","created_at":"2019-07-15 22:39:17","updated_at":"2019-07-15 22:39:17"}
     * card : [{"id":1,"user_id":2,"number":"6222620290001716639","mobile":"15170183726","logo":"https://apimg.alipay.com/combo.png?d=cashier&t=COMM","name":"交通银行","type":"储蓄卡","code":null,"date":null,"created_at":"2019-07-15 22:39:17","updated_at":"2019-07-15 22:39:17"},{"id":2,"user_id":2,"number":"6222620290001716637","mobile":"15558112727","logo":"https://apimg.alipay.com/combo.png?d=cashier&t=COMM","name":"交通银行","type":"储蓄卡","code":null,"date":null,"created_at":"2019-07-16 05:29:56","updated_at":"2019-07-16 05:29:56"},{"id":3,"user_id":2,"number":"6222600260001072443","mobile":"15170193726","logo":"https://apimg.alipay.com/combo.png?d=cashier&t=COMM","name":"交通银行","type":"储蓄卡","code":null,"date":null,"created_at":"2019-07-16 05:50:28","updated_at":"2019-07-16 05:50:28"},{"id":5,"user_id":2,"number":"6222600260001072444","mobile":"15170193726","logo":"https://apimg.alipay.com/combo.png?d=cashier&t=COMM","name":"交通银行","type":"储蓄卡","code":null,"date":null,"created_at":"2019-07-16 22:33:45","updated_at":"2019-07-16 22:33:45"}]
     * job : {"id":1,"user_id":2,"type":"飒飒大大","name":"啊撒打算","address":"爱的","phone":"0791-28617697","income":"200","intime":"2019-06-16 00:00:00","created_at":"2019-07-16 23:11:15","updated_at":"2019-07-16 23:11:15"}
     * relation : [{"id":1,"user_id":2,"name":"黎啊啊","mobile":"15170193725","relation":"配偶","created_at":"2019-07-16 22:36:35","updated_at":"2019-07-16 22:36:35"}]
     */

    private int id;
    private String mobile;
    private String balance;
    private Object remember_token;
    private String created_at;
    private String updated_at;
    private Object deleted_at;
    private ProductBean product;
    private InfoBean info;
    private JobBean job;
    private List<CardBean> card;
    private List<RelationBean> relation;

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

    public InfoBean getInfo() {
        return info;
    }

    public void setInfo(InfoBean info) {
        this.info = info;
    }

    public JobBean getJob() {
        return job;
    }

    public void setJob(JobBean job) {
        this.job = job;
    }

    public List<CardBean> getCard() {
        return card;
    }

    public void setCard(List<CardBean> card) {
        this.card = card;
    }

    public List<RelationBean> getRelation() {
        return relation;
    }

    public void setRelation(List<RelationBean> relation) {
        this.relation = relation;
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

    public static class InfoBean {
        /**
         * id : 1
         * user_id : 2
         * name : 黎明
         * sex : 男
         * id_card : 360734199602211310
         * address : 这个是hi地址
         * education : 本科
         * marriage : 未婚
         * created_at : 2019-07-15 22:39:17
         * updated_at : 2019-07-15 22:39:17
         */

        private int id;
        private int user_id;
        private String name;
        private String sex;
        private String id_card;
        private String address;
        private String education;
        private String marriage;
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

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getId_card() {
            return id_card;
        }

        public void setId_card(String id_card) {
            this.id_card = id_card;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getEducation() {
            return education;
        }

        public void setEducation(String education) {
            this.education = education;
        }

        public String getMarriage() {
            return marriage;
        }

        public void setMarriage(String marriage) {
            this.marriage = marriage;
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

    public static class JobBean {
        /**
         * id : 1
         * user_id : 2
         * type : 飒飒大大
         * name : 啊撒打算
         * address : 爱的
         * phone : 0791-28617697
         * income : 200
         * intime : 2019-06-16 00:00:00
         * created_at : 2019-07-16 23:11:15
         * updated_at : 2019-07-16 23:11:15
         */

        private int id;
        private int user_id;
        private String type;
        private String name;
        private String address;
        private String phone;
        private String income;
        private String intime;
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

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getIncome() {
            return income;
        }

        public void setIncome(String income) {
            this.income = income;
        }

        public String getIntime() {
            return intime;
        }

        public void setIntime(String intime) {
            this.intime = intime;
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

    public static class CardBean {
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
        private boolean is_select;
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

    public static class RelationBean {
        /**
         * id : 1
         * user_id : 2
         * name : 黎啊啊
         * mobile : 15170193725
         * relation : 配偶
         * created_at : 2019-07-16 22:36:35
         * updated_at : 2019-07-16 22:36:35
         */

        private int id;
        private int user_id;
        private String name;
        private String mobile;
        private String relation;
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

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getRelation() {
            return relation;
        }

        public void setRelation(String relation) {
            this.relation = relation;
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
}

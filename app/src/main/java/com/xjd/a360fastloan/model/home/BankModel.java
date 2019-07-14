package com.xjd.a360fastloan.model.home;

public class BankModel {

    /**
     * validated : true
     * bank : CMB
     * bankName : 招商银行
     * bankImg : https://apimg.alipay.com/combo.png?d=cashier&t=CMB
     * cardType : CC
     * cardTypeName : 信用卡
     */

    private boolean validated;
    private String bank;
    private String bankName;
    private String bankImg;
    private String cardType;
    private String cardTypeName;

    public boolean isValidated() {
        return validated;
    }

    public void setValidated(boolean validated) {
        this.validated = validated;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankImg() {
        return bankImg;
    }

    public void setBankImg(String bankImg) {
        this.bankImg = bankImg;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardTypeName() {
        return cardTypeName;
    }

    public void setCardTypeName(String cardTypeName) {
        this.cardTypeName = cardTypeName;
    }
}

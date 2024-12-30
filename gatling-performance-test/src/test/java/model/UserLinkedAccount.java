package model;

public class UserLinkedAccount {
    private String userPhone;
    private String partnerAccountId;
    private String partnerCode;
    private String rsaToken;
    private String getawayAccessToken;

    public UserLinkedAccount() {
    }

    public UserLinkedAccount(String partnerAccountId, String getawayAccessToken, String partnerCode) {
        this.partnerAccountId = partnerAccountId;
        this.getawayAccessToken = getawayAccessToken;
        this.partnerCode = partnerCode;

    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getPartnerAccountId() {
        return partnerAccountId;
    }

    public void setPartnerAccountId(String partnerAccountId) {
        this.partnerAccountId = partnerAccountId;
    }

    public String getPartnerCode() {
        return partnerCode;
    }

    public void setPartnerCode(String partnerCode) {
        this.partnerCode = partnerCode;
    }

    public String getRsaToken() {
        return rsaToken;
    }

    public void setRsaToken(String rsaToken) {
        this.rsaToken = rsaToken;
    }

    public String getGetawayAccessToken() {
        return getawayAccessToken;
    }

    public void setGetawayAccessToken(String getawayAccessToken) {
        this.getawayAccessToken = getawayAccessToken;
    }

    @Override
    public String toString() {
        return userPhone+","+partnerAccountId+","+getawayAccessToken+","+rsaToken+","+partnerCode;
    }
}

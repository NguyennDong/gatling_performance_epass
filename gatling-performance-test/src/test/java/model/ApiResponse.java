package model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApiResponse {
    private int status;
    private String message;
    private Data data;
    private String signature;

    // Getters and Setters
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    // Inner class for "data" field
    public static class Data {
        @JsonProperty("partnerCode")
        private String partnerCode;

        @JsonProperty("partnerRefId")
        private String partnerRefId;

        @JsonProperty("momoTransId")
        private String momoTransId;

        @JsonProperty("userId")
        private String userId;

        @JsonProperty("profileId")
        private String profileId;

        // Getters and Setters
        public String getPartnerCode() {
            return partnerCode;
        }

        public void setPartnerCode(String partnerCode) {
            this.partnerCode = partnerCode;
        }

        public String getPartnerRefId() {
            return partnerRefId;
        }

        public void setPartnerRefId(String partnerRefId) {
            this.partnerRefId = partnerRefId;
        }

        public String getMomoTransId() {
            return momoTransId;
        }

        public void setMomoTransId(String momoTransId) {
            this.momoTransId = momoTransId;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getProfileId() {
            return profileId;
        }

        public void setProfileId(String profileId) {
            this.profileId = profileId;
        }
    }
}

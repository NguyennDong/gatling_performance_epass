package utils;

import java.util.HashMap;
import java.util.Map;

public class MerchantKeyMapper {
    private static final Map<String, MerchantData> merchantDataMap = new HashMap<>();
    private static final MerchantData merchant1 = MerchantData
            .of("MOMOV3FN20220908",
                    "2qJLkxv8ysucMGBV",
                    "XvVpsS2We3vAqctHFuqCnU1XXOF1LT9r",
                    "");

    private static final MerchantData merchant2 = MerchantData.of(
            "MOMO37I120230405",
            "4PVpHXm2pZbOEO9X",
            "QNIr7GjiLwFq4m3L8nNCH4Vc1WTRKthf",
            "MIICIjANBgkqhkiG9w0BAQEFAAOCAg8AMIICCgKCAgEAjDxLY7OyAXQoG8eK2gBcH4uatZjFaIvhUkMfxe+E/CZ2xlBRb+KA78HDl46+zAEF/6I8AzhsqPCBwpioo4f9bTK3O0EseslxufBq+/GRSYmhJxSteb1vOSae3+ct1L0L8zKDUK/o26/7d4eEElCZdJpkbXqjCaWJB6tdJHhNF4YMEQ3eq8VtLR0Ooe2Mk1QfPCMtPzdeRtWitpTPmWVjuVyx9AaYZPuU/wpmDcvqoG+P6PfsicpkFAzHQmcQXs7492dngUeIwY3iIN3siQn2huyFfiFTYzNlFGbsH+rpRzq5ANSW9PkM8C0w2Oq8vfFPeGATJ5jHUIYWjRcJb2UDGeV2VHfymAYXa5s/yV16kiTTsHSwCuq7tkVTGpB88PPUgLdaBKjoBAgg9L7DKjeGI15LOE2b9FafU9AUPTf/lnyApaBxzlh5PbAjcpa8bvxdpAONQlELZuRb5KriRN3z4YMUXdDP+rXEoLnB2il+eY36Bwn24znSXYRKEMGUNdjS9GKa0JBiUoVPKJ8RGtyoZPpxLGd++bCljSivCyypGTsLz7m2DJGoYDVVB2HaDw0kZsW1/sGn6SFQwkLq85/zt6kP2I/W2e/naFjh1ZOWaO0Pb/mIaE3aaAiBWBKyD+R/63toLXB4cXw6oerO22APeWAVdLSY0PW3SRz3K3e65gECAwEAAQ=="
    );

    private static final MerchantData merchant3 = MerchantData.of(
            "ADYEN102017",
            "Fn3QsyyNIQgq1DJbNf",
            "HVwURTeHFdOCsEZSmoBavUxYFviRJTEJ",
            "MIICIjANBgkqhkiG9w0BAQEFAAOCAg8AMIICCgKCAgEAiNsnWcRrsJU3kbQA1uFXi3DXVQJBRvW5TUKK9juJ/wdsLlFDkhBNEUfC3H2u9qI8Mt8ydf8DLOYhYSNepGSpNvz7wnZOaGLi6PzMQRFCmUhjDsSRJPJGBHqCqQOSN8uFRr7C0k9hHnwOMvdyAO6haEXuZrCw3COWqWJNY9HAOytvpOX8cAOD1yZQ9awJ5sshuuoCd4MoBHNIkHu+x5+SAf79mjKos3wbQo3WEUgOvQJPxZs2ahILH/SawcyP9k3iw6kn3suC0yay8D8GdVt8+D+iO7pXv/FWUQ/u4eJXqeAYjMXFr64OzU3TlmCjPc2mYeKyXZLylWH/Y82Lcm7DXcETF/KeULmv2KwO5A9WAOieP5qLLDJSdRmMrVy5rmlm5afrPAlNs1kFNIrQe55rDOqOvq/l71KMdhzQgrQ9Odyjue2yWOyO/3yXxy7ceXRJfQPw6uYW6vtLD32ugAvS3yLaqeDlyJLUMmjPmTfdFJDSOlYTulxCG45rlY+WecAZThvMV1T+gRYfkLDHM2kjGH7/qLo4kF5mj926+IYLt6uszhrwckdgdKH6SAYR04hSsH+PVG6tkhJW3kElegQuk4J34GQgMYTOOqqaeitgN9chL/EAQhUJPYIMC6tRUBqG/imqM4Y+CK/haDaaFEhw4XxiSogl4s5GA+VN/4Fhkr0CAwEAAQ=="
   );

    static {
        merchantDataMap.put(merchant1.getPartnerCode(), merchant1);
        merchantDataMap.put(merchant2.getPartnerCode(), merchant2);
        merchantDataMap.put(merchant3.getPartnerCode(), merchant3);
    }

    public static MerchantData getMerchantMetaData(String partnerCode) {
        return merchantDataMap.get(partnerCode);
    }

    public static  Map<String, MerchantData> getAllMerchant() {
        return merchantDataMap;
    }

    public static class MerchantData {
        private String partnerCode;
        private String accessKey;
        private String secretKey;
        private String publicKey;

        public MerchantData(String partnerCode, String accessKey, String secretKey, String publicKey) {
            this.partnerCode = partnerCode;
            this.accessKey = accessKey;
            this.secretKey = secretKey;
            this.publicKey = publicKey;
        }

        static MerchantData of(String partnerCode, String accessKey, String secretKey, String publicKey) {
            return new MerchantData(partnerCode, accessKey, secretKey, publicKey);
        }

        public String getPartnerCode() {
            return partnerCode;
        }

        public void setPartnerCode(String partnerCode) {
            this.partnerCode = partnerCode;
        }

        public String getAccessKey() {
            return accessKey;
        }

        public void setAccessKey(String accessKey) {
            this.accessKey = accessKey;
        }

        public String getSecretKey() {
            return secretKey;
        }

        public void setSecretKey(String secretKey) {
            this.secretKey = secretKey;
        }

        public String getPublicKey() {
            return publicKey;
        }

        public void setPublicKey(String publicKey) {
            this.publicKey = publicKey;
        }
    }
}

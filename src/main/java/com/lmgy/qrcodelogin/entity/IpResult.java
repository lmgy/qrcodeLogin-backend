package com.lmgy.qrcodelogin.entity;

import lombok.Data;

/**
 * @author lmgy
 * @date 2019/11/22
 */
@Data
public class IpResult {

    /**
     * address : CN|重庆|重庆|None|UNICOM|0|0
     * content : {"address":"重庆市","address_detail":{"city":"重庆市","city_code":132,"district":"","province":"重庆市","street":"","street_number":""},"point":{"x":"106.53063501","y":"29.54460611"}}
     * status : 0
     */

    private String address;
    private ContentBean content;
    private int status;

    @Data
    public static class ContentBean {
        /**
         * address : 重庆市
         * address_detail : {"city":"重庆市","city_code":132,"district":"","province":"重庆市","street":"","street_number":""}
         * point : {"x":"106.53063501","y":"29.54460611"}
         */

        private String address;
        private AddressDetailBean addressDetail;
        private PointBean point;

        @Data
        public static class AddressDetailBean {
            /**
             * city : 重庆市
             * city_code : 132
             * district :
             * province : 重庆市
             * street :
             * street_number :
             */

            private String city;
            private int cityCode;
            private String district;
            private String province;
            private String street;
            private String streetNumber;

        }

        @Data
        public static class PointBean {
            /**
             * x : 106.53063501
             * y : 29.54460611
             */

            private String x;
            private String y;

        }
    }
}

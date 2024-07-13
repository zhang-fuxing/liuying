package com.z.liuying;

/**
 * 短信发送后的返回结构
 *
 * @author 张福兴
 * @version 1.0
 * @date 2024/7/13
 * @email zhangfuxing1010@163.com
 */
public class SmsResult {
    private String code;
    private String msg;
    private String total_fee;
    private String uid;
    private Data data;

    public static class Data {
        private String fee;
        private String mobile;
        private String sid;

        public String getFee() {
            return fee;
        }

        public void setFee(String fee) {
            this.fee = fee;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getSid() {
            return sid;
        }

        public void setSid(String sid) {
            this.sid = sid;
        }

        @Override
        public String toString() {
            return "Data{" +
                   "fee='" + fee + '\'' +
                   ", mobile='" + mobile + '\'' +
                   ", sid='" + sid + '\'' +
                   '}';
        }
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(String total_fee) {
        this.total_fee = total_fee;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "VariableSmsResult{" +
               "code='" + code + '\'' +
               ", msg='" + msg + '\'' +
               ", total_fee='" + total_fee + '\'' +
               ", uid='" + uid + '\'' +
               ", data=" + data +
               '}';
    }
}

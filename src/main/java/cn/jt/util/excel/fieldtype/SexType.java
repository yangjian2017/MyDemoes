package cn.jt.util.excel.fieldtype;

public class SexType {
    /**
     * 获取对象值（导入）
     */
    public static Object getValue(String val) {
        for (SexEnum sexEnum : SexEnum.values()) {
            if (sexEnum.getValue().equals(val)) {
                return sexEnum.getKey();
            }
        }
        return val;
    }

    /**
     * 获取对象值（导出）
     */
    public static String setValue(String key) {
        for (SexEnum sexEnum : SexEnum.values()) {
            if (sexEnum.getKey().equals(key)) {
                return sexEnum.getKey();
            }
        }
        return key;
    }

    private enum SexEnum{

        man("0", "男"),
        women("1","女");

        private String key;
        private String value;

        SexEnum(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public static String getValue(String key) {
            for (SexEnum sexEnum : SexEnum.values()) {
                if (sexEnum.key.equals(key)) {
                    return sexEnum.value;
                }
            }
            return "";
        }
    }
}

package com.pxa.sample.client.kit;

/**
 * @author <a href="mailto:xiaoan.pan@qq.com">潘小安</a>
 * @since 2023-04-19 23:52
 */
public class StringKit {
    public static final Boolean isEmpty(Object value) {
        if (value == null || "".equals(value.toString())) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public static final Boolean isNotEmpty(Object value) {
        if (value == null || "".equals(value.toString())) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    /**
     * 格式化字符串中的参数
     */
    public static final String format(String value, String... args) {
        for (int i = 0; i < args.length; i++) {
            value = value.replace("{" + i + "}", args[i]);
        }
        return value;
    }
}

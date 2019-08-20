package devops.config;

import me.alb_i986.selenium.tinafw.config.Config;
import me.alb_i986.selenium.tinafw.config.PropertiesUtils;

public class MyConfig extends Config {

    public static final String NAMESPACE = "my.namespace";
    private static final String PREFIX = NAMESPACE + ".";

    // property names
    private static final String USERNAME = PREFIX + "username";
    private static final String PASSWORD = PREFIX + "password";
    public static final String MULTI_VALUE_PROP = PREFIX + "a_multi_value_prop";

    public static String getUsername() {
        return getOptionalProperty(USERNAME);
    }

    public static String getPassword() {
        return getOptionalProperty(PASSWORD);
    }

    public static String[] getMultiValueProp() {
        String value = getOptionalProperty(MULTI_VALUE_PROP);
        return (value == null) ? null : PropertiesUtils.split(value);
    }

}

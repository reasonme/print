package cn.fintecher.print.config;

/**
 * Application constants.
 */
public final class Constants {

    //Regex for acceptable logins
    public static final String LOGIN_REGEX = "^[_'.@A-Za-z0-9-]*$";
    // Spring profiles for development, test and production, see http://jhipster.github.io/profiles/
    public static final String SPRING_PROFILE_DEVELOPMENT = "dev";
    public static final String SPRING_PROFILE_TEST = "test";
    public static final String SPRING_PROFILE_PRODUCTION = "prod";
    // Spring profile used when deploying with Spring Cloud (used when deploying to CloudFoundry)
    public static final String SPRING_PROFILE_CLOUD = "cloud";
    // Spring profile used when deploying to Heroku
    public static final String SPRING_PROFILE_HEROKU = "heroku";
    // Spring profile used to disable swagger
    public static final String SPRING_PROFILE_SWAGGER = "swagger";
    // Spring profile used to disable running liquibase
    public static final String SPRING_PROFILE_NO_LIQUIBASE = "no-liquibase";

    public static final String SYSTEM_ACCOUNT = "system";

    public static final String ERROR_MESSAGE = "系统异常";
    public static final String SESSION_USER = "USER";
    public static final String ADMIN_ROLE_ID = "0a035e58-21dd-43fd-b1b6-5a59fc06428d";
    public static final String RET_PASSWORD = "888888";
    /*
    短信参数配置
     */
    public static final String CUST_NAME = "cust_name";
    public static final String TOTALMONEY = "total_money";
    public static final String MONEY = "money";
    public static final String PENALTY = "penalty";
    public static final String HOUR = "hour";
    public static final String DAY = "day";
    public static final String SERVICE_PHONE = "service_phone";

    public static final String SYSTEM_CREATOR = "system";

    /**
     * 正则匹配
     */
    //姓名
    public static final String NAME_REGEX = "^([\\u4e00-\\u9fa5]+|([a-zA-Z]+\\s?)+)$";
    //手机
    public static final String MOBILE_REGEX = "^1(3|4|5|7|8)\\d{9}$";
    //账户
    public static final String USER_NAME_REGEX = "[A-Za-z0-9_\\-]+";
    //邮箱
    public static final String EMAIL_REGEX = "\\w[-\\w.+]*@([A-Za-z0-9][-A-Za-z0-9]+\\.)+[A-Za-z]{2,14}";
    //编号
    public static final String CODE_REGEX = "[A-Za-z0-9]+";
    //电话（座机）
    public static final String PHONE_REGEX = "[0-9-()（）]{7,18}";


    private Constants() {
    }
}

package com.mars.common.constant;

/**
 * 框架常量
 */
public class MarsConstant {

    /**
     * 所有数据源对象
     */
    public static final String DATA_SOURCE_MAP = "druidDataSourceMap";
    /**
     * 配置文件中数据源节点的属性名
     */
    public static final String DATA_SOURCE = "dataSource";
    /**
     * 本地配置文件
     */
    public static final String CONFIG_PATH = "/mars-{suffix}.yml";
    /**
     * 本地配置文件
     */
    public static final String CONFIG_PATH_DEFAULT = "/mars.yml";
    /**
     * 所有的easyAfter类信息
     */
    public static final String MARS_AFTERS = "marsAfters";
    /**
     * 记录是否已经调用完createBean方法了
     */
    public static final String HAS_START="hasStart";
    /**
     * 记录netty是否已经启动了
     */
    public static final String HAS_NETTY_START="hasNettyStart";
    /**
     * 记录是否已经启动过单测了
     */
    public static final String HAS_TEST="hasTest";
    /**
     * 所有的MarsApi类信息
     */
    public static final String CONTROLLERS = "contorllers";
    /**
     * 所有的marsBeans类信息
     */
    public static final String MARS_BEANS = "marsBeans";
    /**
     * 所有的interceptors类信息
     */
    public static final String INTERCEPTORS = "interceptors";
    /**
     * 所有的interceptors对象
     */
    public static final String INTERCEPTOR_OBJECTS = "interceptorsObjects";
    /**
     * 所有的easyDao类信息
     */
    public static final String MARS_DAOS = "marsDaos";

    /**
     * 所有的MarsApi对象
     */
    public static final String CONTROLLER_OBJECTS = "controlObjects";

    /**
     * 所有的bean对象，包括 marsBean和marsDao
     */
    public static final String MARS_BEAN_OBJECTS = "marsBeanObjects";

    /**
     * 所有加了MarsTimer注解的方法
     */
    public static final String MARS_TIMER_OBJECTS = "marsTimerObjects";

    /**
     * 读取远程配置的路径
     */
    public static final String READ_REMOTE_CONFIG = "${0}/getConfig";

    /**
     * 方法返回值为void的标记
     */
    public static final String VOID = "void405cb55d6781877e9e930aa8e046098b";

    /**
     * 扫描到的所有类
     */
    public static final String SCAN_ALL_CLASS = "scanAllClass";

    /**
     * 请求的文件参数的key
     */
    public static final String REQUEST_FILE = "files";

    /**
     * 默认数据源储存在内存中的key
     */
    public static final String DEFAULT_DATASOURCE_NAME = "defaultDataSource";

    /**
     * 所有数据源储存在内存中的key
     */
    public static final String DATASOURCE_NAMES = "dataSourceNames";

    /**
     * config存放在内存中的key
     */
    public static final String CONFIG_CACHE_KEY = "config";
}

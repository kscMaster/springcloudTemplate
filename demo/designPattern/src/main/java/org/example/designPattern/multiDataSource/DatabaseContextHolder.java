package org.example.designPattern.multiDataSource;

/**
 * @Author:
 * @CreateTime: 2021/4/13 09:27
 * @Description:线程安全类，存放数据源
 */
public class DatabaseContextHolder {
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    public static final String FIRST_DS = "datasource1";
    public static final String SECOND_DS = "datasource2";

    /**
     * 放入
     * @param type
     */
    public static void setDataBase(String type){
        contextHolder.set(type);
    }

    /**
     * 获取
     */
    public static String getDataBase(){
        return contextHolder.get();
    }

    /**
     * 清空
     */
    public static void chearDataSource(){
        contextHolder.remove();
    }
}
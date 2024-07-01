//package org.example.utils;
//
//import cn.hutool.extra.spring.SpringUtil;
//import com.nancal.common.interceptor.LanauageInterceptor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.context.MessageSource;
//import org.springframework.context.NoSuchMessageException;
//
//@Slf4j
//public class MessageUtils
//{
//    /**
//     * 根据消息键和参数获取消息
//     *
//     * @param code 消息键
//     * @param args 参数
//     * @return 获取国际化翻译值
//     */
//
//    public static String getMessage(String code, Object... args)
//    {
//        MessageSource messageSource = SpringUtil.getBean(MessageSource.class);
//        try {
//            return messageSource.getMessage(code, args, LanauageInterceptor.LangThreadLocal.get());
//        } catch (NoSuchMessageException e) {
//            log.error("获取提示语失败{}"+e.getMessage());
//            e.printStackTrace();
//        }
//        return null;
//    }
//}
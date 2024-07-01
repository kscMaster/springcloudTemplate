package org.example.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * 多语言拦截
 */

@Component
@Slf4j
public class LanauageInterceptor implements HandlerInterceptor {

    private static final String CHINA="cn";
    private static final String ENGLISH="en";

    public static final ThreadLocal<Locale> LangThreadLocal = new ThreadLocal<Locale>(){};

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        putLocal(request.getHeader("lang"));
        return true;
    }

    private void putLocal(String lang){
        if (StringUtils.isEmpty(lang)){
            lang=CHINA;
        }
        switch (lang){
            case ENGLISH:
                LangThreadLocal.set(Locale.US);
                break;
            default:
                LangThreadLocal.set(Locale.CHINA);
        }
    }
}
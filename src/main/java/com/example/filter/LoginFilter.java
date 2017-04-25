package com.example.filter;

import com.example.model.User;
import com.example.utils.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lbb on 2017/4/23.
 * <p>
 * 登录过滤器用于拦截未登录的用户
 */
@Component
@WebFilter(urlPatterns = "/*")
public class LoginFilter implements Filter {

    Logger logger = LoggerFactory.getLogger(this.getClass());


    /**
     * 没有登录也放行的资源结尾
     */
    private static final List<String> STATIC_RESOURCES = new ArrayList<String>() {{
        this.add(".js");
        this.add(".jsp");
        this.add(".css");
        this.add(".jpg");
        this.add(".png");
        this.add(".gif");
        this.add(".jpg");
        this.add(".ico");
        this.add(".swf");
        this.add(".txt");
        this.add(".wav");
        this.add(".mp3");
        this.add(".xls");
        this.add(".tar");
        this.add(".ttf");
        this.add(".eot");
        this.add(".svg");
        this.add(".woff");
        this.add(".woff2");
        this.add(".pdf");
        this.add(".jpeg");
        this.add(".doc");
        this.add(".rar");
        this.add(".fon");
        this.add(".svg");
        this.add("/login");
        this.add("/login/");
        this.add("/spider/");
        this.add("/checkLogin");
    }};


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("===================================");
        logger.info("LoginFilter init!");
        logger.info("===================================");
    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String visitUrl = request.getRequestURI();

        /**
         * 检测是否是静态资源或者是访问login登录界面
         */
        boolean isOver = false;
        for (String suffix : STATIC_RESOURCES) {
            if (visitUrl.endsWith(suffix)) {
                isOver = true;
                filterChain.doFilter(servletRequest, servletResponse);
                break;
            }
        }
        if (isOver) return;

        logger.info("visit url: {}", visitUrl);

        String requestType = request.getHeader("X-Requested-With");
        if ("X-Requested-With".equals(requestType)) {
            //ajax请求
            if (User.getLoginedUser(request) == null) {
                response.setStatus(Constant.NOT_LOGINED_CODE);
                return;
            }
        } else {
            //普通请求
            if (User.getLoginedUser(request) == null) {
                response.sendRedirect("/spider/login");
                return;
            }
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }


    @Override
    public void destroy() {
        logger.info("===================================");
        logger.info("LoginFilter destory!");
        logger.info("===================================");
    }
}

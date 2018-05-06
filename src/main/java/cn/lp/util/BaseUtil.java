package cn.lp.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class BaseUtil {
/*
 * 作为工具类
 * 1.获取session
 * 2.获取request
 * 
 * 
 * 
 */
	public BaseUtil() {
		// TODO Auto-generated constructor stub
	}
	
	public static HttpSession getSession() {
	        HttpSession session = null;
	        try {
	            session = getRequest().getSession();
	        } catch (Exception e) {
	        }
	        return session;
	    }

	    public static HttpServletRequest getRequest() {
	        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
	        return attrs.getRequest();
	    }


}

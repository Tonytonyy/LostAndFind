package com.cn.hnust.Interceptor;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.cn.hnust.pojo.RUser;

import okhttp3.internal.framed.ErrorCode;
import okhttp3.internal.framed.FrameReader.Handler;
import okhttp3.internal.framed.Header;
import okhttp3.internal.framed.HeadersMode;
import okhttp3.internal.framed.Settings;
import okio.BufferedSource;
import okio.ByteString;

public class LoginInterceptor implements HandlerInterceptor {



	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("--------------------------this is afterCompletion-------------------");

	   // arg1.sendRedirect("/index.html");
		

	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("--------------------------this is postHandle-------------------");

	}

	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object obj) throws Exception {
		// TODO Auto-generated method stub

		String username=arg0.getParameter("username");
		System.out.println(username+obj+"--------------------------this is preHandle-------------------"+arg0.getContextPath()+"-----"+arg0.getRealPath("./"));
		HttpSession hs=arg0.getSession();
		RUser rs=(RUser) hs.getAttribute("user");
	    arg1.sendRedirect("/HNUST/index.html");
		return false;
	}

}

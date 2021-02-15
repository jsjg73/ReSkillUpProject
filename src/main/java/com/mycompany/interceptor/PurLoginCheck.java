package com.mycompany.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.mycompany.service.PurposalService;

public class PurLoginCheck extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		String login = (String) session.getAttribute("login");
		
		String targetURL = request.getRequestURL().toString().split("/")[4];
		
		if(login == null) {
			//권한 없음 알림
			response.sendRedirect("/sessionNull");
			return false;
		}
		//직원 로그인 : 모든 경로 접근 가능
		if(login.equals("admin")) {
			request.setAttribute("writer", login);
			return true;
		}
		
		//coc 로그인 :read, list, list_search
		if(login.equals("coc")) {			
			if(targetURL.equals("read") ||
				targetURL.equals("list") ||
				targetURL.equals("list_search") ) {
				request.setAttribute("coc_name", session.getAttribute("coc_name"));
				return true;
			}
		}
		
		//권한 없음 알림
		response.sendRedirect("/sessionNull");
		return false;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		super.afterCompletion(request, response, handler, ex);
	}
}

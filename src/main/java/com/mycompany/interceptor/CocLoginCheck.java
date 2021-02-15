package com.mycompany.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class CocLoginCheck extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		String login = (String) session.getAttribute("login");
		
		String targetURL = request.getRequestURL().toString().split("/")[4];
		System.out.println("targetURL : " + targetURL);
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
		System.out.println("request.getAttribute(\"coc_name\") :" + session.getAttribute("coc_name"));

		//coc 로그인 :read, list, list_search
		if(login.equals("coc") && session.getAttribute("coc_name") != null) {
			if(targetURL.equals("read") ||
				targetURL.equals("list") ||
				targetURL.equals("list_search") ||
				targetURL.equals("updateform") ||
				targetURL.equals("pwd_check")) {
				System.out.println("도착 테스트~");
				request.setAttribute("coc_name", session.getAttribute("coc_name"));
				return true;
			}
		}
		
		//비로그인 : write
		if(login.equals("none")) {
			System.out.println("비로그인!");
			if(targetURL.equals("writeform") || targetURL.equals("dupli")) {
				
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
		HttpSession sess = request.getSession();
		modelAndView.addObject("writer", sess.getAttribute("login"));
		super.postHandle(request, response, handler, modelAndView);
		
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		super.afterCompletion(request, response, handler, ex);
	}

}

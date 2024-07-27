package com.fsje.dairy.common.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ApiAuthInterceptor implements HandlerInterceptor {
	/**
	 * Controller(RequestMapping 선언 Handler) 실행 직전에 동작하는 method.
     * return 값이 true일 경우 정상적으로 진행이 되고,
     *            false일 경우 실행 종료 Controller 진입 X
     * Parameter 중 Object handler는 HandlerMapping이 찾은 Controller Class 객체이다.
     * 
     * @method preHandle
     * @param request
	 * @param response
	 * @param handler
	 * @throws Exception
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		log.info("Interceptor > postHandle");
		return true;
	}
	
	/**
	 * Controller 진입 후 View가 Rendering 되기 전 수행된다. 
	 * Parameter 중 ModelAndView modelAndView를 통해 화면 단에 들어가는 Data 등의 조작이 가능하다. 
	 * 
	 * @method postHandle
	 * @param request
	 * @param response
	 * @param handler
	 * @param modelAndView
	 * @throws Exception
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		log.info("Interceptor > postHandle");
	}
	
	/**
	 * Controller 진입 후 View가 정상적으로 Rendering 된 후 수행된다.
	 * 
	 * @method afterCompletion
	 * @param request
	 * @param response
	 * @param handler
	 * @throws Exception
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		log.info("Interceptor > afterCompletion" );
	}
	
	/**
	 * Servlet 3.0부터 비동기 요청이 가능해지며 생겨난 method로,
	 * 비동기 요청 시 PostHandle와 afterCompletion method를 수행하지 않고 이 메서드를 수행한다.
	 * 
	 * @method afterConcurrentHandlingStarted
	 * @param request
	 * @param response
	 * @param handler
	 * @throws Exception
	 */
	public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		log.info("Interceptor > afterConcurrentHandlingStarted" );
	}
}
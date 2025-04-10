package com.yedam.common;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.yedam.service.EventService;
import com.yedam.service.EventServiceImpl;

// 클라이언트 - 필터 - 서브렛. boardList.do

public class FilterOne implements Filter {
	
	public FilterOne() {
		System.out.println("필터원 생성자");
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("서브렛 실행전");
		
		// 요청페이지, 클라이언트 iq 추적
		String ip = request.getRemoteAddr();
		
		HttpServletRequest req = (HttpServletRequest) request;
		String uri = req.getRequestURI();
		String context = req.getContextPath();
		String reqPage = uri.substring(context.length());
		
		Map<String, String> map = new HashMap<>();
		map.put("page", reqPage);
		map.put("host", ip);
		
		List<String> blackList = new ArrayList<>();
		blackList.add("192.168.0.38");
		// 로그 저장
		EventService svc = new EventServiceImpl();
		svc.logCreate(map);
		if (blackList.contains(ip)) {
			return;
		}

		
		chain.doFilter(request, response);
		System.out.println("서브렛 실행후");
	}

}

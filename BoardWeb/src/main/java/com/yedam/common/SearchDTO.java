package com.yedam.common;
// 계시글 검색의 파라미터 선언

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter 

public class SearchDTO {
	private int page;
	private String searchCondition;
	private String keyword;
	private int boardNo;
}

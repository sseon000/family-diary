package com.fsje.dairy.dao;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.fsje.dairy.dto.DiaryDto;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class DiaryDao {
	private final SqlSessionTemplate sqlSessionTemplate;
	
	/*
	public List<String,String> selectDairyList() {
		return sqlSessionTemplate.selectList("getDairyList");
	}
	*/
	
	public int insertDairy(DiaryDto diaryDto) {
		return sqlSessionTemplate.insert("insertDairy", diaryDto);
	}
}

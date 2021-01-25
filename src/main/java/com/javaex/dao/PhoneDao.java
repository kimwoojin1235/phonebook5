package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PhoneVo;

@Repository
//이걸 붙여야지만 자동으로 new를 붙이게 된다.
public class PhoneDao {
	@Autowired
	private SqlSession sqlSession;

	// 전체리스트 가지고 오기
	public List<PhoneVo> getpersonList() {
		List<PhoneVo> personList = sqlSession.selectList("phonebook.selectlist2");// select문이 실행이된다.
		System.out.println("list들어옴");
		return personList;
	}

	//전화번호 저장
	public void personInsert(PhoneVo phoneVo) {
		System.out.println(phoneVo.toString());
		sqlSession.insert("phonebook.insert",phoneVo);
		//phonebook안에 있는 인설트 라는 애 한데 phoneVo의 정보를 주고 쿼리를 가지고 온다.
	}
	//전화번호 삭제
	public void persondelete(int personid) {
		sqlSession.delete("phonebook.delete",personid);
	}
	//한명의 정보 가지고 오기
	public PhoneVo getPerson(int personid) {		
		PhoneVo phoneVo =sqlSession.selectOne("phonebook.selectOne",personid);
		System.out.println(phoneVo.toString());
		return phoneVo;
	}
	//수정하기
	public void personUpdate(PhoneVo phoneVo) {
		sqlSession.update("phonebook.update",phoneVo);
	}
}

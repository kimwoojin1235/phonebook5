package com.javaex.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	
	public  Map<String, Object> getPerson2(int personid) {		
		System.out.println("dao:getPerson2"+personid);
		Map<String, Object>personMap = sqlSession.selectOne("phonebook.selectOne2",personid);
		/*
		String name =(String)personMap.get("name");
		System.out.println(name);
		int id =Integer.parseInt(String valueof(personMap.get("personid"));
		System.out.println(id);
		*/
		return personMap;
	}
	
	
	
	
	
	//수정하기
	public void personUpdate(PhoneVo phoneVo) {
		sqlSession.update("phonebook.update",phoneVo);
	}
	public int personUpdate2(int personid, String name,String hp,String company) {
		System.out.println("dao:personUpdate2"+","+personid +","+name+","+hp+","+company);
		//Vo 대신 --> map사용 map으로 묶었다.
		Map<String, Object>personMap =new HashMap<String,Object>();
		personMap.put("id", personid);
		personMap.put("name", name);
		personMap.put("hp", hp);
		personMap.put("company", company);
		System.out.println(personMap.toString());
		return sqlSession.update("phonebook.update2",personMap);
	}
}

package kr.board.mapper;



import java.util.List;

import kr.board.domain.Board;
//JDBC
//1.java+SQL 혼합된 형태 (유지보수가 어려움) 
//MyBatis : SQLMapping program

public interface BoardMapper { //DB와 연동
	//결합력을 약하게 해주기 위해 interface로 결합 
	//1. 접속기능(X)
	//2. 게시판리스트 가져오는 기능
	public List<Board> boardList(); //추상메서드 -> SQL(select~) 쿼리를 별도로 모아놓는 파일 -->mapper.xml 
}
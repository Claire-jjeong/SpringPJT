package kr.board.mapper;



import java.util.List;

import org.apache.ibatis.annotations.Delete;

import kr.board.domain.Board;
//JDBC
//1.java+SQL 혼합된 형태 (유지보수가 어려움) 
//MyBatis : SQLMapping program

public interface BoardMapper { //DB와 연동
	//결합력을 약하게 해주기 위해 interface로 결합 
	//1. 접속기능(X)
	//2. 게시판리스트 가져오는 기능
	public List<Board> boardList(); //추상메서드 -> SQL(select~) 쿼리를 별도로 모아놓는 파일 -->mapper.xml 
	public void boardInsert(Board vo); //SQL(insert~)
	public Board boardContent(int idx); //SQL(select~ where idx=8)
	
	@Delete("delete from board where idx=#{idx}") //간단한 sql문의 경우 어노테이션 활용하여 작성 가능
	public void boardDelete(int idx);
	
	public void boardUpdate(Board vo);
}

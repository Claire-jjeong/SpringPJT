package kr.smhrd.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.board.domain.Board;
import kr.board.mapper.BoardMapper;

@Controller //전처리 하기 위한 표현
public class BoardController {
	
	private BoardMapper mapper;

	//1. 게시판 리스트를 보여달라는 요청을 받아서 DB에서 가져오는 일
	//HandlerMapping
	@RequestMapping("/boardList.do")
	public String boardList(HttpServletRequest request) { //위 요청이 오면 메소드를 실행해라
		//jsp로 보내기
		List<Board> list = mapper.boardList();//boardmapper의 boardList와 연결 -> mapper.xml의 sql문까지 연결
		request.setAttribute("list", list);
	
		//뷰의 논리적인 이름 --ViewResolver--> 뷰의 물리적인 이름(경로)
		return "boardList"; //보여줄 뷰의 이름 써주기
	}
	
}

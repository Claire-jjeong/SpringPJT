package kr.smhrd.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.board.domain.Board;

@Controller //전처리 하기 위한 표
public class BoardController {

	//1. 게시판 리스트를 보여달라는 요청을 받아서 DB에서 가져오는 일
	//HandlerMapping
	@RequestMapping("/boardList.do")
	public String boardList(HttpServletRequest request) { //위 요청이 오면 메소드를 실행해라
		//과일이름 3개를 ArrayList에 저장하기
		ArrayList<Board> list = new ArrayList<Board>();
		Board vo = new Board();
		vo.setIdx(1);
		vo.setTitle("스프링게시판테스트");
		vo.setWriter("관리자");
		vo.setIndate("2022-01-03");
		vo.setCount(0);
		list.add(vo);
		list.add(vo);
		list.add(vo);
		//컨트롤러와 뷰를 연동시키려면 객체 바인딩 필요
		request.setAttribute("list",list);
		//뷰의 논리적인 이름 --ViewResolver--> 뷰의 물리적인 이름(경로)
		return "boardList"; //보여줄 뷰의 이름 써주기
	}
	
}

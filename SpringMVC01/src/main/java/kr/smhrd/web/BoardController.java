package kr.smhrd.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.board.domain.Board;
import kr.board.mapper.BoardMapper;

@Controller //전처리 하기 위한 표현
public class BoardController { 
	
	@Autowired //메모리에 생성된 객체를 자동으로 연결해줌 
	private BoardMapper mapper; //new연산자 이용 시 결합도가 높아져 수정에 용이하지 못함 --> xml수정하고 Autowired를 사용 (DI(Dependency Injection) : 의존성 주입)

	//1. 게시판 리스트를 보여달라는 요청을 받아서 DB에서 가져오는 일
	//HandlerMapping
	@RequestMapping("/boardList.do")
	public String boardList(Model model) { //httpservelet -> model : spring 객체 바인딩을 하기 위한 class , 
		//jsp로 보내기 
		List<Board> list = mapper.boardList();//boardmapper의 boardList와 연결 -> mapper.xml의 sql문까지 연결
		model.addAttribute("list", list); //model로 바뀌면서 setattribute-> addattribute
	
		//뷰의 논리적인 이름 --ViewResolver--> 뷰의 물리적인 이름(경로)
		return "boardList"; //보여줄 뷰의 이름 써주기
	}
	
}

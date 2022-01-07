package kr.smhrd.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@RequestMapping(value="/boardInsert.do",method = RequestMethod.GET) //get방식으로 넘어올 때
	public String boardInsertGet() { //String -> 뷰의 논리적인 이름 때문에
		return "boardInsertForm";
	
	}
	
	//글쓰기 요청 처리
	@RequestMapping(value = "/boardInsert.do",method = RequestMethod.POST) //form의 parameter 3개가 넘어옴(title,contents,writer), post방식으로 넘어올 때
	//스프링은 파라미터 수집을 자동으로 해줌 (vo와 이름이 동일하면 수집 됨)
	public String boardInsertPost(Board vo) {
		//mapper연동 
		mapper.boardInsert(vo); //db에 저장
		return "redirect:/boardList.do"; //다시 리스트 보기 요청페이지로 이동해야 함
	}
	//글 번호 받아와서 제목 클릭시 boardContent로 이동
	@RequestMapping("/boardContent.do/{idx}") //받을 변수 지정
	public String boardContent(@PathVariable("idx") int idx,Model model) { //board모두 받을 필요 없이 1개만 받을 경우 (프레임워크 내성) 
		Board vo= mapper.boardContent(idx);
		model.addAttribute("vo",vo); //객체 바인딩 
		return "boardContent";
	}
	//삭제 기능
	@RequestMapping("/boardDelete.do")
	public String boardDelete(@RequestParam("idx")int idx) { //@RequestParam : 변수 이름이 다를 때 넘어오는 파라미터 받아오는 경우 
		mapper.boardDelete(idx);
		return "redirect:/boardList.do";
	}
	
	//수정 기능
	@RequestMapping(value="/boardUpdate.do/{idx}",method=RequestMethod.GET)
	public String boardUpdateGet(@PathVariable("idx") int idx, Model model) {
		Board vo = mapper.boardContent(idx);
		model.addAttribute("vo", vo);
		return "boardUpdateForm"; //boardUpdateForm.jsp
	}
	@RequestMapping(value="/boardUpdate.do", method=RequestMethod.POST)
	public String boardUpdatePost(Board vo) {
		mapper.boardUpdate(vo);
		return "redirect:/boardList.do";
		
	}
}

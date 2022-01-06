package kr.board.domain;


public class Board {
	//property(프로퍼티, 속성)
	private int idx; //번호 
	private String title;//제목 
	private String contents; //내용 
	private String writer; //작성자 
	private String indate; //작성일 
	private int count; //조회수
	//디폴트 생성자가 만들어져있지 않기 때문에 Parameter수집 시 Controller에서 vo호출 시 에러 발생
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getIndate() {
		return indate;
	}
	public void setIndate(String indate) {
		this.indate = indate;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

}

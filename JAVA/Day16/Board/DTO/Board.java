package Day16.Board.DTO;

import java.util.Date;

/*
 * 게시글 정보
 * - 게시글 번호
 * - 제목
 * - 작성자
 * - 내용
 * - 등록일자
 * - 수정일자
 */
public class Board {

	private int no;
	private String title;
	private String writer;
	private String content;
	private Date regDate;
	private Date upDate;
	
	// 생성자
	public Board() {
		this("제목없음", "글쓴이없음", "내용없음");
	}

	public Board(String title, String wroter, String content) {
		this.title = title;
		this.writer = wroter;
		this.content = content;
		this.regDate = new Date();
		this.upDate = new Date();
	}

	// getter, setter
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String wroter) {
		this.writer = wroter;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Date getUpDate() {
		return upDate;
	}

	public void setUpDate(Date upDate) {
		this.upDate = upDate;
	}

	// toString
	@Override
	public String toString() {
		return "Board [no=" + no + ", title=" + title + ", writer=" + writer + ", content=" + content + ", regDate="
				+ regDate + ", upDate=" + upDate + "]";
	}
	
	
	
}

package Service;

import java.util.List;

import DAO.BoardDAO;
import DTO.Board;


/**
 * 게시판 기능 - 비즈니스 로직 클래스
 */
public class BoardServicelmpl implements BoardService {
	
	private BoardDAO boardDAO = new BoardDAO();

	@Override
	public List<Board> list() {
		// 1. DAO 객체에 게시글 목록 요청
		List<Board> boardList = boardDAO.list();
		// 2. 게시글 목록 데이터 가공
		// pass
		// 3. 게시글 목록 반환
		return boardList;
	}

	@Override
	public Board select(int no) {
		// 1. 게시글 번호에 대한 게시글 정보 데이터 요청
		Board board = boardDAO.select(no);
		// 2. 게시글 정보 반환
		return board;
	}

	@Override
	public int insert(Board board) {
		// 1. 게시글 정보를 전달하여 게시글 데이터 등록 요청
		int result = boardDAO.insert(board);
		// 2. 등록된 데이터 건수를 반환
		//	 - 결과 : 0 --> 데이터 등록 실패
		//			 1 --> 데이터 등록 성공 
		return result;
	}

	@Override
	public int update(Board board) {
		// 1. 게시글 정보를 전달하여 게시글 데이터 등록 요청
		int result = boardDAO.update(board);

		// 2. 등록된 데이터 건수를 반환
		// 	- 결과 : 0 --> 데이터 수정 실패
		//		    1 --> 데이터 수정 성공 
		return result;
	}

	@Override
	public int delete(int no){
		int result = boardDAO.delete(no);
		// 1. 게시글 정보를 전달하여 게시글 데이터 등록 요청
		// 2. 등록된 데이터 건수를 반환
		// 	- 결과 :  0 --> 데이터 수정 실패
		//		     1 --> 데이터 수정 성공 
		return result;
	}
	



	

	
	
}

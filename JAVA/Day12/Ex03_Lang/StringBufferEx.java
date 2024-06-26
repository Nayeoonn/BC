package Day12.Ex03_Lang;

public class StringBufferEx {
	public static void main(String[] args) {
		// StringBuffer
		// : 문자열을 조작하는 클래스
		// - 문자열을 추가/수정/삭제하는 메소드를 제공
		StringBuffer sb = new StringBuffer("This");
		System.out.println(sb);
		
		// append("추가 문자열") : 문자열 마지막에 새 문자열을 추가하는 메소드
		sb.append(" is Java");
		System.out.println(sb);
		
		// insert(index, "추가 문자열") : 지정한 index에 문자열 추가하는 메소드
		sb.insert(7, " real");
		System.out.println(sb);
		
		// replace(시작 index, 끝 index+1, "대체 문자열")
		// : 시작 index ~ 끝 index 까지 문자열을 새 문자열로 대체하는 메소드
		sb.replace(8, 12, "good");
		System.out.println(sb);
		
		// delete (시작 index, 끝 index+1)
		// : 시작 index ~ 끝 index 까지 문자열을 삭제하는 메소드
		sb.delete(8, 13);
		System.out.println(sb);
		
		// setLength(길이) : 문자열의 길이를 지정하는 메소드
		sb.setLength(4);
		System.out.println(sb);
		
	}

}

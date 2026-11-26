package schedule.dto;

import lombok.Getter;

// getter 어노테이션선언
@Getter
public class CreateScheduleRequest {
    // 일정 생성 시 클라이언트로부터 전달받는 필드 선언
    // ID, 작성일, 수정일은 서버에서 자동 생성하므로 제외
    private String title;
    private String content;
    private String author;
    private String password;
}

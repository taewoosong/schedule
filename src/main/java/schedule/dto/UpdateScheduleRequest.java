package schedule.dto;

import lombok.Getter;

// getter 어노테이션선언
@Getter
public class UpdateScheduleRequest {
    // 수정할 일정 제목
    private String title;
    // 수정할 작성자명
    private String author;
    // 수정 권한 확인에 사용할 비밀번호.
    private String password;
}

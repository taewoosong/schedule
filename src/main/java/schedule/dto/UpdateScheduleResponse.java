package schedule.dto;

import lombok.Getter;

import java.time.LocalDateTime;

// getter 어노테이션선언
@Getter
public class UpdateScheduleResponse {
    // 응답에 필요한 필드 선언하기 비밀번호 제외하고
    private final Long id;
    private final String title;
    private final String content;
    private final String author;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    //매개변수 생성자 작성
    public UpdateScheduleResponse(Long id, String title, String content, String author, LocalDateTime createdAt, LocalDateTime modifiedAt)
    {
        // 생성자로 전달받은 값을 각 필드에 저장
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}

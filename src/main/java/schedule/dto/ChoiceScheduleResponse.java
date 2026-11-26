package schedule.dto;

import lombok.Getter;

import java.time.LocalDateTime;

// Getter 어노테이션선언
@Getter
public class ChoiceScheduleResponse {

    // 조회 결과로 반환할 필드 선언
    private final Long id;
    private final String title;
    private final String content;
    private final String author;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    // 매개변수 생성자 작성 및 필드 초기화
    public ChoiceScheduleResponse(Long id, String title, String content, String author, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}

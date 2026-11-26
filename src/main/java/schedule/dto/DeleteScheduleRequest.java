package schedule.dto;

import lombok.Getter;

@Getter
public class DeleteScheduleRequest {
    // 삭제 권한 확인에 사용할 비밀번호.
    private String password;
}

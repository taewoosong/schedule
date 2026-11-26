package schedule.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import schedule.dto.*;
import schedule.service.ScheduleService;

import java.util.List;

// REST API 요청을 처리하는 Controller 선언
@RestController
@RequiredArgsConstructor
public class ScheduleController {
    // 생성자 주입을 통해 Service 연결
    private final ScheduleService scheduleService;

    // POST 요청을 통해 일정 생성
    @PostMapping("/schedules")
    // RequestBody를 통해 클라이언트의 JSON 데이터 전달받기
    public ResponseEntity<CreateScheduleResponse> createSchedule(@RequestBody CreateScheduleRequest request) {
        // Service의 일정 생성 메서드 호출
        CreateScheduleResponse createScheduleResponse = scheduleService.createSchedule(request);
        // 생성 결과를 HTTP 상태 코드 201과 함께 반환
        return ResponseEntity.status(HttpStatus.CREATED).body(createScheduleResponse);
    }

    // GET 요청을 통해 특정 일정 조회
    @GetMapping("/schedules/{Id}")
    // PathVariable을 사용하여 일정 ID 전달받기
    public ResponseEntity<ChoiceScheduleResponse> choiceSchedule(@PathVariable Long Id){
        // Service의 단건 조회 메서드 호출
        ChoiceScheduleResponse choiceScheduleResponse = scheduleService.choiceScheduleResponse(Id);
        // 조회 결과를 HTTP 상태 코드 200과 함께 반환
        return ResponseEntity.status(HttpStatus.OK).body(choiceScheduleResponse);
    }

    @GetMapping("/schedules")
    public ResponseEntity<List<ChoiceScheduleResponse>> choiceSchedulesAll(@RequestParam(required = false) String author){
        // Service를 호출하여 조회된 일정 목록을 List 변수에 저장
        List<ChoiceScheduleResponse> schedules = scheduleService.choiceSchedulesAll(author);
        return ResponseEntity.status(HttpStatus.OK).body(schedules);
    }

    // PATCH 요청을 통해 특정 일정 수정
    @PatchMapping("/schedules/{Id}")
    // PathVariable을 통해 수정할 일정 ID 전달받기
    public ResponseEntity<UpdateScheduleResponse> updateSchedule(
            @PathVariable Long Id, @RequestBody UpdateScheduleRequest request){
        return ResponseEntity.status(HttpStatus.OK).body(scheduleService.updateSchedule(Id, request));
    }

    // DELETE 요청을 통해 특정 일정 삭제
    @DeleteMapping("/schedules/{Id}")
    public ResponseEntity<Void> deleteSchedule(
            // PathVariable을 통해 삭제할 일정 ID 전달받기
            // RequestBody를 통해 비밀번호 전달받기
            @PathVariable Long Id , @RequestBody DeleteScheduleRequest request){
        // Service의 일정 삭제 메서드 호출
        scheduleService.delete(Id, request);
        // HTTP 상태 코드 204와 함께 응답 반환
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

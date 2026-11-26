package schedule.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import schedule.dto.ChoiceScheduleResponse;
import schedule.dto.CreateScheduleRequest;
import schedule.dto.CreateScheduleResponse;
import schedule.entity.Schedule;
import schedule.repository.ScheduleRepository;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    // 생성자 주입을 통해 Repository 연결
    private final ScheduleRepository scheduleRepository;

    // 일정 생성 메서드 및 트랜잭션 적용
    @Transactional
    public CreateScheduleResponse createSchedule(CreateScheduleRequest request){
        // Request DTO에서 전달받은 데이터로 Schedule 객체 생성
        Schedule schedule = new Schedule(
                request.getTitle(),
                request.getContent(),
                request.getAuthor(),
                request.getPassword()
        );
        // Repository를 통해 일정 데이터를 DB에 저장
        Schedule savedSchedule = scheduleRepository.save(schedule);
        // 저장된 Entity의 데이터를 Response DTO로 변환하여 반환
        // 비밀번호는 응답 데이터에서 제외
        return new CreateScheduleResponse(
                savedSchedule.getId(),
                savedSchedule.getTitle(),
                savedSchedule.getContent(),
                savedSchedule.getAuthor(),
                savedSchedule.getCreatedAt(),
                savedSchedule.getModifiedAt()
        );
    }

    // 단건 조회 메서드 및 읽기 전용 트랜잭션 적용
    @Transactional(readOnly = true)
    public ChoiceScheduleResponse choiceScheduleResponse(Long scheduleId) {
        // Repository를 통해 ID에 해당하는 일정 조회
        // 해당 일정이 존재하지 않으면 예외 발생
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalArgumentException("없는 일정입니다.")
        );
        // 조회된 Entity를 Response DTO로 변환하여 반환
        return new ChoiceScheduleResponse(
                schedule.getId(),
                schedule.getTitle(),
                schedule.getContent(),
                schedule.getAuthor(),
                schedule.getCreatedAt(),
                schedule.getModifiedAt()
        );
    }
}

package schedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import schedule.entity.Schedule;

// JpaRepository를 상속하여 기본 CRUD 기능 사용
// Schedule은 관리할 Entity, Long은 ID의 자료형
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}

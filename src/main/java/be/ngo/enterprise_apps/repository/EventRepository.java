package be.ngo.enterprise_apps.repository;

import be.ngo.enterprise_apps.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findTop10ByOrderByTijdstipDesc();
}

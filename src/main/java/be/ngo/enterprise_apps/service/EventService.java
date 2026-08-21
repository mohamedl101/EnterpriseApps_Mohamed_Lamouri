package be.ngo.enterprise_apps.service;

import be.ngo.enterprise_apps.model.Event;
import be.ngo.enterprise_apps.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public List<Event> getLaatste10Events() {
        return eventRepository.findTop10ByOrderByTijdstipDesc();
    }

    public Optional<Event> findById(Long id) {
        return eventRepository.findById(id);
    }

    public Event save(Event event) {
        return eventRepository.save(event);
    }
}

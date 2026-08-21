package be.ngo.enterprise_apps.controller;

import be.ngo.enterprise_apps.model.ContactForm;
import be.ngo.enterprise_apps.model.Event;
import be.ngo.enterprise_apps.model.Locatie;
import be.ngo.enterprise_apps.repository.LocatieRepository;
import be.ngo.enterprise_apps.service.EventService;
import be.ngo.enterprise_apps.service.MailService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class EventController {

    @Autowired
    private EventService eventService;

    @Autowired
    private LocatieRepository locatieRepository;

    @Autowired
    private MailService mailService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("events", eventService.getLaatste10Events());
        return "index";
    }

    @GetMapping("/new")
    public String showNewForm(Model model) {
        model.addAttribute("event", new Event());
        model.addAttribute("locaties", locatieRepository.findAll());
        return "new";
    }

    @PostMapping("/new")
    public String saveEvent(@Valid @ModelAttribute("event") Event event,
                            BindingResult bindingResult,
                            Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("locaties", locatieRepository.findAll());
            return "new";
        }
        eventService.save(event);
        return "redirect:/";
    }

    @GetMapping("/details")
    public String getDetails(@RequestParam Long id, Model model) {
        return eventService.findById(id)
                .map(event -> {
                    model.addAttribute("event", event);
                    return "details";
                })
                .orElse("redirect:/");
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/contact")
    public String showContact(Model model) {
        model.addAttribute("contactForm", new ContactForm());
        return "contact";
    }

    @PostMapping("/contact")
    public String sendContact(@Valid @ModelAttribute("contactForm") ContactForm contactForm,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes,
                              Model model) {
        if (bindingResult.hasErrors()) {
            return "contact";
        }
        try {
            mailService.stuurContactMail(contactForm);
            redirectAttributes.addFlashAttribute("success", "Uw bericht is succesvol verzonden!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Er is een fout opgetreden bij het verzenden. Probeer het later opnieuw.");
        }
        return "redirect:/contact";
    }
}

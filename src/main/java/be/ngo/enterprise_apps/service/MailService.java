package be.ngo.enterprise_apps.service;

import be.ngo.enterprise_apps.model.ContactForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    @Autowired
    private JavaMailSender mailSender;

    public void stuurContactMail(ContactForm form) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("gdt.kaai.student@ehb.be ");
        message.setSubject("[Contact] " + form.getOnderwerp());
        message.setText(
                "Van: " + form.getNaam() + " <" + form.getEmail() + ">\n\n" + form.getBericht()
        );
        message.setReplyTo(form.getEmail());
        mailSender.send(message);
    }
}

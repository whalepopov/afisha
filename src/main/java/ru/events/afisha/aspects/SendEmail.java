package ru.events.afisha.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

@Component
@Aspect
public class SendEmail {

    @Value("${email}")
    String mail;

    @Pointcut("@annotation(ru.events.afisha.annotations.Sendable)")
    public void sendEmail() {
    }

    @Around("sendEmail()")
    public void after(JoinPoint point) {
        String mailSubject;
        switch (point.getSignature().getName()) {
            case "addEvent":
                mailSubject = "Анонс мероприятия";
                break;
            case "setEvent":
                mailSubject = "Перенос мероприятия";
                break;
            case "buyTicket":
                mailSubject = "Покупка билета";
                break;
            default:
                mailSubject = "Событие";
                break;
        }
        sendEmail(mailSubject);
    }

    public void sendEmail(String mailText) {
        System.out.println("письмо отправлено на почту " + mail + ": " + mailText);
    }
}

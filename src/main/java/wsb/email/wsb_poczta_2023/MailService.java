package wsb.email.wsb_poczta_2023;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailService {

    final private JavaMailSender javaMailSender;

    void sendMail(Mail mail) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setTo(mail.getRecipient());
            mimeMessageHelper.setSubject(mail.getSubject());
            mimeMessageHelper.setText(mail.getContent());
            if (mail.getAttachment() != null) {
                mimeMessageHelper.addAttachment(mail.getAttachment().getOriginalFilename(), mail.getAttachment());
            }
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            System.out.println("Wysyłka mejla nie powiodła się");
        }
    }

}

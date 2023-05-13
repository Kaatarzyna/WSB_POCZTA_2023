package wsb.email.wsb_poczta_2023;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mails")
public class MailController {

    @GetMapping
    String index() {
        return "index";
    }


}

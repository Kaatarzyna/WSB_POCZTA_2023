package wsb.email.wsb_poczta_2023;

import lombok.Data;

@Data
public class Mail {

    private String recipient;

    private String subject;

    private String content;
}

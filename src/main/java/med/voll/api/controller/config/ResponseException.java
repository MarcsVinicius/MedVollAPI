package med.voll.api.controller.config;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Builder
public class ResponseException {
    private int code;
    private Object message;
}

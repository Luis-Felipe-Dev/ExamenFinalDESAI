package pe.isil.ExamenFinalDESAI.visit;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VisitDTO {
    private String code;
    private String message;
    private Object data;

    public static VisitDTO whenVisitLocalAlreadeyNoExists() {
        return VisitDTO.builder()
                .code("500")
                .message("DNI de afiliado no existe.")
                .build();
    }

    public static VisitDTO whenVisitRegistrationSucced() {
        return VisitDTO.builder()
                .code("200")
                .message("Visita registrada correctamente")
                .build();
    }

    public static VisitDTO whenError(String message) {
        return VisitDTO.builder()
                .code("500")
                .message("Ocurrio un error ".concat(message))
                .build();
    }
}

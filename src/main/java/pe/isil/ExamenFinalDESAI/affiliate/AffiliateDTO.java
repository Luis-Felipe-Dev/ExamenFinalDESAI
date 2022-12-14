package pe.isil.ExamenFinalDESAI.affiliate;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AffiliateDTO {
    private String code;
    private String message;
    private Object data;

    public static AffiliateDTO whenAffiliateDniAffiliateAlreadeyExists() {
        return AffiliateDTO.builder()
                .code("500")
                .message("DNI ya existe.")
                .build();
    }

    public static AffiliateDTO whenAffiliateRegistrationSucced() {
        return AffiliateDTO.builder()
                .code("200")
                .message("Usuario registrado correctamente")
                .build();
    }

    public static AffiliateDTO whenError(String message) {
        return AffiliateDTO.builder()
                .code("500")
                .message("Ocurrio un error ".concat(message))
                .build();
    }
}

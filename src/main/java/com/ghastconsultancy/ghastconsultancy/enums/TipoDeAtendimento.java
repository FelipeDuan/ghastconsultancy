package com.ghastconsultancy.ghastconsultancy.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoDeAtendimento {

    PEQUENO(1),
    MEDIO(2),
    GRANDE(3);

    private int code;

    public static TipoDeAtendimento valueOf(int code) {
        for (TipoDeAtendimento value : TipoDeAtendimento.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Código para o tipo de atendimento inválido");
    }


}

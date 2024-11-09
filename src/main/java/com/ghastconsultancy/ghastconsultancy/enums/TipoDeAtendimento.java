package com.ghastconsultancy.ghastconsultancy.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
public enum TipoDeAtendimento {

    PEQUENO(1),
    MEDIO(2),
    GRANDE(3);

    private Integer code;

    public Integer getCode() {
        return code;
    }

    public static TipoDeAtendimento valueOf(Integer code) {
        // vai buscar no código de todos os tipos enumerados de  TipoDeAtendimento
        for (TipoDeAtendimento value : TipoDeAtendimento.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Código para o tipo de atendimento inválido");
    }


}

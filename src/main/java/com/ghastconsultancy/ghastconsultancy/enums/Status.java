package com.ghastconsultancy.ghastconsultancy.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum Status {

    ANALISE_INICIAL(1),
    IMPLEMENTACAO(2),
    REVISAO_FINAL(3),
    CONCLUIDO(4);

    private Integer code;

    public static Status valueOf(Integer code) {
        // vai buscar no código de todos os tipos enumerados de Status
        for (Status value : Status.values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Código para o status inválido");
    }



}

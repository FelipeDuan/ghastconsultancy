package com.ghastconsultancy.ghastconsultancy.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Especializacao {

    FINANCEIRO(1),
    GESTAO(2),
    TECNOLOGIA(3);

    private Integer code;

    public static Especializacao valueOf(Integer code) {
        // vai buscar no código de todos os tipos enumerados de  EspecializacaoConsultor
        for (Especializacao value : Especializacao.values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Código para a especialização inválido");
    }




}

package com.ghastconsultancy.ghastconsultancy.config;

import com.ghastconsultancy.ghastconsultancy.enums.Especializacao;
import com.ghastconsultancy.ghastconsultancy.enums.SetorAtuacao;
import com.ghastconsultancy.ghastconsultancy.enums.TamanhoNegocio;
import com.ghastconsultancy.ghastconsultancy.enums.TipoCliente;
import com.ghastconsultancy.ghastconsultancy.model.Cliente;
import com.ghastconsultancy.ghastconsultancy.model.Consultor;
import com.ghastconsultancy.ghastconsultancy.model.Contrato;
import com.ghastconsultancy.ghastconsultancy.model.Empresa;
import com.ghastconsultancy.ghastconsultancy.repository.ClienteRepository;
import com.ghastconsultancy.ghastconsultancy.repository.ConsultorRepository;
import com.ghastconsultancy.ghastconsultancy.repository.ContratoRepository;
import com.ghastconsultancy.ghastconsultancy.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@Profile("teste")
public class TestConfig implements CommandLineRunner {

    // Arquivo Criado apenas com o intuito de popular o banco de dados com alguns dados

    private final ClienteRepository clienteRepository;
    private final ConsultorRepository consultorRepository;
    private final EmpresaRepository empresaRepository;
    private final ContratoRepository contratoRepository;

    public TestConfig(ClienteRepository clienteRepository, ConsultorRepository consultorRepository, EmpresaRepository empresaRepository, ContratoRepository contratoRepository) {
        this.clienteRepository = clienteRepository;
        this.consultorRepository = consultorRepository;
        this.empresaRepository = empresaRepository;
        this.contratoRepository = contratoRepository;
    }

    @Override
    public void run(String... args) {
//        Cliente cliente1 = new Cliente("Kratos", "11111111111", "kratos@gmail.com", "999999999");
//        Cliente cliente2 = new Cliente("Mario", "22222222222", "mario@gmail.com", "888888888");
//        Cliente cliente3 = new Cliente("Sonic", "33333333333", "sonic@gmail.com", "777777777");
//        Cliente cliente4 = new Cliente("CJ Johnson", "44444444444", "cj@gmail.com", "666666666");
//        Cliente cliente5 = new Cliente("Goku", "55555555555", "goku@gmail.com", "555555555");
//        Cliente cliente6 = new Cliente("Naruto Uzumaki", "66666666666", "naruto@gmail.com", "444444444");
//        Cliente cliente7 = new Cliente("Neo", "77777777777", "neo@gmail.com", "333333333");
//        Cliente cliente8 = new Cliente("Dante", "88888888888", "dante@gmail.com", "222222222");
//        Cliente cliente9 = new Cliente("Slash", "99999999999", "slash@gmail.com", "111111111");
//        Cliente cliente10 = new Cliente("Scorpion", "10101010101", "scorpion@gmail.com", "123456789");
//        Cliente cliente11 = new Cliente("Sub-Zero", "20202020202", "subzero@gmail.com", "987654321");
//        Cliente cliente12 = new Cliente("Leon S. Kennedy", "30303030303", "leon@gmail.com", "159357456");
//        Cliente cliente13 = new Cliente("Peter Parker", "40404040404", "spiderman@gmail.com", "789123456");
//        Cliente cliente14 = new Cliente("Clark Kent", "50505050505", "superman@gmail.com", "456789123");
//        Cliente cliente15 = new Cliente("Bruce Wayne", "60606060606", "batman@gmail.com", "321654987");
//        Cliente cliente16 = new Cliente("Jill Valentine", "70707070707", "jill@gmail.com", "654987321");
//        Cliente cliente17 = new Cliente("Lara Croft", "80808080808", "lara@gmail.com", "741852963");
//        Cliente cliente18 = new Cliente("Nathan Drake", "90909090909", "nathan@gmail.com", "963852741");
//        Cliente cliente19 = new Cliente("Master Chief", "11122233344", "chief@gmail.com", "852963741");
//        Cliente cliente20 = new Cliente("Geralt of Rivia", "55566677788", "geralt@gmail.com", "369258147");
//
//        clienteRepository.saveAll(Arrays.asList(
//                cliente1, cliente2, cliente3, cliente4, cliente5, cliente6,
//                cliente7, cliente8, cliente9, cliente10, cliente11, cliente12,
//                cliente13, cliente14, cliente15, cliente16, cliente17, cliente18,
//                cliente19, cliente20));
//
//
//        Consultor c1 = new Consultor(Especializacao.FINANCEIRO, TamanhoNegocio.PEQUENO, "11987654321", "12345678901", "luffy@onepiece.com", "Luffy");
//        Consultor c2 = new Consultor(Especializacao.FINANCEIRO, TamanhoNegocio.MEDIO, "11987654322", "23456789012", "zoro@onepiece.com", "Zoro");
//        Consultor c3 = new Consultor(Especializacao.FINANCEIRO, TamanhoNegocio.GRANDE, "11987654323", "34567890123", "naruto@naruto.com", "Naruto");
//        Consultor c4 = new Consultor(Especializacao.FINANCEIRO, TamanhoNegocio.PEQUENO, "11987654324", "45678901234", "sasuke@naruto.com", "Sasuke");
//        Consultor c5 = new Consultor(Especializacao.FINANCEIRO, TamanhoNegocio.MEDIO, "11987654325", "56789012345", "goku@dragonball.com", "Goku");
//        Consultor c6 = new Consultor(Especializacao.FINANCEIRO, TamanhoNegocio.GRANDE, "11987654326", "67890123456", "vegeta@dragonball.com", "Vegeta");
//        Consultor c7 = new Consultor(Especializacao.FINANCEIRO, TamanhoNegocio.PEQUENO, "11987654327", "78901234567", "gojo@jujutsukaisen.com", "Gojo Satoru");
//
//        Consultor c8 = new Consultor(Especializacao.GESTAO, TamanhoNegocio.MEDIO, "11987654328", "89012345678", "levi@attackontitan.com", "Levi Ackerman");
//        Consultor c9 = new Consultor(Especializacao.GESTAO, TamanhoNegocio.GRANDE, "11987654329", "90123456789", "eren@attackontitan.com", "Eren Yeager");
//        Consultor c10 = new Consultor(Especializacao.GESTAO, TamanhoNegocio.PEQUENO, "11987654330", "01234567890", "ichigo@bleach.com", "Ichigo Kurosaki");
//        Consultor c11 = new Consultor(Especializacao.GESTAO, TamanhoNegocio.MEDIO, "11987654331", "13579246801", "tanjiro@demonslayer.com", "Tanjiro Kamado");
//        Consultor c12 = new Consultor(Especializacao.GESTAO, TamanhoNegocio.GRANDE, "11987654332", "24680357912", "yuno@blackclover.com", "Yuno");
//        Consultor c13 = new Consultor(Especializacao.GESTAO, TamanhoNegocio.PEQUENO, "11987654333", "35791468023", "meliodas@nanatsunotaizai.com", "Meliodas");
//        Consultor c14 = new Consultor(Especializacao.GESTAO, TamanhoNegocio.MEDIO, "11987654334", "46802579134", "edward@fullmetal.com", "Edward Elric");
//
//        Consultor c15 = new Consultor(Especializacao.TECNOLOGIA, TamanhoNegocio.GRANDE, "11987654335", "57913680245", "saitama@onepunchman.com", "Saitama");
//        Consultor c16 = new Consultor(Especializacao.TECNOLOGIA, TamanhoNegocio.PEQUENO, "11987654336", "68024791356", "mob@mobpsycho.com", "Mob");
//        Consultor c17 = new Consultor(Especializacao.TECNOLOGIA, TamanhoNegocio.MEDIO, "11987654337", "79135802467", "gon@hunterxhunter.com", "Gon Freecss");
//        Consultor c18 = new Consultor(Especializacao.TECNOLOGIA, TamanhoNegocio.GRANDE, "11987654338", "80246913578", "killua@hunterxhunter.com", "Killua Zoldyck");
//        Consultor c19 = new Consultor(Especializacao.TECNOLOGIA, TamanhoNegocio.PEQUENO, "11987654339", "91357024689", "ash@pokemon.com", "Ash Ketchum");
//        Consultor c20 = new Consultor(Especializacao.TECNOLOGIA, TamanhoNegocio.MEDIO, "11987654340", "02468135790", "light@deathnote.com", "Light Yagami");
//        Consultor c21 = new Consultor(Especializacao.TECNOLOGIA, TamanhoNegocio.GRANDE, "11987654341", "13579024681", "kaneki@tokyoghoul.com", "Ken Kaneki");
//
//        consultorRepository.saveAll(Arrays.asList(
//                c1, c2, c3, c4, c5, c6, c7,
//                c8, c9, c10, c11, c12, c13, c14,
//                c15, c16, c17, c18, c19, c20, c21
//        ));

//        // Usando clientes já criados como representantes legais
//        Cliente representante1 = clienteRepository.findById(1L).orElseThrow(() -> new RuntimeException("Representante não encontrado"));
//        Cliente representante2 = clienteRepository.findById(2L).orElseThrow(() -> new RuntimeException("Representante não encontrado"));
//        Cliente representante3 = clienteRepository.findById(3L).orElseThrow(() -> new RuntimeException("Representante não encontrado"));
//        Cliente representante4 = clienteRepository.findById(4L).orElseThrow(() -> new RuntimeException("Representante não encontrado"));
//        Cliente representante5 = clienteRepository.findById(5L).orElseThrow(() -> new RuntimeException("Representante não encontrado"));
//
//        // Criando empresas
//        Empresa e1 = new Empresa("Nintendo", "12345678000101", "contato@nintendo.com", "1145678901", SetorAtuacao.TECNOLOGIA, representante1);
//        Empresa e2 = new Empresa("Sony Pictures", "23456789000102", "contato@sonypictures.com", "1145678902", SetorAtuacao.INDUSTRIA, representante2);
//        Empresa e3 = new Empresa("Rockstar Games", "34567890000103", "contato@rockstargames.com", "1145678903", SetorAtuacao.TECNOLOGIA, representante3);
//        Empresa e4 = new Empresa("Warner Bros", "45678900000104", "contato@warnerbros.com", "1145678904", SetorAtuacao.INDUSTRIA, representante4);
//        Empresa e5 = new Empresa("Ubisoft", "56789000000105", "contato@ubisoft.com", "1145678905", SetorAtuacao.TECNOLOGIA, representante5);
//
//        // Salvando empresas no banco
//        empresaRepository.saveAll(Arrays.asList(e1, e2, e3, e4, e5));

//        // Recuperando entidades existentes
//        Cliente cliente1 = clienteRepository.findById(1L).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
//        Cliente cliente3 = clienteRepository.findById(3L).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
//        Cliente cliente4 = clienteRepository.findById(4L).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
//
//        Empresa empresa1 = empresaRepository.findById(1L).orElseThrow(() -> new RuntimeException("Empresa não encontrada"));
//        Empresa empresa2 = empresaRepository.findById(2L).orElseThrow(() -> new RuntimeException("Empresa não encontrada"));
//        Empresa empresa3 = empresaRepository.findById(3L).orElseThrow(() -> new RuntimeException("Empresa não encontrada"));
//
//        Consultor consultor1 = consultorRepository.findById(1L).orElseThrow(() -> new RuntimeException("Consultor não encontrado"));
//        Consultor consultor2 = consultorRepository.findById(2L).orElseThrow(() -> new RuntimeException("Consultor não encontrado"));
//        Consultor consultor3 = consultorRepository.findById(3L).orElseThrow(() -> new RuntimeException("Consultor não encontrado"));
//
//        // Lista para armazenar contratos
//        List<Contrato> contratos = new ArrayList<>();
//
//        // Quantidades de contratos por mês
//        int[] contratosPorMes = {2, 8, 6, 14, 5, 7, 3, 6, 9, 16, 4, 10};
//        LocalDate dataInicio = LocalDate.of(2024, 1, 1);
//
//        for (int mes = 0; mes < contratosPorMes.length; mes++) {
//            for (int i = 0; i < contratosPorMes[mes]; i++) {
//                Cliente cliente = i % 3 == 0 ? cliente1 : (i % 3 == 1 ? cliente3 : cliente4);
//                Empresa empresa = i % 3 == 0 ? empresa1 : (i % 3 == 1 ? empresa2 : empresa3);
//                Consultor consultor = i % 3 == 0 ? consultor1 : (i % 3 == 1 ? consultor2 : consultor3);
//                TipoCliente tipoCliente = (i % 2 == 0) ? TipoCliente.VIP : TipoCliente.PADRAO;
//
//                contratos.add(new Contrato(
//                        null,
//                        cliente,
//                        empresa,
//                        consultor,
//                        i % 3 == 0 ? "FINANCEIRO" : (i % 3 == 1 ? "GESTAO" : "TECNOLOGIA"),
//                        dataInicio.withMonth(mes + 1).withDayOfMonth(1),
//                        dataInicio.withMonth(mes + 1).plusDays(29), // Ajusta data fim ao mês
//                        tipoCliente
//                ));
//            }
//        }
//
//        // Salvando contratos no banco
//        contratoRepository.saveAll(contratos);
    }

}


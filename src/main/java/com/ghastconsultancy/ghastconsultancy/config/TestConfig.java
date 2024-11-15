package com.ghastconsultancy.ghastconsultancy.config;

import com.ghastconsultancy.ghastconsultancy.repository.ClienteRepository;
import com.ghastconsultancy.ghastconsultancy.repository.ConsultorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("teste")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ConsultorRepository consultorRepository;
    @Override
    public void run(String... args) throws Exception {
//        Cliente cliente1 = new Cliente("Ana Silva", "12345678901", "ana.silva@exemplo.com", "11987654321");
//        Cliente cliente2 = new Cliente("Carlos Oliveira", "23456789012", "carlos.oliveira@exemplo.com", "11976543210");
//        Cliente cliente3 = new Cliente("Mariana Costa", "34567890123", "mariana.costa@exemplo.com", "11965432109");
//        Cliente cliente4 = new Cliente("Felipe Souza", "45678901234", "felipe.souza@exemplo.com", "11954321098");
//        Cliente cliente5 = new Cliente("Lucas Pereira", "56789012345", "lucas.pereira@exemplo.com", "11943210987");
//        Cliente cliente6 = new Cliente("Paula Almeida", "67890123456", "paula.almeida@exemplo.com", "11932109876");
//        Cliente cliente7 = new Cliente("Roberto Lima", "78901234567", "roberto.lima@exemplo.com", "11921098765");
//        Cliente cliente8 = new Cliente("Fernanda Costa", "89012345678", "fernanda.costa@exemplo.com", "11910987654");
//        Cliente cliente9 = new Cliente("Juliana Santos", "90123456789", "juliana.santos@exemplo.com", "11899876543");
//        Cliente cliente10 = new Cliente("Thiago Rocha", "01234567890", "thiago.rocha@exemplo.com", "11888765432");
//        Cliente cliente11 = new Cliente("Beatriz Martins", "12398765432", "beatriz.martins@exemplo.com", "11877654321");
//        Cliente cliente12 = new Cliente("Gustavo Ferreira", "23487654321", "gustavo.ferreira@exemplo.com", "11866543210");
//        Cliente cliente13 = new Cliente("Patrícia Rocha", "34576543210", "patricia.rocha@exemplo.com", "11855432109");
//        Cliente cliente14 = new Cliente("André Santos", "45665432109", "andre.santos@exemplo.com", "11844321098");
//        Cliente cliente15 = new Cliente("Larissa Oliveira", "56754321098", "larissa.oliveira@exemplo.com", "11833210987");
//
//        clienteRepository.saveAll(Arrays.asList(cliente1, cliente2, cliente3, cliente4, cliente5, cliente6,
//                cliente7, cliente8, cliente9, cliente10, cliente11, cliente12,
//                cliente13, cliente14, cliente15));


//        Consultor c1 = new Consultor("Jonesy", "12345678901", "jonesy@fortnite.com", "11987654321", TipoDeAtendimento.PEQUENO, Especializacao.FINANCEIRO);
//        Consultor c2 = new Consultor("Peely", "23456789012", "peely@fortnite.com", "11987654322", TipoDeAtendimento.MEDIO, Especializacao.GESTAO);
//        Consultor c3 = new Consultor("Midas", "34567890123", "midas@fortnite.com", "11987654323", TipoDeAtendimento.GRANDE, Especializacao.TECNOLOGIA);
//        Consultor c4 = new Consultor("Raven", "45678901234", "raven@fortnite.com", "11987654324", TipoDeAtendimento.PEQUENO, Especializacao.FINANCEIRO);
//        Consultor c5 = new Consultor("Drift", "56789012345", "drift@fortnite.com", "11987654325", TipoDeAtendimento.MEDIO, Especializacao.GESTAO);
//        Consultor c6 = new Consultor("Chaos Agent", "67890123456", "chaos.agent@fortnite.com", "11987654326", TipoDeAtendimento.GRANDE, Especializacao.TECNOLOGIA);
//        Consultor c7 = new Consultor("Banana", "78901234567", "banana@fortnite.com", "11987654327", TipoDeAtendimento.PEQUENO, Especializacao.FINANCEIRO);
//        Consultor c8 = new Consultor("Lynx", "89012345678", "lynx@fortnite.com", "11987654328", TipoDeAtendimento.MEDIO, Especializacao.GESTAO);
//        Consultor c9 = new Consultor("Wild Card", "90123456789", "wild.card@fortnite.com", "11987654329", TipoDeAtendimento.GRANDE, Especializacao.TECNOLOGIA);
//        Consultor c10 = new Consultor("Aquaman", "01234567890", "aquaman@fortnite.com", "11987654330", TipoDeAtendimento.PEQUENO, Especializacao.FINANCEIRO);
//        Consultor c11 = new Consultor("The Mandalorian", "13579246801", "mandalorian@fortnite.com", "11987654331", TipoDeAtendimento.MEDIO, Especializacao.GESTAO);
//        Consultor c12 = new Consultor("Blade", "24680357912", "blade@fortnite.com", "11987654332", TipoDeAtendimento.GRANDE, Especializacao.TECNOLOGIA);
//        Consultor c13 = new Consultor("Deadpool", "35791468023", "deadpool@fortnite.com", "11987654333", TipoDeAtendimento.PEQUENO, Especializacao.FINANCEIRO);
//        Consultor c14 = new Consultor("Kratos", "46802579134", "kratos@fortnite.com", "11987654334", TipoDeAtendimento.MEDIO, Especializacao.GESTAO);
//        Consultor c15 = new Consultor("Spider-Man", "57913680245", "spiderman@fortnite.com", "11987654335", TipoDeAtendimento.GRANDE, Especializacao.TECNOLOGIA);
//
//        consultorRepository.saveAll(Arrays.asList(
//                c1, c2, c3, c4, c5, c6,
//                c7, c8, c9, c10, c11, c12,
//                c13, c14, c15
//        ));

    }
}

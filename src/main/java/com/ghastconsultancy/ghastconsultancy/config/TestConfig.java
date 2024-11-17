package com.ghastconsultancy.ghastconsultancy.config;

import com.ghastconsultancy.ghastconsultancy.enums.Especializacao;
import com.ghastconsultancy.ghastconsultancy.enums.TamanhoNegocio;
import com.ghastconsultancy.ghastconsultancy.model.Cliente;
import com.ghastconsultancy.ghastconsultancy.model.Consultor;
import com.ghastconsultancy.ghastconsultancy.repository.ClienteRepository;
import com.ghastconsultancy.ghastconsultancy.repository.ConsultorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("teste")
public class TestConfig implements CommandLineRunner {

    // Arquivo Criado apenas com o intuito de popular o banco de dados com alguns dados

    private final ClienteRepository clienteRepository;
    private final ConsultorRepository consultorRepository;

    public TestConfig(ClienteRepository clienteRepository, ConsultorRepository consultorRepository) {
        this.clienteRepository = clienteRepository;
        this.consultorRepository = consultorRepository;
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

    }
}

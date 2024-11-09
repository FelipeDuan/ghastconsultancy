package com.ghastconsultancy.ghastconsultancy.config;


import com.ghastconsultancy.ghastconsultancy.enums.TipoDeAtendimento;
import com.ghastconsultancy.ghastconsultancy.model.Consultor;
import com.ghastconsultancy.ghastconsultancy.repository.ConsultorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("teste")
public class TestConfig implements CommandLineRunner {

    @Autowired
    ConsultorRepository consultorRepository;



    @Override
    public void run(String... args) throws Exception {

       Consultor consultor = new Consultor( "Pablo Patricio","056.255.713-09","pablo.martins@somosicev" +
               ".com","(86) 99973-1747", TipoDeAtendimento.GRANDE);
      consultorRepository.save(consultor);

    }
}
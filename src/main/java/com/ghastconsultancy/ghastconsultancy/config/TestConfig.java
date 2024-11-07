package com.ghastconsultancy.ghastconsultancy.config;


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

        Consultor consultor = new Consultor(null, "Pablo Patricio","123.456.789-00","exemple.exemple@com.com","(11) 99999-9999");
        consultorRepository.save(consultor);

    }
}
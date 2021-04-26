package br.com.rd.andresilvaalves.desafio;

import br.com.rd.andresilvaalves.desafio.model.Paciente;
import br.com.rd.andresilvaalves.desafio.repository.PacienteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.Month;
import java.util.TimeZone;

@Slf4j
@SpringBootApplication
public class DesafioApiRestApplication {

    @Value("${app.message}")
    private String appMessage;

    public static void main(String[] args) {
        SpringApplication.run(DesafioApiRestApplication.class, args);
    }

    @PostConstruct
    private void setTimeZone() {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }

    @Bean
    public CommandLineRunner run() {
        return args -> {
            log.info(appMessage);
        };
    }

    @Component
    static class DataWriter implements ApplicationRunner {

        final PacienteRepository pacienteRepository;

        public DataWriter(PacienteRepository pacienteRepository) {
            this.pacienteRepository = pacienteRepository;
        }

        @Override
        public void run(ApplicationArguments args) {

            pacienteRepository.save(Paciente.builder()
                                            .cpf("cpf")
                                            .dataNascimento(LocalDate.of(1981, Month.FEBRUARY, 26))
                                            .nome("Paciente 1")
                                            .build());

            pacienteRepository.save(Paciente.builder()
                                            .cpf("394.731.510-47")
                                            .dataNascimento(LocalDate.of(2000, Month.JANUARY, 1))
                                            .nome("Paciente 2")
                                            .build());

            pacienteRepository.findAll().forEach(System.out::println);
        }
    }

}

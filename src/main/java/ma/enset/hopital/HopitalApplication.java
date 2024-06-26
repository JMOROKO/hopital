package ma.enset.hopital;

import lombok.AllArgsConstructor;
import ma.enset.hopital.entities.Patient;
import ma.enset.hopital.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.awt.geom.PathIterator;
import java.util.Date;

@SpringBootApplication
@AllArgsConstructor
public class HopitalApplication implements CommandLineRunner {

    private PatientRepository patientRepository;
    public static void main(String[] args) {
        SpringApplication.run(HopitalApplication.class, args);
    }

    @Override
    public void run(String... args) {
        Patient patient = Patient.builder()
                .nom("MOROKO")
                .dateNaissance(new Date())
                .malade(false)
                .score(101)
                .build();
        patientRepository.save(patient);
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}

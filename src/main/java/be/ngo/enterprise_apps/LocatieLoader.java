package be.ngo.enterprise_apps;

import be.ngo.enterprise_apps.model.Locatie;
import be.ngo.enterprise_apps.repository.LocatieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LocatieLoader {

    @Bean
    CommandLineRunner loadLocations(LocatieRepository locatieRepo) {
        return args -> {
            if (locatieRepo.findByNaam("Campus Kaai").isEmpty()) {
                Locatie kaai = new Locatie();
                kaai.setNaam("Campus Kaai");
                kaai.setAdres("Nijverheidskaai 170, 1070 Anderlecht");
                kaai.setCapaciteit(200);
                locatieRepo.save(kaai);
            }

            if (locatieRepo.findByNaam("Kuregem Park").isEmpty()) {
                Locatie park = new Locatie();
                park.setNaam("Kuregem Park");
                park.setAdres("Rue de Birmingham, 1070 Anderlecht");
                park.setCapaciteit(500);
                locatieRepo.save(park);
            }
        };
    }
}

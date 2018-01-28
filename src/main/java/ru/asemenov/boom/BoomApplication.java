package ru.asemenov.boom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import ru.asemenov.boom.hero.DetailedHeroProjection;
import ru.asemenov.boom.hero.Hero;
import ru.asemenov.boom.hero.HeroRepository;
import ru.asemenov.boom.hero.ShortHeroProjection;
import ru.asemenov.boom.publisher.Publisher;
import ru.asemenov.boom.publisher.PublisherRepository;

import javax.annotation.PostConstruct;
import java.util.Date;

/**
 * @author a.semenov
 */
@SpringBootApplication
@Configuration
public class BoomApplication {
    public static void main(String[] args) {
        SpringApplication.run(BoomApplication.class, args);
    }

    @Autowired
    private PublisherRepository publishers;


    @Autowired
    private HeroRepository heroes;

    @PostConstruct
    public void init() {
        final Publisher publisher = new Publisher();
        publisher.setName("Independent");
        publishers.save(publisher);

        final Hero first = new Hero();

        first.setName("Mariano Rajoy");
        first.setPseudonym("Un vaso es un vaso");
        first.publisher(publisher);
        first.setFirstAppearanceDate(new Date(111, 11, 21));

        heroes.save(first);
    }

    @Bean
    public RepositoryRestConfigurerAdapter configuration() {
        return new RepositoryRestConfigurerAdapter() {
            @Override
            public void configureRepositoryRestConfiguration(final RepositoryRestConfiguration config) {
                config.exposeIdsFor(Hero.class);
                config.exposeIdsFor(Publisher.class);

                config.getProjectionConfiguration().addProjection(
                        ShortHeroProjection.class,
                        DetailedHeroProjection.class);
            }
        };
    }
}

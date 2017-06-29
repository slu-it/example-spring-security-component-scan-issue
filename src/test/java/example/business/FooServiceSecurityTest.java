package example.business;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = FooServiceSecurityTest.TestConfiguration.class)
public class FooServiceSecurityTest {

    @EnableGlobalMethodSecurity(prePostEnabled = true)
    @ComponentScan(basePackageClasses = FooService.class)
    public static class TestConfiguration {

        @Bean
        public FooPersistenceService fooPersistenceService() {
            return new FooPersistenceService() {
                // dummy impl
            };
        }

    }

    @Autowired
    FooService cut;

    @Autowired
    FooPersistenceService persistenceService;

    @Test
    public void trigger() {

    }

}

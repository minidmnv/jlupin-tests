package pl.bj.jlupinfirsttest.application.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author minidmnv
 */
@Configuration
@ComponentScan("pl.bj.jlupinfirsttest.application")
public class SpringConfiguration {

    @Bean(name = "jLupinRegularExpressionToRemotelyEnabled")
    public List getRemotelyBeanList() {
        List list = new ArrayList();
        list.add("welcomeService");

        return list;
    }

}

package pl.bj.jlupinfirsttest.application.service.implementation;

import org.springframework.stereotype.Service;
import pl.bj.jlupinfirsttest.application.service.interfaces.WelcomeService;

import java.util.Collections;
import java.util.Map;

/**
 * @author minidmnv
 */
@Service( value = "welcomeService")
public class WelcomeServiceImpl implements WelcomeService {

    @Override
    public Map getWelcomeMessage(Map map) {
        return Collections.singletonMap("message", "Hello " + map.get("name") + "!");
    }

    @Override
    public void logName(String name) {
        //do nothing now
    }

}

package pl.bj.jlupinfirsttest.application.service.interfaces;

import java.util.Map;

/**
 * @author minidmnv
 */
public interface WelcomeService {

    Map getWelcomeMessage(final Map map);

    void logName(final String name);

}

package pl.bj.jlupinfirsttest.application;

import com.jlupin.impl.client.proxy.remote.producer.ext.JLupinRemoteProxyObjectSupportsExceptionProducerImpl;
import com.jlupin.interfaces.client.proxy.producer.JLupinProxyObjectProducer;
import org.junit.Assert;
import org.junit.Test;
import pl.bj.jlupinfirsttest.application.base.BaseTest;
import pl.bj.jlupinfirsttest.application.service.interfaces.WelcomeService;

import java.util.Collections;

import static org.junit.Assert.assertEquals;

/**
 * @author minidmnv
 */
public class CurrencyConverterTest extends BaseTest {

    private JLupinProxyObjectProducer getJlupinProxyObjectProducer() {
        return new JLupinRemoteProxyObjectSupportsExceptionProducerImpl("jlupin-first-test-implementation",
                getDelegator(), getLogger());
    }


    @Test
    public void exampleTest() {
        WelcomeService service = getJlupinProxyObjectProducer().produceObject(WelcomeService.class);
        assertEquals(Collections.singletonMap("message", "Hello Michal!"), service.getWelcomeMessage(Collections
                .singletonMap("name", "Michal")));
    }
}

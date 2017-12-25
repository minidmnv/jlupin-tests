package pl.bj.jlupinfirsttest.application.base;

import com.jlupin.common.communication.common.various.JLupinMainServerInZoneConfiguration;
import com.jlupin.impl.client.util.JLupinClientUtil;
import com.jlupin.impl.logger.impl.log4j.JLupinLoggerOverLog4jImpl;
import com.jlupin.impl.serialize.JLupinFSTSerializerImpl;
import com.jlupin.interfaces.client.delegator.JLupinDelegator;
import com.jlupin.interfaces.common.enums.PortType;
import com.jlupin.interfaces.logger.JLupinLogger;
import com.jlupin.interfaces.serialize.JLupinSerializer;
import org.junit.Before;

/**
 * @author minidmnv
 */
public abstract class BaseTest {

    private static final int SERVER_CHECKING_INTERVAL_MILLIS = 5000;
    private static final int SERVER_CHECKING_REPEATS = 3;
    private static final int SERVER_CHANGE_INTERVAL_MILLIS = 5000;

    private final JLupinLogger logger;
    private final JLupinSerializer serializer;
    private final JLupinDelegator delegator;
    private final JLupinDelegator queueDelegator;

    public BaseTest() {
        logger = JLupinLoggerOverLog4jImpl.getInstance();
        serializer = JLupinFSTSerializerImpl.getInstance();
        delegator = JLupinClientUtil.generateOuterClientLoadBalancerDelegator(
                SERVER_CHECKING_INTERVAL_MILLIS,
                SERVER_CHECKING_REPEATS,
                SERVER_CHANGE_INTERVAL_MILLIS,
                PortType.JLRMC,
                new JLupinMainServerInZoneConfiguration[] {
                        new JLupinMainServerInZoneConfiguration ("NODE_1", "127.0.0.1", 9090, 9095, 9096, 9097)
                },
                logger,
                serializer
        );
        queueDelegator = JLupinClientUtil.generateOuterClientLoadBalancerDelegator(
                SERVER_CHECKING_INTERVAL_MILLIS,
                SERVER_CHECKING_REPEATS,
                SERVER_CHANGE_INTERVAL_MILLIS,
                PortType.QUEUE,
                new JLupinMainServerInZoneConfiguration[] {
                        new JLupinMainServerInZoneConfiguration ("NODE_1", "127.0.0.1", 9090, 9095, 9096, 9097)
                },
                logger,
                serializer
        );
    }

    @Before
    public void setUp() throws Exception {
        delegator.before();
        queueDelegator.before();
    }

    public JLupinLogger getLogger() {
        return logger;
    }

    public JLupinSerializer getSerializer() {
        return serializer;
    }

    public JLupinDelegator getDelegator() {
        return delegator;
    }

    public JLupinDelegator getQueueDelegator() {
        return queueDelegator;
    }
}

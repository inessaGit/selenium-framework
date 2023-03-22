package demo.priceless.temp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class TestLogger {
    private static final Logger LOG = LoggerFactory.getLogger(TestLogger.class);

    @Test
    public static void main( String args[] ) {

        LOG.trace("log trace with arguments '{}'", "arg");
        LOG.warn("log warn");

        LOG.info("Example log from {}", TestLogger.class.getSimpleName()); //logging context

        LOG.debug("log debug");
        LOG.debug("log debug with arguments '{}", "arg");

        LOG.error("log error");
        LOG.error("log error with arguments '{}'", "arg");
    }
}

package pl.zajavka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Logger1 {
    private static final Logger LOGGER = LoggerFactory.getLogger(Logger1.class);

    public static void log1() {
        LOGGER.trace("logging in Logger 1");
        LOGGER.debug("logging in Logger 1");
        LOGGER.info("logging in Logger 1");
    }
}

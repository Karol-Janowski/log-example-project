package pl.zajavka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Logger2 {
    private static final Logger LOGGER = LoggerFactory.getLogger(Logger2.class);

    public static void log2() {
        LOGGER.trace("logging in Logger 2");
        LOGGER.debug("logging in Logger 2");
        LOGGER.info("logging in Logger 2");
    }
}

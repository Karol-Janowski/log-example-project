package pl.zajavka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
        LOGGER.trace("Some messange {}", 123);
        LOGGER.debug("Some messange {}", 123);
        LOGGER.info("Some messange {}", 123);
        LOGGER.warn("Some messange {}", 123);
        LOGGER.error("Some messange {}", 123);

        LoggerLoop.log();

//        try {
//            method1();
//        } catch (Exception ex) {
//            LOGGER.error("Exception was thrown", ex);
//        }
    }

    private static void method1() {
        method2();
    }
    private static void method2() {
        method3();
    }
    private static void method3() {
        method4();
    }
    private static void method4() {
        method5();
    }
    private static void method5() {
        throw new RuntimeException("Throwing some exception!");
    }
}
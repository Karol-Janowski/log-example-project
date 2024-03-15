package pl.zajavka;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.IntStream;

@Slf4j
public class LoggerLoop {


    private static final Map<Integer, Consumer<Integer>> ACTIONS = Map.of(
            0, i -> log.debug("some debug message, counter {}", i),
            1, i -> log.info("some debug message, counter {}", i),
            2, i -> log.warn("some debug message, counter {}", i),
            3, i -> log.error("some debug message, counter {}", i)

    );

    public static void log() {
        IntStream.rangeClosed(0, 100_000_000)
                .map(i -> i % 4)
                .forEach(key -> Optional.ofNullable(ACTIONS.get(key))
                        .orElseThrow(() -> new RuntimeException("Case not handled"))
                        .accept(key)
                );
    }
}

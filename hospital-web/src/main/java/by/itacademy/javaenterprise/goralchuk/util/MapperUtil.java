package by.itacademy.javaenterprise.goralchuk.util;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MapperUtil {

    public static <R, E> List<R> convertList(List<E> list, Function<E, R> converter) {
        return list.stream().map(e -> converter.apply(e)).collect(Collectors.toList());
    }
}

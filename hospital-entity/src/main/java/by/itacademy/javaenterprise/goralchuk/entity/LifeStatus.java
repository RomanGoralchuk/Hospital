package by.itacademy.javaenterprise.goralchuk.entity;

import lombok.extern.slf4j.Slf4j;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Slf4j
public enum LifeStatus {
    ALIVE("alive"),
    DEAD("dead");
    private final String code;

    LifeStatus(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    @Converter
    public static class LifeStatusConverter
            implements AttributeConverter<LifeStatus, String> {

        @Override
        public String convertToDatabaseColumn(LifeStatus lifeStatus) {
            if (lifeStatus == null) {
                return null;
            }
            return lifeStatus.getCode();
        }

        @Override
        public LifeStatus convertToEntityAttribute(String string) {
            if (string == null) {
                return null;
            }
            try {
                return Stream.of(LifeStatus.values())
                        .filter(el -> el.getCode().equals(string))
                        .findFirst()
                        .orElseThrow(() -> new IllegalArgumentException("Bad argument converter"));
            } catch (Exception e) {
                log.error(e.getMessage(), e);
                return null;
            }
        }
    }
}

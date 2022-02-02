package by.itacademy.javaenterprise.goralchuk.entity;

import lombok.Getter;

public enum Specialization {
    THERAPIST("THERAPIST"),
    ALLERGIST("ALLERGIST"),
    DERMATOLOGIST("DERMATOLOGIST"),
    CARDIOLOGIST("CARDIOLOGIST"),
    GYNECOLOGIST("GYNECOLOGIST"),
    ENDOCRINOLOGIST("ENDOCRINOLOGIST"),
    GASTROENTEROLOGIST("GASTROENTEROLOGIST"),
    NEPHROLOGIST("NEPHROLOGIST"),
    UROLOGIST("UROLOGIST"),
    PULMONOLOGIST("PULMONOLOGIST"),
    OTOLARYNGOLOGIST("OTOLARYNGOLOGIST"),
    NEUROLOGIST("NEUROLOGIST"),
    PSYCHIATRIST("PSYCHIATRIST"),
    ONCOLOGIST("ONCOLOGIST"),
    RADIOLOGIST("RADIOLOGIST"),
    RHEUMATOLOGIST("RHEUMATOLOGIST"),
    GENERAL_SURGEON("GENERAL_SURGEON("),
    ORTHOPEDIC_SURGEON("ORTHOPEDIC_SURGEON"),
    CARDIAC_SURGEON("CARDIAC_SURGEON"),
    ANESTHESIOLOGIST("ANESTHESIOLOGIST");

    private final String code;

    Specialization (String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}

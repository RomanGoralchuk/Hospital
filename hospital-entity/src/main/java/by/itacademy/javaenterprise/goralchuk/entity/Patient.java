package by.itacademy.javaenterprise.goralchuk.entity;

import by.itacademy.javaenterprise.goralchuk.entity.security.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @Column(name = "patient_id")
    @GeneratedValue(generator = "doctor-generator")
    @GenericGenerator(name = "doctor-generator",
            parameters = @org.hibernate.annotations.Parameter(name = "prefix", value = "P"),
            strategy = "by.itacademy.javaenterprise.goralchuk.generatorid.IdGenerator")
    private String id;
    @Embedded
    private UserInfo userInfo;
/*    private User user;*/
}
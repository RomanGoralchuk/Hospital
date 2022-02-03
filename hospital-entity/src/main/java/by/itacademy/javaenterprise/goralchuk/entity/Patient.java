package by.itacademy.javaenterprise.goralchuk.entity;

import by.itacademy.javaenterprise.goralchuk.entity.security.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OptimisticLocking;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@OptimisticLocking
@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(generator = "patient-generator")
    @GenericGenerator(name = "patient-generator",
            parameters = @org.hibernate.annotations.Parameter(name = "prefix", value = "P"),
            strategy = "by.itacademy.javaenterprise.goralchuk.generatorid.IdGenerator")
    private String patient_id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "username")
    private User username;
    @Embedded
    private UserInfo userInfo;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "patient")
    private List<Complains> complainsList;
}
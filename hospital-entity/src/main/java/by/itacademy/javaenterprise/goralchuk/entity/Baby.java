package by.itacademy.javaenterprise.goralchuk.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OptimisticLocking;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@OptimisticLocking
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "baby")
public class Baby {
    @Id
    private String name;
    private String surname;
}

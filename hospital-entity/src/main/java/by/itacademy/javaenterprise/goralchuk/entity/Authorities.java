package by.itacademy.javaenterprise.goralchuk.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OptimisticLocking;

import javax.persistence.*;

@Data
@Entity
@OptimisticLocking
@NoArgsConstructor
@Table(name = "authorities")
public class Authorities {
    @Id
    @Column(name = "authorities_id")
    private Long id;
    @Column(unique = true)
    private String username;
    @Enumerated
    private RoleUser role;
}

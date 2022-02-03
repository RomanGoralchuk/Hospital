package by.itacademy.javaenterprise.goralchuk.dao;

import by.itacademy.javaenterprise.goralchuk.entity.Complains;
import by.itacademy.javaenterprise.goralchuk.entity.security.Authorities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComplainsRepository extends JpaRepository<Complains, Long> {

    @Query("from Complains where patient_id =:patientId")
    List<Complains> findAllComplainsByPatientId(@Param("patientId") String patientId);
}

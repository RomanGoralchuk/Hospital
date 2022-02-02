package by.itacademy.javaenterprise.goralchuk.dao;

import by.itacademy.javaenterprise.goralchuk.entity.security.Authorities;
import by.itacademy.javaenterprise.goralchuk.entity.security.AuthoritiesKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthoritiesRepository extends JpaRepository<Authorities, AuthoritiesKey> {

    @Query("from Authorities where username = :username")
    List<Authorities> findAuthoritiesByUserId(@Param("username") String username);

    @Modifying
    @Query("delete from Authorities where username = :username")
    void deleteAuthoritiesByUserId(@Param("username") String username);
}

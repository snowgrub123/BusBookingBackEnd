package com.devteria.identityservice.repository;

import com.devteria.identityservice.entity.AllCode;
import com.devteria.identityservice.entity.Chair;
import com.devteria.identityservice.entity.ConfirmationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationToken,Integer> {
    Optional<ConfirmationToken> findByToken(String token);
}

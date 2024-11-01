package com.GAMF.Mozi;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UsersRepository extends CrudRepository<UsersModell, Integer>
{
    Optional<UsersModell> findByEmail(String email);
}

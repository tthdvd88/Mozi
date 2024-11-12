package com.GAMF.Mozi;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UsersRepository extends CrudRepository<User, Integer>
{
    Optional<User> findByEmail(String email);
}

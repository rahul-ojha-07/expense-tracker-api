package io.github.rahulojha07.expensetrackerapi.repositories;

import io.github.rahulojha07.expensetrackerapi.domain.User;
import io.github.rahulojha07.expensetrackerapi.exceptions.EtAuthException;

public interface UserRepository {

    Integer create(String firstName, String lastName, String email, String password) throws EtAuthException;
    User findByEmailAndPassword(String email, String password) throws EtAuthException;
    Integer getCountByEmail(String email);
    User findById(Integer userId);
}

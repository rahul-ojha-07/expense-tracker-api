package io.github.rahulojha07.expensetrackerapi.services;

import io.github.rahulojha07.expensetrackerapi.domain.User;
import io.github.rahulojha07.expensetrackerapi.exceptions.EtAuthException;

public interface UserService {
    User validateUser(String email,String password) throws EtAuthException;
    User registerUser(String firstName, String lastName, String email, String password) throws EtAuthException;
}

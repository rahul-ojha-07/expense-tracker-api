package io.github.rahulojha07.expensetrackerapi.services;

import io.github.rahulojha07.expensetrackerapi.domain.User;
import io.github.rahulojha07.expensetrackerapi.exceptions.EtAuthException;
import io.github.rahulojha07.expensetrackerapi.repositories.UserRepository;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.regex.Pattern;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private static Logger logger;
    @Autowired
    UserRepository userRepository;

    @Override
    public User validateUser(String email, String password) throws EtAuthException {
        if (email != null) email = email.toLowerCase();
        return userRepository.findByEmailAndPassword(email,password);
    }

    @Override
    public User registerUser(String firstName, String lastName, String email, String password) throws EtAuthException {
        Pattern pattern = Pattern.compile("^(.+)@(.+)$");
        if (email != null) {
            email = email.toLowerCase();
        }
        if (!pattern.matcher(email).matches()) {
            throw new EtAuthException("Invalid Email Format!");
        }
//        logger.info(">>>>>>>>> %s", email);
        Integer count =  userRepository.getCountByEmail(email);

        if (count > 0) {
            throw new EtAuthException("Email Already in Use!");
        }

        Integer userId = userRepository.create(firstName,lastName,email,password);
        return userRepository.findById(userId);
    }
}

package org.patika.advertproject;

import lombok.RequiredArgsConstructor;
import org.patika.advertproject.model.entity.User;
import org.patika.advertproject.repository.UserRepository;
import org.patika.advertproject.service.UserService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SampleDataInitiliazer implements ApplicationRunner {

    private final UserRepository userRepository;
    private final UserService userService;

    @Override
    public void run(ApplicationArguments args) {



        User adminUser = new User("admin-user", "adminuser@mail.com", "pass1234");
        if (!userRepository.existsByUsername(adminUser.getUsername())) {
            userService.signup(adminUser, true);
        }

        User sampleUser = new User("sample-user", "sampleuser@mail.com", "pass1234");
        if (!userRepository.existsByUsername(sampleUser.getUsername())) {
            userService.signup(sampleUser, false);
        }

    }

}

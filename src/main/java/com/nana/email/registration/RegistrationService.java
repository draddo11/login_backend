package com.nana.email.registration;

import com.nana.email.appuser.AppUser;
import com.nana.email.appuser.AppUserRole;
import com.nana.email.appuser.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final AppUserService appUserService;
    private final EmailValidator emailValidator;
    
    public String register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.test(request.getEmail());
        if (!isValidEmail){
            throw new IllegalStateException("email not valid");
        }
        return appUserService.signUpUser(
                new AppUser(
                    request.getFirstname(),
                        request.getFirstname(),
                        request.getLastname(),
                        request.getPassword(),
                        AppUserRole.USER

                )
        );
    }
}

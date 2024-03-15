package broteam.myfap.backend.Service.Auth;


import broteam.myfap.backend.Exception.NotFoundException;
import broteam.myfap.backend.Models.Role;
import broteam.myfap.backend.Models.User.User;
import broteam.myfap.backend.Repository.User.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws NotFoundException {
        User user = userRepository.findByUserName(username)
                .orElseThrow(
                        () -> new NotFoundException("User " + username + " not found"));

        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getUserPassword(), mapRolesToAuthorities(user.getRoles()));
    }
    private Collection<GrantedAuthority> mapRolesToAuthorities(List<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName().toString())).collect(Collectors.toList());
    }
}

package skoczny.jedynak.poradnik.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.Collection;

@Service("assembler")
public class Assembler {
    @Transactional
    public User buildUserFromEntity(skoczny.jedynak.poradnik.model.User user) {
        String username = user.getName();
        String password = user.getPassword();
        boolean enabled = true;

        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        if (user.getRole().getRoleName().equals("admin")) {
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        } else {
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        }
        return new User(username, password, enabled, enabled, enabled, enabled, authorities);
    }
}

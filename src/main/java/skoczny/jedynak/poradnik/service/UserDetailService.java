package skoczny.jedynak.poradnik.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import skoczny.jedynak.poradnik.model.User;

/**
 * Created by Damian on 2016-01-12.
 */
@Service("userDetailsService")
public class UserDetailService implements UserDetailsService {

    @Autowired
    @Qualifier(value = "poradnikFarmaceutycznyServiceMySQL")
    private PoradnikFarmaceutycznyService service;

    @Autowired
    private Assembler assembler;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = service.getUserByUserName(username);
        if (user == null)
            throw new UsernameNotFoundException("User not found");
        return assembler.buildUserFromEntity(user);

    }

    public PoradnikFarmaceutycznyService getService() {
        return service;
    }

    public void setService(PoradnikFarmaceutycznyService service) {
        this.service = service;
    }

    public Assembler getAssembler() {
        return assembler;
    }

    public void setAssembler(Assembler assembler) {
        this.assembler = assembler;
    }
}

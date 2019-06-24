package ro.tudoran.AutoMarketEshop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserRegister {
    @Autowired
    JdbcTemplate jdbcTemplate;


    Logger logger = LoggerFactory.getLogger(UserRegister.class);

    public void saveUser(User user) {

        logger.info("S-a primit spre salvare in BD user-ul: "+user.toString());
        Object[] params = new Object[5];
        params[0] = user.getName();
        params[1] = user.getUsername();
        params[2] = user.getEmail();
        params[3] = user.getPassword();
        params[4] = user.getAddress();

        jdbcTemplate.update("insert into user values (null,?,?,?,?,?);", params);

    }
}

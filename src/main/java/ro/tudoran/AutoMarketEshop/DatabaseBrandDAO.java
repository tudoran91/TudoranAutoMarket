package ro.tudoran.AutoMarketEshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DatabaseBrandDAO implements BrandDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Brand> findAll() {
        return jdbcTemplate.query("select * from brand", new BrandMapper());

    }
}

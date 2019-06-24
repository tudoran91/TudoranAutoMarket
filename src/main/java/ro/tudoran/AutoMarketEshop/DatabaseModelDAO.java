package ro.tudoran.AutoMarketEshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DatabaseModelDAO implements ModelDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Model> findAll() {
        return jdbcTemplate.query("select * from model", new ModelMapper());
    }

    @Override
    public List<Model> findAllByBrandId(Integer brandId) {
        return jdbcTemplate.query("select * from model where brand_id=" + brandId, new ModelMapper());
    }

    @Override
    public Model findById(Integer modelId) {
        return jdbcTemplate.query("select * from model where id="+ modelId, new ModelMapper()).get(0);
    }
}

package ro.tudoran.AutoMarketEshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

public interface BrandDAO {
    public List<Brand> findAll();
}

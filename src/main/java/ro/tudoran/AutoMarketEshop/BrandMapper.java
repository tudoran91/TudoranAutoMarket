package ro.tudoran.AutoMarketEshop;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BrandMapper implements RowMapper<Brand> {
    @Override
    public Brand mapRow(ResultSet resultSet, int i) throws SQLException {

        Brand brand = new Brand();
        brand.setId(resultSet.getInt("id"));
        brand.setName(resultSet.getString("name"));
        brand.setDescription(resultSet.getString("description"));
        brand.setPhoto(resultSet.getString("photo"));

        return brand;
    }
}

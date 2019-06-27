package ro.tudoran.AutoMarketEshop;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ModelMapper implements RowMapper<Model> {
    @Override
    public Model mapRow(ResultSet resultSet, int i) throws SQLException {

        Model model = new Model();
        model.setName(resultSet.getString("name"));
        model.setDescription(resultSet.getString("description"));
        model.setPrice(resultSet.getBigDecimal("price"));
        model.setPhoto(resultSet.getString("photo"));
        model.setId(resultSet.getInt("id"));
        model.setBrandID(resultSet.getInt("brand_id"));
        return model;
    }
}

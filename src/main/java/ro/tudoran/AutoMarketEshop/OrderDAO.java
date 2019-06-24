package ro.tudoran.AutoMarketEshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class OrderDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public Integer createNewOrder(Integer userId) {
        String sql = "insert into order values (null,?);";
        Object[] params = new Object[1];
        params[0] = userId;
        jdbcTemplate.update(sql,params);
        Integer orderId = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID() as id;", Integer.class);
        return orderId;
    }

    public void createNewOrderLine(Integer orderId,
                                   Integer modelId,
                                   BigDecimal price) {
        String sql = "insert into order_lines values (null,?,?,?)";
        Object[] params = new Object[4];
        params[0] = orderId;
        params[1] = price;
        params[2] = modelId;
        jdbcTemplate.update(sql,params);
    }
}

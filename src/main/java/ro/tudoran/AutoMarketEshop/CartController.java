package ro.tudoran.AutoMarketEshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CartController {

    @Autowired
    CartSession cartSession;

    @Autowired
    SecuritySession securitySession;

    @Autowired
    DatabaseModelDAO databaseModelDAO;

    @Autowired
    OrderDAO orderDAO;

    @GetMapping("add-to-cart")
    public String addToCart(
            @RequestParam("model_id") Integer modelId) {
        List<Integer> ids = cartSession.getmodelIds();

        Integer brandId = databaseModelDAO.findById(modelId).getBrandID();

        ids.add(modelId);
        cartSession.setmodelIds(ids);

        return "redirect:/model?brand_id=" + brandId;
    }

    @GetMapping("send-order")
    public String sendOrder() {
        List<Integer> ids = cartSession.getmodelIds();
        Integer orderId = orderDAO.createNewOrder(securitySession.getUserId());
        for(Integer id: ids) {
            orderDAO.createNewOrderLine(
                    orderId,
                    id,
                    databaseModelDAO.findById(id).price
            );
        }
        cartSession.setmodelIds(new ArrayList<>());

        return "redirect:/brand";
    }
}

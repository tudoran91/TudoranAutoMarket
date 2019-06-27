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
    SecuritySession securitySession;

    @Autowired
    DatabaseModelDAO databaseModelDAO;

    @Autowired
    OrderDAO orderDAO;

    @GetMapping("add-to-cart")
    public String addToCart(
            @RequestParam("model_id") Integer modelId) {


        Integer brandId = databaseModelDAO.findById(modelId).getBrandID();


        orderDAO.createNewOrder(securitySession.getUserId(), modelId);
        return "redirect:/model?brand_id=" + brandId;
    }
}

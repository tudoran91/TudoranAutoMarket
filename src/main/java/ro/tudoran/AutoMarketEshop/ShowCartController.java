package ro.tudoran.AutoMarketEshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ShowCartController {

    @Autowired
    CartSession cartSession;

    @Autowired
    DatabaseModelDAO databaseModelDAO;

    @Autowired
    DatabaseBrandDAO databaseBrandDAO;




    @GetMapping("/show-cart")
    public ModelAndView showCart(){

        ModelAndView modelAndView = new ModelAndView("show-cart");

        List<Integer> modelIdsFromCart = cartSession.getmodelIds();
        List<Model> modelList = new ArrayList<>();
        for(Integer mId: modelIdsFromCart) {
            Model m = databaseModelDAO.findById(mId);
            modelList.add(m);
        }
        modelAndView.addObject("model",modelList);
        return modelAndView;
    }
}

package ro.tudoran.AutoMarketEshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class EshopController {


    @Autowired
    SecuritySession securitySession;

    @Autowired
    UserRegister userRegister;

    @Autowired
    DatabaseModelDAO databaseModelDAO;

    @Autowired
    DatabaseBrandDAO databaseBrandDAO;


    @GetMapping("/index")
    public ModelAndView index() {


        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("logged",securitySession.isUserLogged());
        return modelAndView;
    }

    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView("login");
        return modelAndView;
    }

    @GetMapping("/logout")
    public ModelAndView logout() {
        securitySession.userNotLogged();
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }

    @GetMapping("/register")
    public ModelAndView register() {
        ModelAndView modelAndView = new ModelAndView("register");
        return modelAndView;
    }

    @GetMapping("/brand")
    public ModelAndView brand() {
        if (!securitySession.isUserLogged()) {
            return new ModelAndView("redirect:/login");
        }
        ModelAndView modelAndView = new ModelAndView("brand");
        modelAndView.addObject("logged", securitySession.isUserLogged());
        List<Brand> brandList = databaseBrandDAO.findAll();
        modelAndView.addObject("brand", brandList);
        modelAndView.addObject("nr_model",0 );
        return modelAndView;
    }

    @GetMapping("/model")
    public ModelAndView showAll(@RequestParam("brand_id") Integer brandId) {
        if (!securitySession.isUserLogged()) {
            return new ModelAndView("redirect:/login");

        }
        ModelAndView modelAndView = new ModelAndView("model");
        modelAndView.addObject("logged", securitySession.isUserLogged());
        List<Model> modelList = databaseModelDAO.findAllByBrandId(brandId);
        modelAndView.addObject("model", modelList);
        modelAndView.addObject("nr_model",0 );
        return modelAndView;
    }

    @GetMapping("/order")
    public ModelAndView order() {
        ModelAndView modelAndView = new ModelAndView("order");
        return modelAndView;
    }

    @GetMapping("/register-action")
    public String create(
            @RequestParam("name") String name,
            @RequestParam("username") String username,
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            @RequestParam("address") String address

    ) {

        User user = new User();
        user.setName(name);
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        user.setAddress(address);

        userRegister.saveUser(user);

        return "redirect:/login";
    }

}
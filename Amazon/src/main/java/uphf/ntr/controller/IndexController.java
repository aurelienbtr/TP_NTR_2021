package uphf.ntr.controller;


import uphf.ntr.model.Client;
import uphf.ntr.repository.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {

    @Autowired
    private ClientRepository clientRepository;

    @RequestMapping("/")
    public String home(HttpServletRequest request, Model model) {
        return "index";
    }
}

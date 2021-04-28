package uphf.ntr.controller;

import uphf.ntr.model.*;
import uphf.ntr.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ProduitRepository produitRepository;

    @GetMapping(path="/registration")
    public String getRegistrationForm(){
        return "registration";
    }

    @RequestMapping(path="/registration", method = RequestMethod.POST)
    public String saveUserForm(@RequestParam String nom, @RequestParam String prenom, @RequestParam String password,@RequestParam int solde, @RequestParam Boolean actif, @RequestParam String confirmPassword, @RequestParam int bankAccount, Model model){
        Client clientExist = clientRepository.findClientByName(nom);
        if(!password.equals(confirmPassword)){
            model.addAttribute("passwordConfirm", "password_not_equals");
            return "user/registration";
        }

        Client newClient = new Client(nom, prenom,password, bankAccount);
        clientRepository.save(newClient);
        return "redirect:/";
    }
    

    @GetMapping(path = "/profile")
    public String show(HttpServletRequest request, Model model) {
        model.addAttribute("list_produit", produitRepository.findAllByOwner((Client) request.getSession().getAttribute("current_client")));
        return "show";
    }


}

package uphf.ntr.BanqueTomcat.service;
import uphf.ntr.BanqueTomcat.model.User;
import uphf.ntr.BanqueTomcat.model.Users;
import uphf.ntr.BanqueTomcat.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service("userService")
public class UserService {

    public UserService(){

    }

    @Autowired
    public UserService(userRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    public User findUserByname(String name) {
        return userRepository.findByName(name);
    }

    public List<User> listAll() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    public Users findAll() {
        List<User> users = (List<User>) userRepositoryCrudJson.findAll();
        Users myUsers = new Users();
        myUsers.setUsers(users);

        return myUsers;
    }

    public void saveBalance(int id, float balance){
        User user = userRepository.findById(id);
        float actual_balance = user.getBalance();
        user.setBalance(actual_balance + balance);
        userRepository.saveAndFlush(user);
    }

    public void saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        Role userRole = roleRepository.findByRole("USER");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(user);
    }

}

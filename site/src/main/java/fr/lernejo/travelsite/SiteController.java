package fr.lernejo.travelsite;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class SiteController {

    public List<User> myUsers = new ArrayList<User>();

    @PostMapping(value = "/inscription")
    public void addUser(@RequestBody User user) {
        myUsers.add(user);
    }
    @GetMapping(value = "/users")
    public List<User> getUsers() {
        return myUsers;
    }

    @GetMapping(value = "travels")
    public List<Destination> getTravels(@RequestParam(name = "userName") String username) {
        List<Destination> myDest = new ArrayList<Destination>();
        for (User user : myUsers){
            if (user.userName().equals(username)) {
                myDest.add(new Destination("Nice", 35.2));
                myDest.add(new Destination("Marseille", 31.5));
                return myDest;
            }
        }
        return myDest;

    }
}

package demo.mockito;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @RequestMapping("/greeting")
    public @ResponseBody
    String greeting() {
        return service.greet();
    }

    @RequestMapping("/findById/{id}")
    public @ResponseBody
    User findById(@PathVariable("id") String id) {
        User user = service.findById(id);
        if (user == null) {
            throw new UserNotFoundException();
        }
        return user;
    }

    @RequestMapping("/throwsNotTreatedException")
    public void throwsNotTreatedException() {
        throw new IllegalArgumentException("Illegal Argument", new Exception("Not Treated Exception"));
    }

    @SuppressWarnings("SameReturnValue")
    @RequestMapping("/findById2/{id1}/{id3}")
    public @ResponseBody
    User findByIdWithMoreParameters(@PathVariable("id1") String id1, String id2, @PathVariable("id3") String id3) {
        return null;
    }

    @RequestMapping("/all")
    public @ResponseBody
    List<User> findAll() {
        return service.findAll();
    }

    @RequestMapping("/allIds")
    public @ResponseBody
    List<String> findAllIds() {
        return service.findAllIds();
    }

    @PostMapping("/create")
    public void create(@RequestBody User userCreate) {
        service.create(userCreate);
    }

    @PostMapping("/update")
    public void update(@RequestBody User userUpdate) {
        service.update(userUpdate);
    }

}


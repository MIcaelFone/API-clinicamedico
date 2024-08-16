package planner_travel.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/helloword")
public class Hellocontroller {
   @GetMapping
    public String HelloWord(){
       return "Hello Word!";
    }
}

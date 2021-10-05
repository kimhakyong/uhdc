package com.example.uhdc.method;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/method")
public class MethodController {
    @GetMapping("/getRequestParam")
    public Person getRequestParam(@RequestParam String name, @RequestParam String address) {
        Person person = new Person();

        person.setName(name);
        person.setAddress(address);

        return person;
    }

    @PostMapping("/postRequestParam")
    public Person postRequestParam(@RequestParam String name, @RequestParam String address) {
        Person person = new Person();

        person.setName(name);
        person.setAddress(address);

        return person;
    }

    @PostMapping("/postRequestBody")
    public Person postRequestBody(@RequestBody String name) {
        Person person = new Person();

        person.setName(name);
//        person.setAddress(address);

        return person;
    }
}

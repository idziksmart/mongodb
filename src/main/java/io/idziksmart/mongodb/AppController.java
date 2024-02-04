package io.idziksmart.mongodb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AppController {
    private AppService service;

    public AppController(AppService service) {
        this.service = service;
    }

    @GetMapping("/subscriptions/all")
    public List<Subscription> getAll() {
        return service.getAll();
    }
}

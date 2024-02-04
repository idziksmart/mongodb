package io.idziksmart.mongodb;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppService {
   private AppRepository repository;

    public AppService(AppRepository repository) {
        this.repository = repository;
    }

    public List<Subscription> getAll() {
        return repository.findAll();
    }
}

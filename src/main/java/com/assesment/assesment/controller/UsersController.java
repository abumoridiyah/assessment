package com.assesment.assesment.controller;

import ch.qos.logback.core.net.server.Client;
import com.assesment.assesment.Repository.UserRepository;
import com.assesment.assesment.model.UserResponse;
import com.assesment.assesment.model.Users;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;

@RestController
@RequestMapping("/app")
public class UsersController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/user")
    public List<Users> getAllUsers(){
        return userRepository.findAll();
    }
    @PostMapping("/add-users")
    public void fetchUsers(){
        List<Users> u = userRepository.findAll();

        // getting list of records if the list is empty
        if(u.isEmpty()){
            Client client = getClient();
            LinkedHashMap map = new LinkedHashMap();
            WebTarget base = client.target(" https://jsonplaceholder.typicode.com/users");
            Response response = base.request(javax.ws.rs.core.MediaType.APPLICATION_JSON)
                    .get();
            String results = response.readEntity(String.class);
            client.close();
            UserResponse output = new UserResponse();
            Users s = new Users();
            s.setEmail(output.getEmail());
            s.setUsername(output.getUsername());
            s.setPhone(output.getPhone());
            s.setAddress(output.getAddress());
            userRepository.save(s);

        }
    }

    public Client getClient() {
        Client client = ClientBuilder.newClient();
        return client;
    }
}

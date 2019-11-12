package com.miniproject.springbatch.batch;

import com.miniproject.springbatch.model.UserCSV;
import com.miniproject.springbatch.model.UserDTO;
import com.miniproject.springbatch.repository.UserRepository;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class DBWriter implements ItemWriter<UserCSV> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void write(List<? extends UserCSV> users) throws Exception {

        System.out.println("Data Saved for Users: " + users);
       
        
        for(int i=0;i<users.size();i++) {
        	UserDTO u1=new UserDTO(i,users.get(i).getFirst(),users.get(i).getLast(),users.get(i).getGpa(),LocalDate.of(LocalDate.now().getYear()-users.get(i).getAge(), 01, 01));
        	userRepository.save(u1);
        }
        
        
        
        
        
      //  userRepository.save(users);
    }
}

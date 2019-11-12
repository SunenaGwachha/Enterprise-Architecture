package com.miniproject.springbatch.batch;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.miniproject.springbatch.model.UserCSV;

@Component
public class Processor implements ItemProcessor<UserCSV, UserCSV> {

   

    public Processor() {
       
    }

    @Override
    public UserCSV process(UserCSV user) throws Exception {
        user.setFirst(user.getFirst().toUpperCase());
        return user;
    }
}

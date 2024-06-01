// WishMessageGenerator.java
package com.nt.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class WishMessageGenerator {
    
    private final LocalDateTime currentTime;

    @Autowired
    public WishMessageGenerator(LocalDateTime currentTime) {
        this.currentTime = currentTime;
    }

    public String generateWishMessage(String user) {
        int hour = currentTime.getHour();
        
        if(hour < 12)
            return "Good Morning, " + user + "!";
        else if(hour < 16)
            return "Good Afternoon, " + user + "!";
        else if(hour < 20)
            return "Good Evening, " + user + "!";
        else
            return "Good Night, " + user + "!";
    }
}

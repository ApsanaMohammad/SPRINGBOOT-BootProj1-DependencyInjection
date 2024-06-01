// BootProj1DependencyInjectionApplication.java
package com.nt;


import java.io.PrintStream;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.nt.beans.WishMessageGenerator;

@SpringBootApplication
public class BootProj1DependencyInjectionApplication {
    
    @Bean(name="currentTime")
    public java.time.LocalDateTime createLocalDateTime () {
        return java.time.LocalDateTime.now();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ApplicationContext ctx = SpringApplication.run(BootProj1DependencyInjectionApplication.class, args);
        
        WishMessageGenerator gen = ctx.getBean(WishMessageGenerator.class);
        System.out.println("Enter your Beautiful name: ");
        String user = sc.next();
        System.out.println(gen.generateWishMessage(user));
        ((PrintStream) ctx).close();
        sc.close();
    }
}

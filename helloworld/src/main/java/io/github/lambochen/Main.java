package io.github.lambochen;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ChatClient.Builder builder) {
        return args -> {
            ChatClient client = builder.build();
            Scanner scanner = new Scanner(System.in);
            System.out.println("WELCOME TO THE AI ASSISTANT！");
            while (true) {
                System.out.print("PLEASE ENTER：");
                String prompt = scanner.nextLine();
                System.out.println("AI: " + client.prompt(prompt).call().content());
            }
        };
    }
}
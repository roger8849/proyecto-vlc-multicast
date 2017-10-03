package com.javeriana.vlcmulticast.server;

import static java.lang.System.exit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.javeriana.vlcmulticast.server.util.MulticastProperties;

@SpringBootApplication
public class Startup implements CommandLineRunner {

  @Autowired
  MulticastProperties globalProperties;

  public static void main(String[] args) throws Exception {

    SpringApplication app = new SpringApplication(Startup.class);
    app.run(args);

  }

  // Put your logic here.
  @Override
  public void run(String... args) throws Exception {
    System.out.println(globalProperties.getInetAddress());
    exit(0);
  }
}

package com.javeriana.vlcmulticast.server;

import static java.lang.System.exit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.javeriana.vlcmulticast.server.util.MulticastProperties;

@SpringBootApplication
public class Startup implements CommandLineRunner {

  public static final Logger logger = LoggerFactory.getLogger(Startup.class);

  @Autowired
  MulticastProperties multicastProperties;

  public static void main(String[] args) throws Exception {

    SpringApplication app = new SpringApplication(Startup.class);
    app.run(args);

  }

  @Override
  public void run(String... args) throws Exception {
    System.out.println(multicastProperties.getInetAddress());
    logger.debug("TEST debug");
    exit(0);
  }
}

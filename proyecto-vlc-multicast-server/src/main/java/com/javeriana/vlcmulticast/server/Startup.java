package com.javeriana.vlcmulticast.server;

import static java.lang.System.exit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.javeriana.vlcmulticast.server.dto.MulticastMessage;
import com.javeriana.vlcmulticast.server.service.MulticastService;
import com.javeriana.vlcmulticast.server.util.MulticastProperties;

@SpringBootApplication
public class Startup implements CommandLineRunner {

  public static final Logger LOG = LoggerFactory.getLogger(Startup.class);

  @Autowired
  MulticastProperties multicastProperties;

  @Autowired
  MulticastService multicastService;

  public static void main(String[] args) throws Exception {

    SpringApplication app = new SpringApplication(Startup.class);
    app.run(args);

  }

  @Override
  public void run(String... args) throws Exception {
    MulticastMessage multicastMessage = this.multicastService.askAndReceiveVlcConfiguration();
    LOG.debug("multicast message received: {}", multicastMessage);
    exit(0);
  }
}

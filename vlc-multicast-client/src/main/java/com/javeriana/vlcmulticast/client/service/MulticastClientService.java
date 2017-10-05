package com.javeriana.vlcmulticast.client.service;

import java.io.IOException;

import com.javeriana.vlcmulticast.client.dto.MulticastMessage;

public interface MulticastClientService {

  MulticastMessage listenForRequests() throws IOException;

}

package com.javeriana.vlcmulticast.client.service;

import com.javeriana.vlcmulticast.client.dto.MulticastMessage;

public interface MulticastService {

  MulticastMessage askAndReceiveVlcConfiguration() throws Exception;

}

package com.javeriana.vlcmulticast.server.service.impl;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javeriana.vlcmulticast.server.dto.MulticastMessage;
import com.javeriana.vlcmulticast.server.enumeration.MessageType;
import com.javeriana.vlcmulticast.server.service.MulticastService;
import com.javeriana.vlcmulticast.server.util.MulticastProperties;
import com.javeriana.vlcmulticast.server.util.ObjectConverter;

@Service
public class DefaultMulticastService implements MulticastService {
  public static final Logger LOG = LoggerFactory.getLogger(DefaultMulticastService.class);

  @Autowired
  private MulticastProperties multicastProperties;

  /* (non-Javadoc)
   * @see com.javeriana.vlcmulticast.server.service.impl.MulticastService#askAndReceiveVlcConfiguration()
   */
  @Override
  public MulticastMessage askAndReceiveVlcConfiguration() throws Exception {
    this.askForConfiguration();
    return null;
  }

  private void askForConfiguration() throws Exception {
    MulticastMessage message = new MulticastMessage(UUID.randomUUID(), MessageType.ASKING, "");
    LOG.debug("Init message send succesfuly sent: {}", message);
    DatagramSocket socket = new DatagramSocket();
    try {
      InetAddress multicastAddress = InetAddress.getByName(multicastProperties.getInetAddress());
      byte[] dataMessage = ObjectConverter.fromMessageToByteData(message);
      DatagramPacket msgPacket = new DatagramPacket(dataMessage, dataMessage.length,
          multicastAddress, Integer.parseInt(multicastProperties.getInetPort()));
      socket.send(msgPacket);
      LOG.debug("Message succesfuly sent: {}", message);
    } catch (Exception e) {
      LOG.debug(e.getMessage());
      throw e;

    } finally {
      socket.close();
    }

  }

}

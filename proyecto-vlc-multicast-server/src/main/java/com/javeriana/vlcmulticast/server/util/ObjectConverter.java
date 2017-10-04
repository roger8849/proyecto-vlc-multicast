package com.javeriana.vlcmulticast.server.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.javeriana.vlcmulticast.server.dto.MulticastMessage;

public class ObjectConverter {

  public static final Logger LOG = LoggerFactory.getLogger(ObjectConverter.class);

  public static byte[] fromMessageToByteData(MulticastMessage message) throws IOException {
    LOG.debug("Converting message to byte data: {}", message);
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    ObjectOutputStream os = new ObjectOutputStream(outputStream);
    os.writeObject(message);
    byte[] byteArray = outputStream.toByteArray();
    LOG.debug("Message successfuly converted. {}", byteArray);
    return byteArray;
  }

  public static MulticastMessage fromByteDataToMessage(byte[] data)
      throws IOException, ClassNotFoundException {
    LOG.debug("Converting byte to multicast Message: {}", data);
    ByteArrayInputStream in = new ByteArrayInputStream(data);
    ObjectInputStream is = new ObjectInputStream(in);
    MulticastMessage multicastObject = (MulticastMessage) is.readObject();
    LOG.debug("Multicast object transformed: {}", multicastObject);
    return multicastObject;
  }

  public static String fromObjectToJsonString(Object object)
      throws JsonGenerationException, JsonMappingException, IOException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.writeValueAsString(object);
  }

  private ObjectConverter() {}

}

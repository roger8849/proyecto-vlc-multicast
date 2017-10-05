package com.javeriana.vlcmulticast.client.util;

import java.io.IOException;

import org.apache.commons.lang3.SerializationUtils;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.javeriana.vlcmulticast.client.dto.MulticastMessage;

public class ObjectConverter {

  public static final Logger LOG = LoggerFactory.getLogger(ObjectConverter.class);

  public static byte[] fromMessageToByteData(MulticastMessage message) throws IOException {
    // LOG.debug("Converting message to byte data: {}", message);
    // ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    // ObjectOutputStream os = new ObjectOutputStream(outputStream);
    // os.writeObject(message);
    // byte[] byteArray = outputStream.toByteArray();
    // LOG.debug("Message successfuly converted. {}", byteArray);
    // return byteArray;
    return SerializationUtils.serialize(message);
  }

  public static MulticastMessage fromByteDataToMessage(byte[] data) {
    // LOG.debug("Converting byte to multicast Message: {}", data);
    // ByteArrayInputStream in = new ByteArrayInputStream(data);
    // ObjectInputStream is = null;
    // try {
    // is = new ObjectInputStream(in);
    // } catch (IOException e) {
    // }
    // MulticastMessage multicastObject = null;
    // try {
    // multicastObject = (MulticastMessage) is.readObject();
    // } catch (ClassNotFoundException | IOException e) {
    // }
    // LOG.debug("Multicast object transformed: {}", multicastObject);
    // return multicastObject;
    return SerializationUtils.deserialize(data);
  }

  public static String fromObjectToJsonString(Object object)
      throws JsonGenerationException, JsonMappingException, IOException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.writeValueAsString(object);
  }

  private ObjectConverter() {}

}

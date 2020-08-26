package falcon_9;

import krpc.client.Connection;
import krpc.client.RPCException;
import krpc.client.services.KRPC;

import java.io.IOException;

public class Falcon_9 {
  public static void main(String[] args) throws IOException, RPCException {
    try (Connection connection = Connection.newInstance()) {
      KRPC krpc = KRPC.newInstance(connection);
      System.out.println("Connected to kRPC version " + krpc.getStatus().getVersion());
    }
  }
}
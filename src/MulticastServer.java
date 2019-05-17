import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class MulticastServer {

   public static void sendUDPMessage(String message,
   String ipAddress, int port) throws IOException {
      DatagramSocket socket = new DatagramSocket();
      InetAddress group = InetAddress.getByName(ipAddress);
      byte[] msg = message.getBytes();
      DatagramPacket packet = new DatagramPacket(msg, msg.length,
         group, port);
      socket.send(packet);
      socket.close();
   }

   public static void main(String[] args) throws IOException {
       String ipAddress = "239.192.0.0";
    int port = 9875;
    sendUDPMessage("This is a multicast messge", ipAddress,
              port);
      sendUDPMessage("This is the second multicast messge",
         ipAddress, port);
      sendUDPMessage("This is the third multicast messge",
         ipAddress, port);
      sendUDPMessage("OK", ipAddress, port);
   }
}
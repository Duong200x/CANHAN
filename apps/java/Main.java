import com.sun.net.httpserver.HttpServer;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class Main {
  public static void main(String[] args) throws Exception {
    HttpServer server = HttpServer.create(new InetSocketAddress(8082), 0);
    server.createContext("/health", exchange -> {
      byte[] resp = "{\"ok\":true,\"runtime\":\"java\"}".getBytes();
      exchange.getResponseHeaders().add("Content-Type","application/json");
      exchange.sendResponseHeaders(200, resp.length);
      try (OutputStream os = exchange.getResponseBody()) { os.write(resp); }
    });
    server.start();
    System.out.println("java app on :8082");
  }
}

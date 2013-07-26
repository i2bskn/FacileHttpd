package org.i2bs.facilehttpd;

import java.net.ServerSocket;
import java.net.Socket;

import org.i2bs.facilehttpd.WorkerThread;

public class FacileHttpd {
  private ServerSocket ssock;

  public FacileHttpd() {
    try {
      ssock = new ServerSocket(8080);
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public void start() {
    try {
      while (true) {
        Socket sock = ssock.accept();
        WorkerThread worker = new WorkerThread(sock);
        worker.start();
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public static void main(String[] args) {
    FacileHttpd server = new FacileHttpd();
    server.start();
  }
}
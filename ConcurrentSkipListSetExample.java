import java.util.*;
import java.io.*;
import java.util.concurrent.*;

public class ConcurrentSkipListSetExample {

  ConcurrentSkipListSet<BasicDiscoPeer> concurrentSkipList = new ConcurrentSkipListSet<BasicDiscoPeer>(Comparator.comparingInt(BasicDiscoPeer::getLastContacted));

  public static void main(String[] args) {
    new ConcurrentSkipListSetExample().go();
  }

  public void go() {
    getDiscoPeers();
    System.out.println(concurrentSkipList);
  }

  void getDiscoPeers() {
    try {
      File file = new File("NewPeers.txt");
      BufferedReader reader = new BufferedReader(new FileReader(file));
      String line = null;
      while((line = reader.readLine()) != null) {
        addLastContacted(line);
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  void addLastContacted(String lineToParse) {
    String[] tokens = lineToParse.split("/");
    BasicDiscoPeer nextDiscoPeer = new BasicDiscoPeer(tokens[0], Integer.valueOf(tokens[1]));
    concurrentSkipList.add(nextDiscoPeer);
  }
}

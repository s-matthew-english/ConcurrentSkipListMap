import java.util.*;
import java.io.*;
import java.util.concurrent.*;

class PriorityBlockingQueueExample {

  private final PriorityQueue<BasicDiscoPeer> evictionQueue = new PriorityQueue<BasicDiscoPeer>(16, Comparator.comparingInt(BasicDiscoPeer::getLastContacted));

  public static void main(String[] args) {
    new PriorityBlockingQueueExample().go();
  }

  public void go() {
    getDiscoPeers();
    System.out.println(evictionQueue);
    /**
     * A PriorityQueue is what is called a binary heap. It is only ordered/sorted 
     * in the sense that the first element is the least. In other word, it only 
     * cares about what is in the front of the queue, the rest are "ordered" when 
     * needed.
     */
    while (!evictionQueue.isEmpty())
      System.out.println(evictionQueue.remove());
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
    evictionQueue.add(nextDiscoPeer);
  }

}

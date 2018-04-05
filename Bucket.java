import java.util.*;
import java.io.*;

public class Bucket {

  ArrayList<BasicDiscoPeer> discoPeerList = new ArrayList<BasicDiscoPeer>();

  public static void main(String[] args) {
    new Bucket().go();
  }

  public void go() {
    getDiscoPeers();
    System.out.println(discoPeerList);
    Collections.sort(discoPeerList);
    System.out.println(discoPeerList);
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
    discoPeerList.add(nextDiscoPeer);
  }
}

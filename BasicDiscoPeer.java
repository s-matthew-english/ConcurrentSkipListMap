/**
 * Represents an Ethereum node that we interacting with through the discovery and wire protocols.
 */
public class BasicDiscoPeer implements Comparable<BasicDiscoPeer> {

  // Timestamps.
  private String id;
  private int lastContacted;

  public int compareTo(BasicDiscoPeer basicDiscoPeer) {
      return lastContacted - basicDiscoPeer.getLastContacted();
  }

  BasicDiscoPeer(String id, int lastContacted) {
    this.id = id;
    this.lastContacted = lastContacted;
  }

  public int getLastContacted() {
    return lastContacted;
  }

  public int setLastContacted(int lastContacted) {
    return this.lastContacted = lastContacted;
  }

  public String toString() {
    return id;
  }
}

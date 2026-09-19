public class Playlist {
    private static class Node{
        Song song;
        Node next;

        Node(Song song){
            this.song = song;
            this.next = null;
        }
    }
    private Node head;
    private Node tail;
    private Node currentNode;
    private int size;

    public Playlist(){
        this.head=null;
        this.tail=null;
        this.currentNode = null;
        this.size = 0;
    }

    public void addSong(Song song){
        Node newNode = new Node(song);

        if (head == null){
            head = newNode;
            tail = newNode;
            currentNode = head;
        } else{
            tail.next = newNode;
            tail = newNode;
        }
        size ++;
        System.out.println("Added " + song);
    }

    public void removeSong(String title){
        Node previous = null;
        Node current = head;

        if (head == null){
            System.out.println("Empty playlist");
            return;
        }
        while (current != null && !current.song.getTitle().equalsIgnoreCase(title)){
            previous = current;
            current = current.next;
        }
        if (current == null){
            return;
        }
        if (current == head){
            head = head.next;

            if (head == null){
                tail = null;
                currentNode = null;
            } else if (currentNode == current){
                currentNode = head;
            }
        }
        else {
            previous.next = current.next;
            if (current == tail){
                tail = previous;
            }
            if (currentNode == current){
                if (current.next !=null){
                    currentNode = current.next;
                } else {
                    currentNode = head;
                }
            }
        }
        size--;
        System.out.println("Removed " + current.song);
    }

    public void playNext(){
        if (head == null){
            System.out.println("Empty playlist");
            return;
        }
        System.out.println("Playing " + currentNode.song);
        if (currentNode.next != null){
            currentNode = currentNode.next;
        } else {
            currentNode = head;
        }
    }

    public void displayPlaylist(){
        if (head == null){
            System.out.println("Empty playlist");
            return;
        }

        Node current = head;
        int position = 1;

        System.out.println("Track");

        while (current != null){
            System.out.println(position + ". " + current.song);
            current = current.next;
            position ++;
        }
        System.out.println("------------");
    }
}

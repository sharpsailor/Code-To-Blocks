package LinkedList;
import java.io.*;
import java.util.*;
public class LinkedListDemo {
	public static class Node{
		int data ;
		Node next;
	}
	public static class LinkedList{
		Node head;
		Node tail;
		int size;
		int size() {
			return size;
		}
		void display() {
			for(Node temp = this.head;temp!=null;temp = temp.next) {
				System.out.print(temp.data+" ");
			}
			System.out.println();
		}
		void addLast(int val) {
			Node node = new Node();
			node.data = val;
			node.next = null;
			if(size==0) {
				head = tail = node;
			}else {
			tail.next = node;
			tail=node;
			} 
			size++;
		}
	}
	 public static void testList(LinkedList list) {
		    for (Node temp = list.head; temp != null; temp = temp.next) {
		      System.out.println(temp.data);
		    }
		    System.out.println(list.size);

		    if (list.size > 0) {
		      System.out.println(list.tail.data);
		    } 
		  }
	 public static void main(String[] args) throws Exception {
		    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		    LinkedList list = new LinkedList();

		    String str = br.readLine();
		    while(str.equals("quit") == false){
		      if(str.startsWith("addLast")){
		        int val = Integer.parseInt(str.split(" ")[1]);
		        list.addLast(val);
		      } else if(str.startsWith("size")){
		        System.out.println(list.size());
		      } else if(str.startsWith("display")){
		        list.display();
		      }
		      str = br.readLine();
		    }
		    testList(list);
}

}

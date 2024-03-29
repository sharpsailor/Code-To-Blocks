package GenericTree;

import java.util.*;

public class withoutQueueUsingLinkedList {

	public static class Node{
		int data;
		ArrayList<Node> children = new ArrayList<>();
		Node( int data){
			this.data = data;
		}
	}
//	public static void LevelOrderLineWise(Node node) {
//	LinkedList<Node> que = new LinkedList<>	();
//		que.addLast(node);
//		while(que.size()!=0) {
//			int currSize=que.size();
//			while(currSize-->0) {
//				Node rnode = que.removeFirst();
//				System.out.print(rnode.data+" ");
//				for(Node child :rnode.children) {
//					que.addLast(child);
//					
//				}
//			}
//		}
//		
//	}
	public static void levelOrderZigZag(Node node) {
		LinkedList<Node> que = new LinkedList<>();//addLast
		LinkedList<Node> stack = new LinkedList<>();//addFirst
		que.addLast(node);
		int level =0;
		
		while(que.size()!=0) {
			int currSize= que.size();
			while(currSize-->0) {
				Node rnode = que.removeFirst();
				System.out.print(rnode.data+" ");
				if(level%2==0) {
					for(int i =0;i<rnode.children.size();i++) {
						stack.addFirst(rnode.children.get(i));
					}
				}else {
					for(int i=rnode.children.size()-1;i>=0;i--) {
						stack.addFirst(rnode.children.get(i));
					}
				}
			}
			level++;
			System.out.println(".");
			LinkedList<Node> temp = que;
			que=stack;
			stack= temp;
		}
		
	}
	public static void levelOrderLineWise(Node node) {
		LinkedList<Node> que = new LinkedList<>();
		que.addFirst(node);
		while(que.size()!=0) {
			int currSize=que.size();
			while(currSize-->0) {
				Node rnode = que.removeFirst();
				System.out.print(rnode.data+" ");
				for(Node child : rnode.children) {
					que.addLast(child);
				}
			}
			System.out.println(".");
		}
		
	}

	public static Node construct(int[]arr) {
		Node root = null;
		Stack<Node> stack = new Stack<>();
		for(int val : arr) {
			if(val !=-1) {
				Node node = new Node(val);
				stack.push(node);
			}else {
				Node node =stack.pop();
				if(stack.size()>0) {
					Node parent = stack.peek();
					parent.children.add(node);
				}else {
					root = node;
				}
			}
		}
		return root;
	}
	public static int size(Node node) {
		int size =0;
		for(Node child:node.children) {
			size+=size(child); 
		}
		return size+1;
	}
	public static int max (Node node) {
		int max =node.data;
		for(Node child:node.children) {
			int recAns = max(child);
			max=Math.max(max, recAns);
		}
		return max;
	}
	public static int min (Node node) {
		int min = node.data;
		for(Node child : node.children) {
			int recAns= min(child);
			min = Math.min(recAns, min);
		}
		return min;
	}
	public static int height(Node node) {
		int height = -1;
		for(Node child:node.children) {
			int recAns = height(child);
			height=Math.max(recAns,height);
		}
		return height+1;
	}
	public static int height2(Node node) {
		int height = 0;
		for(Node child:node.children) {
			int recAns = height(child);
			height=Math.max(recAns+1,height);
		}
		return height;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub  
		int[] arr = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
		Node root = construct(arr);
//		levelOrderLineWise(root);
		levelOrderZigZag(root);
		System.out.println("Size:");
		System.out.println(size(root));

		System.out.println("Max:");
		System.out.println(max(root));
		System.out.println("Min:");
		System.out.println(min(root));
		System.out.println("Height:");
		System.out.println(height(root));
		System.out.println("Height2:");
		System.out.println(height(root));
	}

}

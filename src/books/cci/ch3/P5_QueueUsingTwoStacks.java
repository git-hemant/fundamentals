package books.cci.ch3;

import java.util.Stack;

// Implement a MyQueue class which implements a queue using two stacks.
public class P5_QueueUsingTwoStacks {

	public static void main(String[] args) {
		Queue<String> q = new Queue<String>();
		q.queue("1");q.queue("2");q.queue("3");
		System.out.println("First element in queue is: " + q.dequeue());
	}

	static class Queue<E> {

		private Stack<E> inbox = new Stack<E>();
		private Stack<E> outbox = new Stack<E>();

		public void queue(E item) {
			inbox.push(item);
		}

		public E dequeue() {
			if (outbox.isEmpty()) {
				// This way - we are building opposite order of stack
				// which is exactly what queue is as 
				// Stack is LIFO and Queue is FIFO
				while (!inbox.isEmpty()) {
					outbox.push(inbox.pop());
				}
			}
			return outbox.pop();
		}

	}
}

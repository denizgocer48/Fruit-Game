package homework2;

public class Stack{
    private int top;
    private Object[] elements;
    
    
    public Stack(int capacity){
        elements = new Object[capacity];
        top= -1;
    }

    public void push(Object data) {
        if(isFull()) {        	
        }         
        else {
            top++;
            elements[top] = data;
        }
    }
    
    public Object pop() {
        if(isEmpty()) {
            return null;
        }
        else {
            Object retData = elements[top];
            top--;
            return retData;
        }
    }
    public Object peek() {
        if(isEmpty()) {
            return null;
        }
        else
            return elements[top];
    }
    
    
    public boolean isEmpty() {
        return(top == -1);
    }
    
    public boolean isFull() {
        return (top + 1 == elements.length);
    }
    
    public int size() {
        return top+1;
    }
    
}
class Queue {
	
	private int rear,front;
	private Object[] elements;
	public Queue(int capacity) {
		elements = new Object[capacity];
		rear = -1;
		front =0;
	}
	void enqueue(Object data) {
		if(isFull())
			System.out.println("Queue overflow");
		else {
			rear++;
			elements[rear] = data;
		}
	}
	Object dequeue(){
		if ( isEmpty()) {
			System.out.println("Queue is empty");
			return null;
		}
		else {
			Object retData = elements[front];
			elements[front] = null;
			front++;
			return retData;
		}
			
	}
	Object peek() {
		if(isEmpty()) {
			System.out.println("Queue is empty");
			return null;
		}
		else {
			return elements[front];
		}
	}
	boolean isEmpty() {
		return rear<front;
	}

	boolean isFull() {
		return(rear +1 == elements.length);
	}
	int size() {
		return rear - front +1;
	}
}

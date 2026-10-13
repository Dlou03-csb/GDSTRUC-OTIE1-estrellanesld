import java.util.NoSuchElementException;

public class ArrayQueue {
    private Player[] queue;
    private int front;
    private int back;

    public ArrayQueue(int capacity) {
        queue = new Player[capacity];
        front = 0;
        back = 0;
    }

    public int size() {
        return  back - front;
    }

    public void enqueue(Player player) {
        // array is currently full, so we expand
        if (back == queue.length) {
            Player[] newQueue = new Player[queue.length * 2];
            System.arraycopy(queue, front, newQueue, 0, size());
            queue = newQueue;
            back = size();
            front = 0;
        }

        queue[back++] = player;
    }

    public Player dequeue() {
        if (size() == 0)
            throw new NoSuchElementException();

        Player removedPlayer = queue[front];
        queue[front++] = null;

        // queue is empty, reset front and back to 0
        if (size() == 0) {
            front = 0;
            back = 0;
        }

        return removedPlayer;
    }

    public Player peek() {
        if (size() == 0)
            throw new NoSuchElementException();

        return  queue[front];
    }

    public void printQueue() {
        System.out.println("FRONT");

        for (int i = front; i < back; i++) {
            System.out.println(" -> " + queue[i]);
        }
    }
}
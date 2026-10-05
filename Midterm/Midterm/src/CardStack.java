import java.util.EmptyStackException;

public class CardStack
{
    private Card[] stack;
    private int top;

    public CardStack(int capacity)
    {
        stack = new Card[capacity];
        top = -1;
    }

    public void push(Card card)
    {
        if (top == stack.length - 1)
        {
            Card[] newStack = new Card[stack.length * 2];
            System.arraycopy(stack, 0, newStack, 0, stack.length);
            stack = newStack;

        }

        stack[++top] = card;
    }

    public boolean empty()
    {
        return top == -1;
    }

    public Card pop()
    {
        if (empty())
        {
            throw new EmptyStackException();
        }

        Card poppedCard = stack[top];
        stack[top] = null;
        top--;

        return poppedCard;
    }

    public Card peek()
    {
        if (empty())
        {
            throw new EmptyStackException();
        }

        return stack[top];
    }

    public void printStack()
    {
        for (int i = top; i >= 0; i--)
        {
            System.out.println(stack[i]);
        }

    }

    public int size()
    {
        return top + 1;
    }

}

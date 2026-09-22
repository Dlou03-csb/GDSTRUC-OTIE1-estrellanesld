public class PlayerLinkedList {
    private PlayerNode head;

    public void add(Player player) {
        PlayerNode node = new PlayerNode(player);
        node.setNextPlayer(head);
        head = node;
    }

    public void printList() {
        PlayerNode currentNode = head;

        System.out.println("HEAD ");

        while (currentNode != null) {
            System.out.print(" -> " + currentNode.getPlayer());
            currentNode = currentNode.getNextPlayer();
        }
    }

    public Player remove() {

        if (head == null)
        {
            return null;
        }
        Player removedPlayer = head.getPlayer();
        head = head.getNextPlayer();

        return removedPlayer;

    }

    public int size() {

        int count = 0;
        PlayerNode currentNode = head;
        while (currentNode != null)
        {
           count++;
           currentNode = currentNode.getNextPlayer();
        }

        return count;
    }

    public boolean contains(Player player) {

        PlayerNode currentNode = head;

        while (currentNode != null)
        {
            if (currentNode.getPlayer().equals(player))
            {
                return true;
            }
            currentNode = currentNode.getNextPlayer();
        }
        return false;
    }

    public int indexOf(Player player) {

        PlayerNode currentNode = head;
        int index = 0;

        while (currentNode != null)
        {
            if (currentNode.getPlayer().equals(player))
            {
                return index;
            }

            currentNode = currentNode.getNextPlayer();
            index++;

        }
        return -1;
    }
}


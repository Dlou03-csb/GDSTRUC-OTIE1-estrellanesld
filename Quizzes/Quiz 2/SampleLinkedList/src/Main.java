public class Main {
    public static void main(String[] args) {
        PlayerLinkedList playerList = new PlayerLinkedList();
        playerList.add(new Player(1, "Goku", 500));
        playerList.add(new Player(2, "Saitama", 999));
        playerList.add(new Player(3, "Sakamoto", 10));

        playerList.printList();

        System.out.println("\nSize: " + playerList.size());
        System.out.println("Contains Goku: " + playerList.contains(new Player(1, "Goku", 500)));
        System.out.println("Contains Jinwoo: " + playerList.contains(new Player(4, "Jinwoo", 1000)));
        System.out.println("Index of Saitama: " + playerList.indexOf(new Player(2, "Saitama", 999)));

        System.out.println("Removed: " + playerList.remove());
        System.out.println("New Size: " + playerList.size());
    }
}
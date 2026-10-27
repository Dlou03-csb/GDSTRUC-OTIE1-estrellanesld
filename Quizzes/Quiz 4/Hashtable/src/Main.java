public class Main
{
    public static void main(String[] args)

    {
        Player pikachu = new Player(25, "Pikachu", 10);
        Player celebi = new Player(251, "Celebi", 10);
        Player hitmonchan = new Player(107, "Hitmonchan", 10);
        Player mankey = new Player(56, "Mankey", 10);
        Player starmie = new Player(121, "Starmie", 10);
        Player togepi = new Player(175, "Togepi", 10);

        SimpleHashtable hashtable = new SimpleHashtable();
        hashtable.put(pikachu.getUserName(), pikachu);
        hashtable.put(celebi.getUserName(), celebi);
        hashtable.put(hitmonchan.getUserName(), hitmonchan);
        hashtable.put(mankey.getUserName(), mankey);
        hashtable.put(starmie.getUserName(), starmie);
        hashtable.put(togepi.getUserName(), togepi);

        System.out.println("\n");

        hashtable.printHashtable();

        System.out.println("\n\n========= REMOVED PLAYER =========\n");

        Player removedPlayer = hashtable.remove("Mankey");

        hashtable.printHashtable();
    }

}
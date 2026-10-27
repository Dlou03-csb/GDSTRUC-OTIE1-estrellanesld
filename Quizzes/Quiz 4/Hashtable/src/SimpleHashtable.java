public class SimpleHashtable
{
    private SavedPlayer[] hashtable;

    public SimpleHashtable() {
        hashtable = new SavedPlayer[10];
    }

    public int hashKey(String key) {
        return key.length() % hashtable.length;
    }

    public boolean isOccuppied(int hashedKey) {
        return hashtable[hashedKey] != null;
    }

    public void put(String key, Player player) {
        int hashedKey = hashKey(key);

        // linear probing - find the next available space by iterating through the array
        if (isOccuppied(hashedKey)) {
            int stoppingIndex = hashedKey;

            if (hashedKey == hashtable.length - 1) {
                hashedKey = 0;
            }
            else {
                hashedKey++;
            }

            while (hashedKey != stoppingIndex && isOccuppied(hashedKey)) {
                hashedKey = (hashedKey + 1) % hashtable.length;
            }
        }

        if (isOccuppied(hashedKey)) {
            System.out.println("Value already exists at bucket " + hashedKey);
            return;
        }

        hashtable[hashedKey] = new SavedPlayer(player.getUserName(), player);
    }

    public int findKey(String key) {
        int hashedKey = hashKey(key);

        if (isOccuppied(hashedKey) && hashtable[hashedKey].getKey().equals(key))
            return hashedKey;

        int stoppingIndex = hashedKey;

        if (hashedKey == hashtable.length - 1) {
            hashedKey = 0;
        }
        else {
            hashedKey++;
        }

        while (hashedKey != stoppingIndex &&
                isOccuppied(hashedKey) &&
                !hashtable[hashedKey].getKey().equals(key)) {
            hashedKey = (hashedKey + 1) % hashtable.length;
        }

        if (isOccuppied(hashedKey) && hashtable[hashedKey].getKey().equals(key))
            return  hashedKey;

        return -1;
    }

    public Player get(String key) {
        int hashedKey = findKey(key);

        if (hashedKey == -1)
            return null;

        return hashtable[hashedKey].getPlayer();
    }

    public Player remove(String key)
    {
        int hashedKey = findKey(key);

        if (hashedKey == -1)
        {
            return null;
        }

        Player removedPlayer = hashtable[hashedKey].getPlayer();
        hashtable[hashedKey] = null;

        hashedKey = (hashedKey + 1) % hashtable.length;
        while (isOccuppied(hashedKey))
        {

            SavedPlayer rehash = hashtable[hashedKey];
            hashtable[hashedKey] = null;
            put(rehash.getKey(), rehash.getPlayer());
            hashedKey = (hashedKey + 1) % hashtable.length;

        }

        return removedPlayer;
    }

    public void printHashtable() {
        for (int i = 0; i < hashtable.length; i++) {
            Player player = null;

            if (isOccuppied(i))
                player = hashtable[i].getPlayer();

            System.out.println("Value at bucket " + i + " - " + player);
        }
    }
}
public class SavedPlayer {
    private String key;
    private Player player;

    public SavedPlayer(String key, Player player) {
        this.key = key;
        this.player = player;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
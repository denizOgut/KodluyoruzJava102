package Main;

import LocationClass.Location;
import LocationClass.NormalLocation.SafeHouse;
import LocationClass.NormalLocation.ToolStore;

import java.util.Scanner;

public class Game {
    private Player player;
    private Location location;

    public Game(Player player, Location location) {
        this.player = player;
        this.location = location;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public static void run() {
        Player player = new Player();


    }


}

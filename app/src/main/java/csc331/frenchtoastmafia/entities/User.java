package csc331.frenchtoastmafia.entities;

import java.util.Arrays;
import java.util.Comparator;

public class User implements Comparable<User> {
    public String name;
    public String teamName;
    public int wins = 0;
    public int losses = 0;
    public int image_id;

    public User(String name, String teamName, int image_id) {
        this.name = name;
        this.teamName = teamName;
        wins = 0;
        losses = 0;
        this.image_id = image_id;
    }

    @Override
    public int compareTo(User user) {
        if (wins == user.wins)
        {
            return 0;
        }

        if (wins > user.wins)
        {
            return -1;
        }

        else
        {
            return 1;
        }
    }

    public void addWins(int wins)
    {
        this.wins = this.wins + wins;
    }

    public void addLosses(int losses)
    {
        this.losses = this.losses + losses;
    }

    public void setWins(int wins)
    {
        this.wins = wins;

    }

    public void setLosses(int losses)
    {
        this.losses = losses;
    }

    public void resetWinsLosses()
    {
        this.wins = 0;
        this.losses = 0;
    }

}

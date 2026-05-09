import java.util.ArrayList;
import java.util.Scanner;

class Player {
    String name;
    int strikeRate;
    int economyRate;

    Player(String name, int strikeRate, int economyRate) {
        this.name = name;
        this.strikeRate = strikeRate;
        this.economyRate = economyRate;
    }
}

public class SmartCricketTeamSelector {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Player> players = new ArrayList<>();

        // Adding Players
        players.add(new Player("Virat Kohli", 145, 0));
        players.add(new Player("Rohit Sharma", 140, 0));
        players.add(new Player("Hardik Pandya", 135, 8));
        players.add(new Player("Jasprit Bumrah", 0, 5));
        players.add(new Player("Rashid Khan", 0, 6));

        System.out.println("=== Smart Cricket Team Selector ===");

        // Match Inputs
        System.out.print("Enter Target Score: ");
        int target = sc.nextInt();

        System.out.print("Enter Balls Remaining: ");
        int balls = sc.nextInt();

        System.out.print("Enter Wickets Left: ");
        int wickets = sc.nextInt();

        double requiredRunRate = (target * 6.0) / balls;

        System.out.println("\nRequired Run Rate: " + requiredRunRate);

        System.out.println("\nRecommended Players:");

        // Recommendation Logic
        for (Player p : players) {

            // Aggressive batsman selection
            if (requiredRunRate > 10 && p.strikeRate >= 140) {
                System.out.println(p.name + " -> Power Hitter");
            }

            // Balanced player selection
            else if (requiredRunRate <= 10 && p.strikeRate >= 130) {
                System.out.println(p.name + " -> Stable Batsman");
            }

            // Bowler recommendation
            if (wickets <= 3 && p.economyRate > 0 && p.economyRate <= 6) {
                System.out.println(p.name + " -> Defensive Bowler");
            }
        }

        sc.close();
    }
}

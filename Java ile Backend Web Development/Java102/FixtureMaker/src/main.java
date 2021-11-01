import java.util.LinkedList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        FixtureGenerator<String> fixtureGenerator = new FixtureGenerator();
        List<String> teams = new LinkedList<String>();
        teams.add("Galatasaray");
        teams.add("Bursaspor");
        teams.add("Fenerbahçe");
        teams.add("Beşiktaş");
        teams.add("Başakşehir");
        teams.add("Trabzonspor");

        List<List<Team<String>>> rounds = fixtureGenerator.getFixtures(teams, true);
        for (int i = 0; i < rounds.size(); i++) {
            System.out.println("Round " + (i + 1));
            List<Team<String>> round = rounds.get(i);
            for (Team<String> fixture : round) {
                System.out.println(fixture.getHomeTeam() + " vs " + fixture.getGuestTeam());
            }
            System.out.println("");
        }
    }
}
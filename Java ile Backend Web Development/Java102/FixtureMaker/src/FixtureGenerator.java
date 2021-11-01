import java.util.LinkedList;
import java.util.List;

public class FixtureGenerator <T>{
    public List<List<Team<T>>> getFixtures(List<T> teams, boolean includeReverseFixtures) {

        int numberOfTeams = teams.size();


        boolean ghost = false;
        if (numberOfTeams % 2 != 0) {
            numberOfTeams++;
            ghost = true;
        }


        int totalRounds = numberOfTeams - 1;
        int matchesPerRound = numberOfTeams / 2;
        List<List<Team<T>>> rounds = new LinkedList<List<Team<T>>>();

        for (int round = 0; round < totalRounds; round++) {
            List<Team<T>> fixtures = new LinkedList<Team<T>>();
            for (int match = 0; match < matchesPerRound; match++) {
                int home = (round + match) % (numberOfTeams - 1);
                int away = (numberOfTeams - 1 - match + round) % (numberOfTeams - 1);
                if (match == 0) {
                    away = numberOfTeams - 1;
                }
                fixtures.add(new Team<T>(teams.get(home), teams.get(away)));
            }
            rounds.add(fixtures);
        }


        List<List<Team<T>>> interleaved = new LinkedList<List<Team<T>>>();

        int evn = 0;
        int odd = (numberOfTeams / 2);
        for (int i = 0; i < rounds.size(); i++) {
            if (i % 2 == 0) {
                interleaved.add(rounds.get(evn++));
            } else {
                interleaved.add(rounds.get(odd++));
            }
        }

        rounds = interleaved;


        for (int roundNumber = 0; roundNumber < rounds.size(); roundNumber++) {
            if (roundNumber % 2 == 1) {
                Team fixture = rounds.get(roundNumber).get(0);
                rounds.get(roundNumber).set(0, new Team(fixture.getGuestTeam(), fixture.getHomeTeam()));
            }
        }

        if(includeReverseFixtures){
            List<List<Team<T>>> reverseFixtures = new LinkedList<List<Team<T>>>();
            for(List<Team<T>> round: rounds){
                List<Team<T>> reverseRound = new LinkedList<Team<T>>();
                for(Team<T> fixture: round){
                    reverseRound.add(new Team<T>(fixture.getGuestTeam(), fixture.getHomeTeam()));
                }
                reverseFixtures.add(reverseRound);
            }
            rounds.addAll(reverseFixtures);
        }

        return rounds;
    }
}

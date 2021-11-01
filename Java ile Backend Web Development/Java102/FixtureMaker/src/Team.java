public class Team <T> {
    private T homeTeam, guestTeam;

    public Team(T homeTeam, T guestTeam) {
        this.homeTeam = homeTeam;
        this.guestTeam = guestTeam;
    }

    public T getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(T homeTeam) {
        this.homeTeam = homeTeam;
    }

    public T getGuestTeam() {
        return guestTeam;
    }

    public void setGuestTeam(T guestTeam) {
        this.guestTeam = guestTeam;
    }
}

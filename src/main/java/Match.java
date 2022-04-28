public class Match {

    private String matchName;
    private String matchTime;

    public String getMatchName() {
        return matchName;
    }

    public String getMatchTime() {
        return matchTime;
    }

    public Match(String currentMatchName, String currentMatchTime) {
        this.matchName = currentMatchName;
        this.matchTime = currentMatchTime;
    }
}

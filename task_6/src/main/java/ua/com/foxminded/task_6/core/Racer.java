package ua.com.foxminded.task_6.core;

import java.util.Objects;

class Racer {
    private String abbreviation;
    private String name;
    private String team;
    private Long raceResult;

    protected Racer (String abbreviation, String name, String team, long raceResult) {
        this.abbreviation = abbreviation;
        this.name = name;
        this.team = team;
        this.raceResult = raceResult;
    }

    protected String getAbbreviation() {
        return abbreviation;
    }

    protected String getName () {
        return name;
    }

    protected String getTeam() {
        return team;
    }

    protected Long getRaceResult() {
        return raceResult;
    }

    @Override
    public int hashCode() {
        return Objects.hash(abbreviation, name, raceResult, team);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Racer other = (Racer) obj;
        return Objects.equals(abbreviation, other.abbreviation) && Objects.equals(name, other.name)
                && Objects.equals(raceResult, other.raceResult) && Objects.equals(team, other.team);
    }


}
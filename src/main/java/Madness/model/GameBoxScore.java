package Madness.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class GameBoxScore implements Serializable {

    @Id
    private String id;

    private String title;
    private String status;
    private String scheduled;
    private int lead_changes;
    private String clock;
    private String half;
    @OneToOne(optional = true)
    private TeamBoxScore home;
    @OneToOne(optional = true)
    private TeamBoxScore away;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getScheduled() {
        return scheduled;
    }

    public void setScheduled(String scheduled) {
        this.scheduled = scheduled;
    }

    public int getLead_changes() {
        return lead_changes;
    }

    public void setLead_changes(int lead_changes) {
        this.lead_changes = lead_changes;
    }

    public String getClock() {
        return clock;
    }

    public void setClock(String clock) {
        this.clock = clock;
    }

    public String getHalf() {
        return half;
    }

    public void setHalf(String half) {
        this.half = half;
    }

    public TeamBoxScore getHome() {
        return home;
    }

    public void setHome(TeamBoxScore home) {
        this.home = home;
    }

    public TeamBoxScore getAway() {
        return away;
    }

    public void setAway(TeamBoxScore away) {
        this.away = away;
    }
}

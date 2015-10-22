package voting.rest.business.views;

import voting.rest.business.models.entities.Theme;

public class VoteTransfer {
    private int id;

    private int vote;

    private Theme theme;

    public VoteTransfer() {

    }

    public VoteTransfer(int id, int vote, Theme theme) {
        super();
        this.id = id;
        this.vote = vote;
        this.theme = theme;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

}

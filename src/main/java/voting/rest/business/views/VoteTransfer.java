package voting.rest.business.views;

public class VoteTransfer {

    private int vote;

    private String name;

    public VoteTransfer(String name, int vote) {
        super();
        this.name = name;
        this.vote = vote;
    }

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

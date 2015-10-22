package voting.rest.business.controllers;

import java.util.List;
import voting.rest.business.models.entities.Theme;
import voting.rest.business.models.entities.Vote;
import voting.rest.business.views.ThemeTransfer;
import voting.rest.business.views.VoteTransfer;
import voting.rest.data.models.daos.DaoFactory;

public class VoteBusinessController {
    // CASOS DE USO VOTE (BusinessController2)
    // - VoteTheme
    // - ShowThemeManager

    public boolean VoteTheme_OLD(String nameTheme) {
        Theme theme = getThemeByName(nameTheme);
        if (theme != null) {
            return false;
        } else {
            Vote voteNew = new Vote(getNextId(), 1, theme);
            DaoFactory.getFactory().getVoteDao().create(voteNew);
            return true;
        }
    }

    public boolean VoteTheme(VoteTransfer voteTransfer) {
        int id = getNextId();
        Theme theme = voteTransfer.getTheme();
        int themeValueVote = voteTransfer.getVote();
        Vote vote = new Vote(id, themeValueVote, theme);

        DaoFactory.getFactory().getVoteDao().create(vote);
        return true;
    }
    
        
    private double sumVotes(List<Vote> voteList){
        double sum = 0;
        for (int i = 0; i < voteList.size(); i++) {
            sum += voteList.get(i).getVote();
        }
        return sum;
    }
    
    
    public double[][] getCalcAverage(){
        double [][] themeAverage = null;
        double average = 0;
        List<Theme> themeList = DaoFactory.getFactory().getThemeDao().findAll();
        for (int i = 0; i < themeList.size(); i++) {
            List<Vote> voteList = DaoFactory.getFactory().getVoteDao().findByTheme(themeList.get(i));
            int id = themeList.get(i).getId();
            average = sumVotes(voteList)/voteList.size();
            themeAverage [id][1] = average;
            }
        return themeAverage;
    }
    
    
    

    
    
    
    
    

    private Theme getThemeByName(String name) {
        return DaoFactory.getFactory().getThemeDao().findByName(name);
    }

    private List<Vote> getVoteByName(Theme theme) {
        return DaoFactory.getFactory().getVoteDao().findByTheme(theme);
    }

    private int getNextId() {
        return DaoFactory.getFactory().getVoteDao().findAll().size() + 1;
    }

    public VoteTransfer m1() {
        DaoFactory.getFactory().getThemeDao().findAll();
        return new VoteTransfer();
    }

    public void m2(ThemeTransfer themeTransfer) {
        DaoFactory.getFactory().getVoteDao().read(1);
    }
    
    public List<Vote> getVotes() {
        return DaoFactory.getFactory().getVoteDao().findAll();
    }
}

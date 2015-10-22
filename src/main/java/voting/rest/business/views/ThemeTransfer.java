package voting.rest.business.views;

public class ThemeTransfer {
    private int id;

    private String name;
    
    private double average;

    
    public ThemeTransfer() {
    
    }

    public ThemeTransfer(int id, String name, double average) {
        this.id = id;
        this.name = name;
        this.average = average;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }    
    
    
    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }    
}

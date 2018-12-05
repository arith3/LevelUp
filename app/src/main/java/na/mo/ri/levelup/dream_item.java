package na.mo.ri.levelup;

public class dream_item {
    private boolean doCheck;
    private String getDate;
    private String getGoal;

    public dream_item(boolean doCheck, String getDate, String getGoal) {
        this.doCheck = doCheck;
        this.getDate = getDate;
        this.getGoal = getGoal;
    }

    public String getGetDate() {
        return getDate;
    }

    public String getGetGoal() {
        return getGoal;
    }

    public boolean isDoCheck() {
        return doCheck;
    }

    public void setDoCheck(boolean doCheck) {
        this.doCheck = doCheck;
    }

    public void setGetDate(String getDate) {
        this.getDate = getDate;
    }

    public void setGetGoal(String getGoal) {
        this.getGoal = getGoal;
    }
}

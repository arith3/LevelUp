package na.mo.ri.levelup;

public class rank_item {
    private String lankText;
    private int lankImage;
    private int lankProgressbar;
    private String lankPercentText;


    public rank_item(String lankText, int lankImage, int lankProgressbar, String lankPercentText) {
        this.lankText = lankText;
        this.lankImage = lankImage;
        this.lankProgressbar = lankProgressbar;
        this.lankPercentText = lankPercentText;
    }

    public String getLankPercentText() {
        return lankPercentText;
    }

    public int getLankImage() {
        return lankImage;
    }

    public String getLankText() {
        return lankText;
    }

    public int getLankProgressbar() {
        return lankProgressbar;
    }

    public void setLankPercentText(String lankPercentText) {
        this.lankPercentText = lankPercentText;
    }

    public void setLankImage(int lankImage) {
        this.lankImage = lankImage;
    }

    public void setLankProgressbar(int lankProgressbar) {
        this.lankProgressbar = lankProgressbar;
    }

    public void setLankText(String lankText) {
        this.lankText = lankText;
    }
}
package na.mo.ri.levelup.coverFlow;

public class DoWorkEntity {
    private String titleResId;
    private int imageResId;

    public DoWorkEntity(String titleResId, int imageResId) {
        //실제 CoverFlow 들어갈 데이터
        this.titleResId = titleResId;
        this.imageResId = imageResId;
    }

    public String getTitleResId() {
        return titleResId;
    }

    public void setTitleResId(String titleResId) {
        this.titleResId = titleResId;
    }

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }
}

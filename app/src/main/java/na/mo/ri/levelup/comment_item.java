package na.mo.ri.levelup;

import java.util.ArrayList;

public class comment_item {
    private String comment_content;
    private String comment_name;
    private int comment_image;

    public String getComment_content() {
        return comment_content;
    }

    public void setComment_content(String comment_content) {
        this.comment_content = comment_content;
    }
    public String getComment_name() {
        return comment_name;
    }

    public void setComment_name(String comment_name) {

        this.comment_name = comment_name;
    }

    public int getComment_image() {
        return comment_image;
    }

    public void setComment_image(int comment_image) {
        this.comment_image = comment_image;
    }

    public comment_item(int comment_image, String comment_content) {
        this.comment_image = comment_image;
        this.comment_content=comment_content;
    }
    public comment_item(int comment_image, String comment_name,String comment_content) {
        this.comment_image = comment_image;
        this.comment_name=comment_name;
        this.comment_content=comment_content;
    }
}

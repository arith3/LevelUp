package na.mo.ri.levelup;

import java.util.ArrayList;

public class comment_item {
    private String comment_content;
    private String user_email;
    private int comment_image;

    public String getComment_content() {
        return comment_content;
    }

    public void setComment_content(String comment_content) {
        this.comment_content = comment_content;
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
    public comment_item(int comment_image, String user_email,String comment_content) {
        this.comment_image = comment_image;
        this.user_email=user_email;
        this.comment_content=comment_content;
    }
}

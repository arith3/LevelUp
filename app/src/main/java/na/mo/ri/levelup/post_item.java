package na.mo.ri.levelup;
import java.util.ArrayList;
import java.util.Date;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;


public class post_item extends AppCompatActivity implements View.OnClickListener {

    ArrayList<comment_item> comment_listArrayList;
    private String name;
    private TextView name_textview;
    private TextView date_dateview;
    private String title;
    private TextView title_textview;
    private int content_image;
    private Date write_date;
    private TextView post_content;
    private Button heartbutton;
    private Button comment_submitbutton;
    private String comment_mycontent;
    private String comment_content;
    private ImageView content_imageview;
    private ListView comment_list;
    CommentListAdapter commentListAdapter;


    int love=0;
    int comment=0;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        comment_list=(ListView)findViewById(R.id.comment_list);
        commentListAdapter = new CommentListAdapter(post_item.this,comment_listArrayList);
        title_textview=(TextView)findViewById(R.id.post_title);
        content_imageview=(ImageView)findViewById(R.id.post_item_image);
        date_dateview=(TextView)findViewById(R.id.post_date);
        post_content=(TextView)findViewById(R.id.post_content);
        heartbutton = (Button)findViewById(R.id.heart_button);
        comment_submitbutton=(Button)findViewById(R.id.comment_submit_button);
        heartbutton.setOnClickListener(this);
        comment_list.setAdapter(commentListAdapter);
        post_content.setText("post안의 content text 설정");
        date_dateview.setText("날짜");
        title_textview.setText(name+"님의"+title);
        comment_listArrayList.add(new comment_item(R.mipmap.ic_launcher,"ㅇㅇ진짜로"));
        comment_listArrayList.add(new comment_item(R.mipmap.ic_launcher,"열심히 안하냐"));
        comment_listArrayList.add(new comment_item(R.mipmap.ic_launcher,"구라아닌거 같은데?"));
        comment_listArrayList.add(new comment_item(R.mipmap.ic_launcher,"에휴 나도 해야하는데 부럽다."));





    }
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.heart_button :
                break;
            case R.id.comment_submit_button :
                EditText editText = (EditText)findViewById(R.id.comment_mycomment);
                comment_mycontent=editText.getText().toString();
                comment_listArrayList.add(new comment_item(R.mipmap.ic_launcher,comment_mycontent));
                break;
        }
    }








}

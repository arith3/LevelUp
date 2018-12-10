package na.mo.ri.levelup;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class inGroup_info extends AppCompatActivity {


    private String ingroup_content;
    private String ingroup_title;
    private String ingroup_info_desire1;
    private String ingroup_info_desire2;
    private String ingroup_info_desire3;
    private ImageView ingroup_info_image;
    private TextView ingroup_info_contenttextview;
    private TextView ingroup_info_titletextview;
    private TextView ingroup_info_desire1textview;
    private TextView ingroup_info_desire2textview;
    private TextView ingroup_info_desire3textview;

    FirebaseDatabase database=FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingroup_info);
        ingroup_info_contenttextview=(TextView)findViewById(R.id.ingroup_content);
        ingroup_info_desire1textview=(TextView)findViewById(R.id.ingroup_info_desire1);
        ingroup_info_desire2textview=(TextView)findViewById(R.id.ingroup_info_desire2);
        ingroup_info_desire3textview=(TextView)findViewById(R.id.ingroup_info_desire3);
        ingroup_info_titletextview=(TextView)findViewById(R.id.ingroup_info_title);
        ingroup_info_image=(ImageView)findViewById(R.id.ingroup_info_img);



        if (GetUserData.inView_Group.equals(GetUserData.com1[0])) {
            ingroup_info_titletextview.setText(GetUserData.com1[1]);
            ingroup_info_desire1textview.setText(GetUserData.com1[2]);
            ingroup_info_desire2textview.setText(GetUserData.com1[3]);
            ingroup_info_desire3textview.setText(GetUserData.com1[4]);
            ingroup_info_contenttextview.setText(GetUserData.com1[5]);
            //ingroup_info_image.setImageResource();
        }
        else if(GetUserData.inView_Group.equals(GetUserData.com2[0])) {
            ingroup_info_titletextview.setText(GetUserData.com2[1]);
            ingroup_info_desire1textview.setText(GetUserData.com2[2]);
            ingroup_info_desire2textview.setText(GetUserData.com2[3]);
            ingroup_info_desire3textview.setText(GetUserData.com2[4]);
            ingroup_info_contenttextview.setText(GetUserData.com2[5]);
            //ingroup_info_image.setImageResource();
        }
        else{
            ingroup_info_titletextview.setText(GetUserData.com3[1]);
            ingroup_info_desire1textview.setText(GetUserData.com3[2]);
            ingroup_info_desire2textview.setText(GetUserData.com3[3]);
            ingroup_info_desire3textview.setText(GetUserData.com3[4]);
            ingroup_info_contenttextview.setText(GetUserData.com3[5]);
            //ingroup_info_image.setImageResource();
        }


/*
        ingroup_info_titletextview.setText("제목");
        ingroup_info_desire1textview.setText("욕구1내용");
        ingroup_info_desire2textview.setText("욕구2내용");
        ingroup_info_desire3textview.setText("욕구3내용");
        ingroup_info_contenttextview.setText("자기소개내용");
*/


    }









}

package na.mo.ri.levelup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
    Button gaip;
    private UserData udt;
    int btnclick = 0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingroup_info);
        ingroup_info_contenttextview=(TextView)findViewById(R.id.ingroup_content);
        ingroup_info_desire1textview=(TextView)findViewById(R.id.ingroup_info_desire1);
        ingroup_info_desire2textview=(TextView)findViewById(R.id.ingroup_info_desire2);
        ingroup_info_desire3textview=(TextView)findViewById(R.id.ingroup_info_desire3);
        ingroup_info_titletextview=(TextView)findViewById(R.id.ingroup_info_title);
        ingroup_info_image=(ImageView)findViewById(R.id.ingroup_info_img);

        System.out.println("SUZUKAZE DATA------------" + Suzukaze.Aoba[0]);
        System.out.println("SUZUKAZE DATA------------" + Suzukaze.Aoba[1]);
        System.out.println("SUZUKAZE DATA------------" + Suzukaze.Aoba[2]);
        System.out.println("SUZUKAZE DATA------------" + Suzukaze.Aoba[3]);
        System.out.println("SUZUKAZE DATA------------" + Suzukaze.Aoba[4]);
        System.out.println("SUZUKAZE DATA------------" + Suzukaze.Aoba[5]);
        System.out.println("SUZUKAZE DATA------------" + Suzukaze.Aoba[6]);
        System.out.println("SUZUKAZE DATA------------" + Suzukaze.Aoba[7]);
        System.out.println("SUZUKAZE DATA------------" + Suzukaze.Aoba[8]);

        ingroup_info_titletextview.setText(Suzukaze.Aoba[1]);
        ingroup_info_desire1textview.setText(Suzukaze.Aoba[2]);
        ingroup_info_desire2textview.setText(Suzukaze.Aoba[3]);
        ingroup_info_desire3textview.setText(Suzukaze.Aoba[4]);
        ingroup_info_contenttextview.setText(Suzukaze.Aoba[5]);

        udt = new UserData(GetUserData.email);

        gaip = findViewById(R.id.gagaip);
        gaip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "onClick!", Toast.LENGTH_SHORT).show();
                if(udt.easyComSet(Suzukaze.Aoba)) {
                    udt.hitoCountInc(Suzukaze.groupNum);
                    Toast.makeText(getApplicationContext(), "커뮤니티 가입 완료!", Toast.LENGTH_SHORT).show();
                    Intent backToTheFuture = new Intent(getApplicationContext(), MyCommunityActivity.class);
                    startActivity(backToTheFuture);
                    Suzukaze.ini();
                    finish();
                } else {
                    if(btnclick > 0) {
                        Intent backToTheFuture = new Intent(getApplicationContext(), MyCommunityActivity.class);
                        startActivity(backToTheFuture);
                        Suzukaze.ini();
                        finish();
                    }
                    Toast.makeText(getApplicationContext(), "가입 가능 커뮤니티 초과!", Toast.LENGTH_SHORT).show();
                    gaip.setText("내 커뮤니티 목록으로 돌아가기");
                    btnclick++;
                }
            }
        });

//        if (GetUserData.inView_Group.equals(GetUserData.com1[0])) {
//            ingroup_info_titletextview.setText(GetUserData.com1[1]);
//            ingroup_info_desire1textview.setText(GetUserData.com1[2]);
//            ingroup_info_desire2textview.setText(GetUserData.com1[3]);
//            ingroup_info_desire3textview.setText(GetUserData.com1[4]);
//            ingroup_info_contenttextview.setText(GetUserData.com1[5]);
//            //ingroup_info_image.setImageResource();
//        }
//        else if(GetUserData.inView_Group.equals(GetUserData.com2[0])) {
//            ingroup_info_titletextview.setText(GetUserData.com2[1]);
//            ingroup_info_desire1textview.setText(GetUserData.com2[2]);
//            ingroup_info_desire2textview.setText(GetUserData.com2[3]);
//            ingroup_info_desire3textview.setText(GetUserData.com2[4]);
//            ingroup_info_contenttextview.setText(GetUserData.com2[5]);
//            //ingroup_info_image.setImageResource();
//        }
//        else{
//            ingroup_info_titletextview.setText(GetUserData.com3[1]);
//            ingroup_info_desire1textview.setText(GetUserData.com3[2]);
//            ingroup_info_desire2textview.setText(GetUserData.com3[3]);
//            ingroup_info_desire3textview.setText(GetUserData.com3[4]);
//            ingroup_info_contenttextview.setText(GetUserData.com3[5]);
//            //ingroup_info_image.setImageResource();
//        }
//

/*
        ingroup_info_titletextview.setText("제목");
        ingroup_info_desire1textview.setText("욕구1내용");
        ingroup_info_desire2textview.setText("욕구2내용");
        ingroup_info_desire3textview.setText("욕구3내용");
        ingroup_info_contenttextview.setText("자기소개내용");
*/


    }









}

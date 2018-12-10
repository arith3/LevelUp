package na.mo.ri.levelup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Date;

import static java.lang.Math.toIntExact;


public class Reenter extends AppCompatActivity implements View.OnClickListener {
    private String email;
    private String user;
    private int community_cnt;
    private String communityname;
    private String reenter_title;
    private String reenter_content;
    private EditText reentertextview;
    private EditText reentercontentview;
    private Button reenter_button;
    private int in_group_ppl_count;
    private String group_num="";
    DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference myRef=FirebaseDatabase.getInstance().getReference().child("user");
    ValueEventListener reenterListener = new ValueEventListener() {
        @Override

        public void onDataChange(DataSnapshot dataSnapshot) {
            community_cnt=toIntExact(dataSnapshot.child("community").getChildrenCount());
            for(int i=1;i<=community_cnt;i++){
                if(GetUserData.inView_Group.equals((String)dataSnapshot.child("community").child(Integer.toString(i)).child("name").getValue())){
                    in_group_ppl_count=Integer.parseInt((String)dataSnapshot.child("community").child(Integer.toString(i)).child("ppl_count").getValue());
                    group_num=Integer.toString(i);
                    break;
                    //현재 보고있던 그룹의 이름과 그룹의 이름이 같을때 검색
                }
            }
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {
            // Getting Post failed, log a message
            Log.w("post_item", "loadPost:onCancelled", databaseError.toException());
            // ...
        }
    };
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_reenter_k);
        reentertextview=(EditText) findViewById(R.id.reenter_title);
        reentercontentview=(EditText)findViewById(R.id.reenter_content);
        reenter_button=(Button)findViewById(R.id.reenter_button);
        reenter_button.setOnClickListener(this);

    }

    public void onClick(View v) {

        switch (v.getId()){
            case R.id.reenter_button :




                if(GetUserData.com1[0].equals("1")){

                    myRef.child(GetUserData.key).child("cList").child("com1").child("goal0").setValue(GetUserData.inView_Group);
                    myRef.child(GetUserData.key).child("cList").child("com1").child("goal1").setValue(reentertextview.getText().toString());
                    myRef.child(GetUserData.key).child("cList").child("com1").child("goal5").setValue(reentercontentview.getText().toString());
                    rootRef.child("community").child(group_num).child("ppl_count").setValue(Integer.toString(in_group_ppl_count+1));
                }
                else if(GetUserData.com2[0].equals("1")){
                    myRef.child(GetUserData.key).child("cList").child("com2").child("goal0").setValue(GetUserData.inView_Group);
                    myRef.child(GetUserData.key).child("cList").child("com2").child("goal1").setValue(reentertextview.getText().toString());
                    myRef.child(GetUserData.key).child("cList").child("com2").child("goal5").setValue(reentercontentview.getText().toString());
                    rootRef.child("community").child(group_num).child("ppl_count").setValue(Integer.toString(in_group_ppl_count+1));
                }
                else if(GetUserData.com3[0].equals("1")){
                    myRef.child(GetUserData.key).child("cList").child("com3").child("goal0").setValue(GetUserData.inView_Group);
                    myRef.child(GetUserData.key).child("cList").child("com3").child("goal1").setValue(reentertextview.getText().toString());
                    myRef.child(GetUserData.key).child("cList").child("com3").child("goal5").setValue(reentercontentview.getText().toString());
                    rootRef.child("community").child(group_num).child("ppl_count").setValue(Integer.toString(in_group_ppl_count+1));
                }
                else{
                    Toast.makeText(Reenter.this, "가입할수 있는 커뮤니티 수 초과!", Toast.LENGTH_SHORT).show();
                }

                Intent intent = new Intent(
                        getApplicationContext(), // 현재 화면의 제어권자
                        inGroup_info.class); // 다음 넘어갈 클래스 지정
                startActivity(intent);
                break;
        }
    }








}

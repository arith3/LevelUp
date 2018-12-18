package na.mo.ri.levelup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Date;

import static java.lang.Math.toIntExact;


public class CommunityTabActivity  extends AppCompatActivity {
    ListView listView;
    ListView rankView;
    MyListAdapter myListAdapter;
    MyRankAdapter myRankAdapter;
    ArrayList<list_item> list_itemArrayList;
    ArrayList<rank_item> rank_itemArrayList;
    int post_cnt=0;
    Toolbar myToolbar;
    DatabaseReference postRef = FirebaseDatabase.getInstance().getReference().child("community").child("1").child("post").child("1");
    DatabaseReference myRef = FirebaseDatabase.getInstance().getReference().child("community").child(GetUserData.inView_Group);
    ValueEventListener postListener = new ValueEventListener() {
        @Override

        public void onDataChange(DataSnapshot dataSnapshot) {
            // Get Post object and use the values to update the U

            list_itemArrayList = new ArrayList<list_item>();

            post_cnt=toIntExact(dataSnapshot.child("post").getChildrenCount());
            for(int i=1;i<=post_cnt;i++){
                list_item temp = new list_item(R.mipmap.ic_launcher,(String)dataSnapshot.child("post").child(GetUserData.inView_Post).child("name").getValue(),(String)dataSnapshot.child("post").child(GetUserData.inView_Post).child("title").getValue(),(String)dataSnapshot.child("post").child(GetUserData.inView_Post).child("date").getValue(),(String)dataSnapshot.child("post").child(GetUserData.inView_Post).child("content").getValue(),Integer.toString(i));

                list_itemArrayList.add(temp);
            }

            // ...
            myListAdapter = new MyListAdapter(CommunityTabActivity.this,list_itemArrayList);
            listView.setAdapter(myListAdapter);

        }

        @Override
        public void onCancelled(DatabaseError databaseError) {
            // Getting Post failed, log a message
            Log.w("post_item", "loadPost:onCancelled", databaseError.toException());
            // ...
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community_tab);

        myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        listView = (ListView)findViewById(R.id.my_listview);
        rankView = (ListView) findViewById(R.id.my_rankview);


        rank_itemArrayList = new ArrayList<rank_item>();
        myRef.addListenerForSingleValueEvent(postListener);
        /*
        list_itemArrayList.add(
                new list_item(R.mipmap.ic_launcher,"보라돌이","제목1",new Date(System.currentTimeMillis()),"내용1"));
        list_itemArrayList.add(
                new list_item(R.mipmap.ic_launcher,"뚜비","제목2",new Date(System.currentTimeMillis()),"내용2"));
        list_itemArrayList.add(
                new list_item(R.mipmap.ic_launcher,"나나","제목3",new Date(System.currentTimeMillis()),"내용3"));
        list_itemArrayList.add(
                new list_item(R.mipmap.ic_launcher,"뽀","제목4",new Date(System.currentTimeMillis()),"내용4"));
        list_itemArrayList.add(
                new list_item(R.mipmap.ic_launcher,"햇님","제목5",new Date(System.currentTimeMillis()),"내용5"));
        */




       rank_itemArrayList.add(
               new rank_item("1위", R.mipmap.ic_launcher,80,"80%"));


        myRankAdapter= new MyRankAdapter(CommunityTabActivity.this, rank_itemArrayList);
        rankView.setAdapter(myRankAdapter);

        TabHost tabHost1 = (TabHost) findViewById(R.id.tabHost1) ;
        tabHost1.setup() ;
        // 첫 번째 Tab. (탭 표시 텍스트:"TAB 1"), (페이지 뷰:"content1")
        TabHost.TabSpec ts1 = tabHost1.newTabSpec("Tab Spec 1") ;
        ts1.setContent(R.id.post_content) ;
        ts1.setIndicator("게시글") ;
        tabHost1.addTab(ts1) ;
        // 두 번째 Tab. (탭 표시 텍스트:"TAB 2"), (페이지 뷰:"content2")
        TabHost.TabSpec ts2 = tabHost1.newTabSpec("Tab Spec 2") ;
        ts2.setContent(R.id.lank_content) ;
        ts2.setIndicator("그룹원 랭킹") ;
        tabHost1.addTab(ts2) ;
        // 세 번째 Tab. (탭 표시 텍스트:"TAB 3"), (페이지 뷰:"content3")
        TabHost.TabSpec ts3 = tabHost1.newTabSpec("Tab Spec 3") ;
        ts3.setContent(R.id.photo_content) ;
        ts3.setIndicator("인증샷") ;
        tabHost1.addTab(ts3) ;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    //추가된 소스, ToolBar에 추가된 항목의 select 이벤트를 처리하는 함수
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //return super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case R.id.action_settings:
                // User chose the "Settings" item, show the app settings UI...
                //Toast.makeText(getApplicationContext(), "나의 정보 버튼 클릭됨", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), UserdataActivity.class);
                startActivity(intent);
                return true;
            case R.id.action_settings2:
                // User chose the "Settings" item, show the app settings UI...
                //Toast.makeText(getApplicationContext(), "수행현황 버튼 클릭됨", Toast.LENGTH_LONG).show();
                Intent intent1 = new Intent(getApplicationContext(), MyInfoActivity.class);
                startActivity(intent1);
                return true;
            case R.id.action_settings3:
                // User chose the "Settings" item, show the app settings UI...
                Toast.makeText(getApplicationContext(), "로그아웃 버튼 클릭됨", Toast.LENGTH_LONG).show();
                Intent intent2 = new Intent(getApplicationContext(), SignupActivity.class);
                startActivity(intent2);
                return true;
            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                Toast.makeText(getApplicationContext(), "나머지 버튼 클릭됨", Toast.LENGTH_LONG).show();
                return super.onOptionsItemSelected(item);
        }
    }
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.heart_button:
                break;
            case R.id.comment_submit_button:
                break;
        }
    }
}

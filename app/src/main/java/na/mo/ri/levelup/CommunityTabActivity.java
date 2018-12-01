package na.mo.ri.levelup;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TabHost;

import java.util.ArrayList;
import java.util.Date;


public class CommunityTabActivity  extends AppCompatActivity {
    ListView listView;
    MyListAdapter myListAdapter;
    ArrayList<list_item> list_itemArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community_tab);

                listView = (ListView)findViewById(R.id.my_listview);

        list_itemArrayList = new ArrayList<list_item>();

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

        myListAdapter = new MyListAdapter(CommunityTabActivity.this,list_itemArrayList);
        listView.setAdapter(myListAdapter);

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
        // 네 번째 Tab. (탭 표시 텍스트:"TAB 4"), (페이지 뷰:"content4")
        TabHost.TabSpec ts4 = tabHost1.newTabSpec("Tab Spec 4") ;
        ts4.setContent(R.id.mypage_content) ;
        ts4.setIndicator("나의 정보") ;
        tabHost1.addTab(ts4) ;

    }
}

package na.mo.ri.levelup;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyListAdapter extends BaseAdapter {
    Context context;
    ArrayList<list_item> list_itemArrayList;

    TextView nickname_textView;
    TextView title_textView;
    TextView date_textView;
    TextView content_textView;
    ImageView profile_imageView;

    public MyListAdapter(Context context, ArrayList<list_item> list_itemArrayList) {
        this.context = context;

        this.list_itemArrayList = list_itemArrayList;
    }
    @Override
    public int getCount() {
        return this.list_itemArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return list_itemArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){

            convertView = LayoutInflater.from(context).inflate(R.layout.list_item,null);
            nickname_textView = (TextView)convertView.findViewById(R.id.nickname_textView);
            content_textView = (TextView)convertView.findViewById(R.id.content_textView);
            date_textView = (TextView)convertView.findViewById(R.id.date_textView);
            title_textView  =(TextView)convertView.findViewById(R.id.title_textView);
            profile_imageView = (ImageView)convertView.findViewById(R.id.profile_imageView);
        }
        nickname_textView.setText(list_itemArrayList.get(position).getNickname());
        title_textView.setText(list_itemArrayList.get(position).getTitle());
        content_textView.setText(list_itemArrayList.get(position).getContent());
        date_textView.setText(list_itemArrayList.get(position).getWrite_date().toString());
        profile_imageView.setImageResource(list_itemArrayList.get(position).getProfile_image());
        title_textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                GetUserData.inView_Post = list_itemArrayList.get(position).getNum();
                //Toast.makeText(getApplicationContext(), "클릭한 position: " + position, Toast.LENGTH_SHORT).show();
                context.startActivity(new Intent(context, post_item.class));
            }
        });
        return convertView;
    }
}

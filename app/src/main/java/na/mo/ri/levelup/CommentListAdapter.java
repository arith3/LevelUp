package na.mo.ri.levelup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CommentListAdapter extends BaseAdapter {
    Context context;
    ArrayList<comment_item> comment_itemArrayList;
    TextView comment_textView;
    ImageView comment_item_imgView;

    public CommentListAdapter(Context context, ArrayList<comment_item> comment_itemArrayList) {
        this.context = context;
        this.comment_itemArrayList = comment_itemArrayList;
    }
    @Override
    public int getCount() {
        return this.comment_itemArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return comment_itemArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item,null);
            comment_textView=(TextView)convertView.findViewById(R.id.comment_item_context);
            comment_item_imgView = (ImageView)convertView.findViewById(R.id.comment_item_img);
        }
        comment_textView.setText(comment_itemArrayList.get(position).getComment_content());
        comment_item_imgView.setImageResource(comment_itemArrayList.get(position).getComment_image());
        return convertView;
    }
}

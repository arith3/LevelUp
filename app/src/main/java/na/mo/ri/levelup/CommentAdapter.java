package na.mo.ri.levelup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

public class CommentAdapter extends BaseAdapter {
    Context context;
    ArrayList<comment_item> comment_itemArrayList;

    ImageView icon;
    TextView comment_context;

    public CommentAdapter(Context context, ArrayList<comment_item> comment_itemArrayList){
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
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.comment_item, null);
            icon = (ImageView) convertView.findViewById(R.id.comment_item_img);
            comment_context = (TextView) convertView.findViewById(R.id.comment_item_context);
        }
        icon.setImageResource(comment_itemArrayList.get(position).getComment_image());

        comment_context.setText(comment_itemArrayList.get(position).getComment_content());
        return convertView;
    }
}

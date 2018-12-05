package na.mo.ri.levelup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MyRankAdapter extends BaseAdapter {

    Context context;
    ArrayList<rank_item> rank_itemArrayList;

    TextView lankText;
    ImageView lankImage;
    TextView lankPercentText;
    ProgressBar lankProgressbar;

    public MyRankAdapter(Context context, ArrayList<rank_item> rank_itemArrayList){
        this.context = context;
        this.rank_itemArrayList = rank_itemArrayList;
    }

    @Override
    public int getCount() {
        return this.rank_itemArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return rank_itemArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.rank_item,null);
            lankText = (TextView)convertView.findViewById(R.id.lankText);
            lankImage = (ImageView)convertView.findViewById(R.id.lankImage);
            lankPercentText = (TextView)convertView.findViewById(R.id.lankPercentText);
            lankProgressbar = (ProgressBar)convertView.findViewById(R.id.lankProgressbar);
        }
        lankText.setText(rank_itemArrayList.get(position).getLankText());
        lankImage.setImageResource(rank_itemArrayList.get(position).getLankImage());
        lankPercentText.setText(rank_itemArrayList.get(position).getLankPercentText());
        lankProgressbar.setProgress(rank_itemArrayList.get(position).getLankProgressbar());
        return convertView;
    }
}

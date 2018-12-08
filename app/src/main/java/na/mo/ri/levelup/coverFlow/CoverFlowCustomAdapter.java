package na.mo.ri.levelup.coverFlow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import na.mo.ri.levelup.R;

public class CoverFlowCustomAdapter extends BaseAdapter {
    //ListView 기반의 BaseAdaoter를 사용한다.
    //데이터를 넣어줘서 각각의 Item을 생성한다
    private ArrayList<DoWorkEntity> mData = new ArrayList<>(0);
    private Context mContext;

    public CoverFlowCustomAdapter(Context context) {
        mContext = context;
    }

    public void setData(ArrayList<DoWorkEntity> data) {
        mData = data;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int pos) {
        return mData.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        return pos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View rowView = convertView;

        if (rowView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.corver_item_row, null);

            ViewHolder viewHolder = new ViewHolder();
            viewHolder.text = (TextView) rowView.findViewById(R.id.label);
            viewHolder.image = (ImageView) rowView
                    .findViewById(R.id.image);
            rowView.setTag(viewHolder);
        }

        ViewHolder holder = (ViewHolder) rowView.getTag();

        holder.image.setImageResource(mData.get(position).getImageResId());
        holder.text.setText(mData.get(position).getTitleResId());

        return rowView;
    }


    static class ViewHolder {
        public TextView text;
        public ImageView image;
    }
}

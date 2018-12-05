package na.mo.ri.levelup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

public class MyDreamAdapter extends BaseAdapter {
    Context context;
    ArrayList<dream_item> dream_itemArrayList;

    RadioButton doCheck;
    TextView getDate;
    TextView getGoal;

    public MyDreamAdapter(Context context, ArrayList<dream_item> dream_itemArrayList){
        this.context = context;
        this.dream_itemArrayList = dream_itemArrayList;
    }

    @Override
    public int getCount() {
        return this.dream_itemArrayList.size();
    }
    @Override
    public Object getItem(int position) {
        return dream_itemArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.dream_item, null);
            doCheck = (RadioButton) convertView.findViewById(R.id.doCheck);
            getDate = (TextView) convertView.findViewById(R.id.getDate);
            getGoal = (TextView) convertView.findViewById(R.id.getGoal);
        }
        doCheck.setChecked(dream_itemArrayList.get(position).isDoCheck());
        getDate.setText(dream_itemArrayList.get(position).getGetDate());
        getGoal.setText(dream_itemArrayList.get(position).getGetGoal());
        return convertView;
    }
}

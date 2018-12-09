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
    /*
    ㅅㅓ준님 보세요 유저데이터에 쓰는법!!
    데이터 가져오는법: GetUserData의 static 변수들 활용, null인 경우가 가끔 있어서 if로 null일 경우 na@mo.ri 이메일 넣기
    GetUserData는 static으로만 접근하기 때문에 절대 객체 생성하지 마세요!!
    데이터 DB에 넣는법: String[9] array 생성, UserData object생성.
                      String array에 값을 넣고 easyComSet() 메소드에 넣기(자동으로 업로드함)
                      ~Sample code~
                      UserData ud;
                      String[] arraySample = {"1","1","1","1","1","1","1","1","1"};
                      (onCreate내부)
                      ud = new UserData(eMail);
                      arraySample값 접근, 변경
                      ud.easyComSet(arraySample);
     */
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

        //holder.image.setImageResource(mData.get(position).getImageResId());
        holder.image.setImageResource(R.drawable.coverimage);
        holder.text.setText(mData.get(position).getTitleResId());

        return rowView;
    }


    static class ViewHolder {
        public TextView text;
        public ImageView image;
    }
}

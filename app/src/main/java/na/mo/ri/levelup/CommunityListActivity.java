package na.mo.ri.levelup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class CommunityListActivity extends AppCompatActivity {

    private LinearLayout container;
    private Button searccc;
    private EditText searchhh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community_list);

        container = (LinearLayout) findViewById(R.id.parent);
        LinearLayout.LayoutParams params = new LinearLayout.
                LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(50, 30, 50, 30);
    }
}

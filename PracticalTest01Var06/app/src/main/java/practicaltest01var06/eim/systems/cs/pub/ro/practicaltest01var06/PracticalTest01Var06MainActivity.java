package practicaltest01var06.eim.systems.cs.pub.ro.practicaltest01var06;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;

public class PracticalTest01Var06MainActivity extends AppCompatActivity {

    private Button detail_button = null;
    private GridLayout gridLayout = null;
    private EditText web_address = null;
    private Button ok_button = null;

    private boolean visible = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var06_main);

        detail_button = (Button)findViewById(R.id.detail_button);
        gridLayout = (GridLayout)findViewById(R.id.gridLayout);
        web_address = (EditText)findViewById(R.id.web_address);
        ok_button = (Button)findViewById(R.id.ok_button);

        detail_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (visible) {
                    gridLayout.setVisibility(View.INVISIBLE);
                    visible = false;
                    detail_button.setText("Less details");
                } else {
                    gridLayout.setVisibility(View.VISIBLE);
                    visible = true;
                    detail_button.setText("More details");
                }
            }
        });

        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey("web_address")) {
                web_address.setText(savedInstanceState.getString("web_address"));
            }
        } else {
            web_address.setText("http://");
        }
    }


    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString("web_address", web_address.getText().toString());
        Log.println (Log.DEBUG, "DEBUG" ,"onSaveInstance was called");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState.containsKey("web_address")) {
            web_address.setText(savedInstanceState.getString("web_address"));
        }
    }
}

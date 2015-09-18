package neuq.edu.pokerface.tulingchat.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import neuq.edu.pokerface.tulingchat.R;
import neuq.edu.pokerface.tulingchat.model.Data;
import neuq.edu.pokerface.tulingchat.util.ChatUtil;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends Activity {

    static final String KEY = "823098b74cf1c8d9dc62c55f79441df5";
    private String info;
    private EditText editText;
    private Button button;
    private TextView txtInfo;
    private TextView txtReceived;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.btn_input);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText = (EditText) findViewById(R.id.edit_input);
                info = editText.getText().toString();

                txtInfo = (TextView) findViewById(R.id.txt_input);
                txtReceived = (TextView) findViewById(R.id.txt_receive);

                if (!info.isEmpty()) {
                    ChatUtil.service.getData(KEY, info, new Callback<Data>() {
                        @Override
                        public void success(Data data, Response response) {
                            Log.e("------code-----", String.valueOf(data.getCode()));
                            //Log.e("------text-----", data.getText());

                            txtInfo.setText(info);
                            txtInfo.setVisibility(View.VISIBLE);
                            txtReceived.setText(data.getText());
                            txtReceived.setVisibility(View.VISIBLE);

                        }

                        @Override
                        public void failure(RetrofitError error) {

                        }
                    });
                }
            }
        });

    }
}

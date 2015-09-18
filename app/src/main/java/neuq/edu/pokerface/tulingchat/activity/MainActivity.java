package neuq.edu.pokerface.tulingchat.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import neuq.edu.pokerface.tulingchat.R;
import neuq.edu.pokerface.tulingchat.model.Data;
import neuq.edu.pokerface.tulingchat.util.ChatUtil;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends Activity {

    static final String KEY = "de5ad10269d30982903b48df4aaec722";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String info = "你是谁";

        ChatUtil.service.getData(KEY, info, new Callback<Data>() {
            @Override
            public void success(Data data, Response response) {
                Log.e("---------code-------", String.valueOf(data.getCode()));
                Log.e("---------text-------", data.getText());
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });

    }
}

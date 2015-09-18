package neuq.edu.pokerface.tulingchat.util;

import neuq.edu.pokerface.tulingchat.model.Data;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by PokerFace on 2015/9/17.
 */
public class ChatUtil {

    static final String ENDPOINT = "http://www.tuling123.com/openapi";

    public interface ChatService {
        @GET("/api")
        void getData(@Query("key")String key, @Query("info")String info, Callback<Data> callback);
    }

    static RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(ENDPOINT).build();

    static public ChatService service = restAdapter.create(ChatService.class);

}

package neuq.edu.pokerface.tulingchat.model;

import com.google.gson.annotations.Expose;

/**
 * Created by PokerFace on 2015/9/17.
 */
public class Data {

    @Expose
    private int code;

    @Expose
    private String text;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

package sk.azetbattle.btmessenger;

import io.realm.RealmObject;

/**
 * Created by droma on 20.05.2016.
 */
public class Message extends RealmObject {

    private User sender;
    private User receiver;
    private String text;
    private Long time;
    private String mac;


    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User me) {
        this.receiver = me;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public User getSender() {
        return sender;
    }

    public String getText() {
        return text;
    }

    public Long getTime() {
        return time;
    }
}

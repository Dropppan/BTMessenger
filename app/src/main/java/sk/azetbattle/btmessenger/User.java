package sk.azetbattle.btmessenger;

import io.realm.RealmObject;

/**
 * Created by droma on 20.05.2016.
 */
public class User extends RealmObject {

    private String name;

    public void setName(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

}

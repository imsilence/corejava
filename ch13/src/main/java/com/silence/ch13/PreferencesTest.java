package com.silence.ch13;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.prefs.Preferences;
import java.util.prefs.BackingStoreException;

public class PreferencesTest {
    public static void main( String[] args ) throws FileNotFoundException, IOException, BackingStoreException {

        Preferences node = Preferences.userNodeForPackage(Main.class);

        String user = node.get("user", "kk");
        String name = node.get("name", "test_preferences");
        int version = node.getInt("version", 0);

        System.out.println(user);
        System.out.println(name);
        System.out.println(version);


        node.put("user", "kk");
        node.put("name", "test_preferences");
        node.putInt("version", version + 1);

        try(FileOutputStream stream = new FileOutputStream("text.xml")) {
            node.exportSubtree(stream);
        }


        Preferences systemnode = Preferences.systemNodeForPackage(Main.class);

        systemnode.put("user", "kk");
        systemnode.put("name", "test_system_preferences");
    }
}

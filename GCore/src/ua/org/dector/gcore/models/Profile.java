package ua.org.dector.gcore.models;

import com.badlogic.gdx.files.FileHandle;

/**
 * @author dector (dector9@gmail.com)
 */
public class Profile {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Profile fromFile(FileHandle file) {
        Profile profile = new Profile();

        // TODO Mock
        profile.setName(file.readString());

        return profile;
    }
}

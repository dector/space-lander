package ua.org.dector.gcore.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;
import ua.org.dector.gcore.models.Profile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author dector (dector9@gmail.com)
 */
public class ProfileManager {
    private List<Profile> profiles;

    public ProfileManager() {
        createProfilesStorage(1);
    }

    private void createProfilesStorage(int size) {
        profiles = new ArrayList<Profile>(size);
    }

    public void loadFromFiles(String profilesDir) {
        FileHandle profDir = Gdx.files.internal(profilesDir);
        if (! profDir.exists() || ! profDir.isDirectory()) return;
        
        FileHandle[] profiles = profDir.list();

        createProfilesStorage(profiles.length);

        Json json;
        FileHandle profile;
        // TODO find other way to sort filenames
        // Reversing
        for (int i = profiles.length - 1; i >= 0; i--) {
            profile = profiles[i];
            json = new Json();
            addProfile(json.fromJson(Profile.class, profile));
        }
    }

    private void addProfile(Profile profile) {
        profiles.add(profile);
    }

    public Profile[] getProfiles() {
        Profile[] profilesArray = new Profile[getProfilesCount()];
        profiles.toArray(profilesArray);
        return profilesArray;
    }

    public int getProfilesCount() {
        return profiles.size();
    }
}

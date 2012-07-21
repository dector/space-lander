package ua.org.dector.gcore.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import ua.org.dector.gcore.models.Profile;

import java.util.ArrayList;
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
        FileHandle[] profiles = profDir.list();

        createProfilesStorage(profiles.length);
        for (FileHandle profile : profiles) {
            addProfile(Profile.fromFile(profile));
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

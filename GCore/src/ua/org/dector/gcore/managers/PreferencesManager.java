/**
 * Copyright (c) 2012, dector (dector9@gmail.com) All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 *
 *  - Neither the name of the nor the names of its
 * contributors may be used to endorse or promote products derived
 * from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package ua.org.dector.gcore.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

/**
 * @author dector (dector9@gmail.com)
 */
public class PreferencesManager {
    private Preferences preferences;

    public PreferencesManager(String preferencesName) {
        preferences = Gdx.app.getPreferences(preferencesName);
    }

    public boolean getBoolean(String name, boolean defaultValue) {
        return preferences.getBoolean(name, defaultValue);
    }

    public int getInt(String name, int defaultValue) {
        return preferences.getInteger(name, defaultValue);
    }

    public float getFloat(String name, float defaultValue) {
        return preferences.getFloat(name, defaultValue);
    }

    public String getString(String name, String defaultValue) {
        return preferences.getString(name, defaultValue);
    }

    public void putBoolean(String name, boolean value) {
        preferences.putBoolean(name, value);
        save();
    }

    public void putInt(String name, int value) {
        preferences.putInteger(name, value);
        save();
    }

    public void putFloat(String name, float value) {
        preferences.putFloat(name, value);
        save();
    }

    public void putString(String name, String value) {
        preferences.putString(name, value);
        save();
    }

    public void save() {
        preferences.flush();
    }
}

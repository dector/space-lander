/**
 * Copyright (c) 2012, dector (dector9@gmail.com)
 * All rights reserved.
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

package ua.org.dector.gcore.common;

import ua.org.dector.gcore.managers.PreferencesManager;

/**
 * @author dector (dector9@gmail.com)
 */
public class Settings {
    // Music/Sounds
    private static final String MUSIC_VOLUME    = "music.volume";
    private static final String MUSIC_ENABLED   = "music.enabled";
    private static final String SFX_VOLUME      = "sfx.volume";
    private static final String SFX_ENABLED     = "sfx.enabled";

    private static final float DEFAULT_MUSIC_VOLUME     = 1;
    private static final boolean DEFAULT_MUSIC_ENABLED  = true;
    private static final float DEFAULT_SFX_VOLUME       = 1;
    private static final boolean DEFAULT_SFX_ENABLED    = true;

    // Screen
    private static final String SCREEN_WIDTH    = "screen.width";
    private static final String SCREEN_HEIGHT   = "screen.height";
    private static final String SCREEN_FULLSCREEN = "screen.fullscreen";

    private static final int DEFAULT_SCREEN_WIDTH       = 800;
    private static final int DEFAULT_SCREEN_HEIGHT      = 600;
    private static final boolean DEFAULT_SCREEN_FULLSCREEN = false;

    private PreferencesManager prefs;

    public Settings(String filename) {
        prefs = new PreferencesManager(filename);
    }

    public float getMusicVolume() {
        return prefs.getFloat(MUSIC_VOLUME, DEFAULT_MUSIC_VOLUME);
    }

    public void setMusicVolume(float volume) {
        prefs.putFloat(MUSIC_VOLUME, volume);
    }

    public float getSfxVolume() {
        return prefs.getFloat(SFX_VOLUME, DEFAULT_SFX_VOLUME);
    }

    public void setSfxVolume(float volume) {
        prefs.putFloat(SFX_VOLUME, volume);
    }

    public boolean isMusicEnabled() {
        return prefs.getBoolean(MUSIC_ENABLED, DEFAULT_MUSIC_ENABLED);
    }

    public void setMusicEnabled(boolean enabled) {
        prefs.putBoolean(MUSIC_ENABLED, enabled);
    }

    public boolean isSfxEnabled() {
        return prefs.getBoolean(SFX_ENABLED, DEFAULT_SFX_ENABLED);
    }

    public void setSfxEnabled(boolean enabled) {
        prefs.putBoolean(SFX_ENABLED, enabled);
    }

    public int getScreenWidth() {
        return prefs.getInt(SCREEN_WIDTH, DEFAULT_SCREEN_WIDTH);
    }

    public int getScreenHeight() {
        return prefs.getInt(SCREEN_HEIGHT, DEFAULT_SCREEN_HEIGHT);
    }

    public boolean isFullscreen() {
        return prefs.getBoolean(SCREEN_FULLSCREEN, DEFAULT_SCREEN_FULLSCREEN);
    }

    public void setScreenWidth(int width) {
        prefs.putInt(SCREEN_WIDTH, width);
    }

    public void setScreenHeight(int height) {
        prefs.putInt(SCREEN_HEIGHT, height);
    }

    public void setFullscreen(boolean fullscreen) {
        prefs.putBoolean(SCREEN_FULLSCREEN, fullscreen);
    }

    public void save() {
        prefs.save();
    }
}

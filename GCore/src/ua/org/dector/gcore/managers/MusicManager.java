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

package ua.org.dector.gcore.managers;

import com.badlogic.gdx.audio.Music;
import ua.org.dector.gcore.utils.ResourceLoader;

/**
 * @author dector (dector9@gmail.com)
 */
public class MusicManager extends AudioManager {
    private String musicFile;
    private Music music;

    private ResourceLoader loader;

    public MusicManager(ResourceLoader loader) {
        super();
        this.loader = loader;
    }

    public MusicManager(ResourceLoader loader, float volume) {
        super(volume);
        this.loader = loader;
    }

    public MusicManager(ResourceLoader loader, float volume, boolean enabled) {
        super(volume, enabled);
        this.loader = loader;
    }

    protected void init() {}

    private Music getMusic() {
        return music;
    }

    public void play(String musicFile, boolean loop) {

        if (this.musicFile != null) {
            if (this.musicFile.equals(musicFile)) {
                play();
                return;
            } else {
                getMusic().dispose();
            }
        }

        this.musicFile = musicFile;
        music = loader.loadMusic(musicFile);
        music.setVolume(getVolume());
        music.setLooping(loop);

        play();
    }

    public void play() {
        if (musicIsNull()) return;
        if (getMusic().isPlaying()) return;
        if (! isEnabled()) return;

        getMusic().play();
    }

    public void pause() {
        if (musicIsNull()) return;
        if (! getMusic().isPlaying()) return;

        getMusic().pause();
    }

    public void setVolume(float volume) {
        super.setVolume(volume);

        if (musicIsNull()) return;

        getMusic().setVolume(getVolume());
    }

    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);

        if (isEnabled())
            play();
        else
            pause();
    }

    public void dispose() {
        if (musicIsNull()) return;

        music.dispose();
        music = null;
    }

    private boolean musicIsNull() {
        return getMusic() == null;
    }
}

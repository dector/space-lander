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

import com.badlogic.gdx.audio.Sound;
import ua.org.dector.gcore.utils.ResourceLoader;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dector (dector9@gmail.com)
 */
public class SoundManager extends AudioManager {
    private Map<String, Sound> sounds;
    private ResourceLoader loader;

    public SoundManager(ResourceLoader loader, float volume) {
        super(volume);
        setLoader(loader);
    }

    public SoundManager(ResourceLoader loader, float volume, boolean enabled) {
        super(volume, enabled);
        setLoader(loader);
    }

    public SoundManager(ResourceLoader loader) {
        super();
        setLoader(loader);
    }

    private void setLoader(ResourceLoader loader) {
        this.loader = loader;
    }

    protected void init() {
        sounds = new HashMap<String, Sound>();
    }

    private Sound addSound(String soundFile, Sound sound) {

        return sound;
    }

    public Sound getSound(String soundFile) {
        Sound sound;

        if (sounds.containsKey(soundFile)) {
            sound = sounds.get(soundFile);
        } else {
            sound = loader.loadSound(soundFile);
            sounds.put(soundFile, sound);
        }

        return sound;
    }

    public void play(String soundFile) {
        play(soundFile, false);
    }

    public void loop(String soundFile) {
        play(soundFile, true);
    }

    public void play(String soundFile, boolean loop) {
        if (! isEnabled()) return;

        Sound sound = getSound(soundFile);

        if (loop)
            sound.loop(getVolume());
        else
            sound.play(getVolume());
    }

    public void stop(String soundFile) {
        if (! sounds.containsKey(soundFile)) return;

        sounds.get(soundFile).stop();
    }

    public void dispose() {
        for (String soundFile : sounds.keySet())
            getSound(soundFile).dispose();
    }

    public void stopAll() {
        for (String soundFile : sounds.keySet()) {
            stop(soundFile);
        }
    }
}

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

package ua.org.dector.gcore.game;

import com.badlogic.gdx.Game;
import ua.org.dector.gcore.core.Graphics;
import ua.org.dector.gcore.core.GraphicsImpl;
import ua.org.dector.gcore.utils.ResourceLoader;
import ua.org.dector.gcore.managers.MusicManager;
import ua.org.dector.gcore.managers.SoundManager;

/**
 * Base game application
 *
 * @author dector (dector9@gmail.com)
 */
public abstract class AbstractGame extends Game {
    private SoundManager soundManager;
    private MusicManager musicManager;
    private ResourceLoader resourceLoader;

    private Graphics g;

    public void create() {
        resourceLoader = new ResourceLoader();

        soundManager = new SoundManager(resourceLoader);
        musicManager = new MusicManager();

        g = new GraphicsImpl(this);
    }

    public SoundManager getSoundManager() {
        return soundManager;
    }

    public MusicManager getMusicManager() {
        return musicManager;
    }

    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }

    public Graphics getGraphics() {
        return g;
    }

    public void dispose() {
        super.dispose();

        g.dispose();

        musicManager.dispose();
        soundManager.dispose();
    }
}

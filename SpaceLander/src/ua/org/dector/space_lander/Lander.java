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

package ua.org.dector.space_lander;

import com.badlogic.gdx.Gdx;
import ua.org.dector.gcore.common.Settings;
import ua.org.dector.gcore.game.AbstractGame;
import ua.org.dector.gcore.game.AbstractScreen;
import ua.org.dector.gcore.utils.ResourceLoader;
import ua.org.dector.space_lander.constants.Directories;
import ua.org.dector.space_lander.screens.MainMenuScreen;
import ua.org.dector.space_lander.screens.SplashScreen;

/**
 * @author dector (dector9@gmail.com)
 */
public class Lander extends AbstractGame {
    private static final String SETTINGS_FILENAME = "SpaceLander";

    public static final boolean DEV_MODE = true;

    private Settings settings;

    public void create() {
        super.create();

        settings = new Settings(SETTINGS_FILENAME);

        getMusicManager().setEnabled(settings.isMusicEnabled());
        getMusicManager().setVolume(settings.getMusicVolume());

        getSoundManager().setEnabled(settings.isSfxEnabled());
        getSoundManager().setVolume(settings.getSfxVolume());

        ResourceLoader resLoader = getResourceLoader();
        resLoader.setImagesDirPath(Directories.IMAGES);
        resLoader.setFontsDirPath(Directories.FONTS);
        resLoader.setMusicDirPath(Directories.MUSIC);
        resLoader.setParticlesDirPath(Directories.PARTICLES);
        resLoader.setSoundsDirPath(Directories.SFX);
        resLoader.setSkinsDirPath(Directories.SKINS);

        restoreScreenSize();

        if (Lander.DEV_MODE) {
            setScreen(new MainMenuScreen(this));
        } else {
            setScreen(new SplashScreen(this));
        }
    }

    private void restoreScreenSize() {
        Settings settings = getSettings();

        int screenWidth     = settings.getScreenWidth();
        int screenHeight    = settings.getScreenHeight();
        boolean fullscreen  = settings.isFullscreen();

        Gdx.graphics.setDisplayMode(screenWidth, screenHeight, fullscreen);
    }

    public Settings getSettings() {
        return settings;
    }

    public void setScreen(AbstractScreen screen) {
        super.setScreen(screen);
        Gdx.input.setInputProcessor(screen);
    }

    public void exit() {
        Gdx.app.exit();
    }
}

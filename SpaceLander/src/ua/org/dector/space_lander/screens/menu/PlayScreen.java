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

package ua.org.dector.space_lander.screens.menu;

import com.badlogic.gdx.scenes.scene2d.ActorEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import ua.org.dector.gcore.game.TableScreen;
import ua.org.dector.gcore.managers.SoundManager;
import ua.org.dector.gcore.models.Profile;
import ua.org.dector.space_lander.Lander;
import ua.org.dector.space_lander.constants.Directories;
import ua.org.dector.space_lander.constants.Labels;
import ua.org.dector.space_lander.constants.LanderMusic;
import ua.org.dector.space_lander.constants.LanderSounds;

import static com.badlogic.gdx.Input.Keys;
import static ua.org.dector.space_lander.constants.UISizes.*;

/**
 * @author dector (dector9@gmail.com)
 */
public class PlayScreen extends TableScreen<Lander> {
    public PlayScreen(Lander lander) {
        super(lander);
    }

    public void show() {
        final SoundManager soundManager = game.getSoundManager();

        game.getMusicManager().play(LanderMusic.MENU, true);

        Skin skin = game.getGraphics().getSkin();
        Table table = getTable();

        Button btnNewGame = new TextButton(Labels.NEW_GAME, skin);
        btnNewGame.addListener(new ClickListener() {
            public void clicked(ActorEvent event, float x, float y) {
                soundManager.play(LanderSounds.MENU_CLICK);

                // Play new game
//                game.setScreen();
            }
        });

        game.getProfileManager().loadFromFiles(Directories.PROFILES);
        Profile[] profiles = game.getProfileManager().getProfiles();
        int profilesCount = profiles.length;

        Button[] btnProfiles = new Button[profilesCount];
        for (int i = 0; i < profilesCount; i++) {
            // TODO get profile name
            Button btnProfile = new TextButton(profiles[i].getName(), skin);
            btnProfile.addListener(new ClickListener() {
                public void clicked(ActorEvent event, float x, float y) {
                    soundManager.play(LanderSounds.MENU_CLICK);

                    // Play with selected profile
//                    game.setScreen();
                }
            });

            btnProfiles[i] = btnProfile;
        }

        Button btnBack = new TextButton(Labels.BACK, skin);
        btnBack.addListener(new ClickListener() {
            public void clicked(ActorEvent event, float x, float y) {
                soundManager.play(LanderSounds.MENU_CLICK);

                game.setScreen(new MainMenuScreen(game));
            }
        });

        table.add(Labels.TITLE).spaceBottom(TITLE_BOTTOM_SPACE);
        table.row();
        table.add(btnNewGame).size(BUTTONS_WIDTH, BUTTONS_HEIGHT).
                spaceBottom(BOTTOM_SPACE).fill().uniform();
        table.row();

        for (Button btnProfile : btnProfiles) {
            table.add(btnProfile).size(BUTTONS_WIDTH, BUTTONS_HEIGHT).
                    spaceBottom(BOTTOM_SPACE).fill().uniform();
            table.row();
        }

        table.add(btnBack).size(BUTTONS_WIDTH, BUTTONS_HEIGHT).fill().uniform();
    }

    public boolean keyDown(int keycode) {
        switch (keycode) {
            case Keys.ESCAPE: game.exit(); break;
        }

        return true;
    }
}

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

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import ua.org.dector.gcore.game.TableScreen;
import ua.org.dector.gcore.managers.SoundManager;
import ua.org.dector.gcore.utils.Utils;
import ua.org.dector.space_lander.Lander;
import ua.org.dector.space_lander.constants.Labels;
import ua.org.dector.space_lander.constants.LanderSounds;
import ua.org.dector.space_lander.controls.LanderControls;

import static ua.org.dector.space_lander.constants.UISizes.*;

/**
 * @author dector (dector9@gmail.com)
 */
public class ControlsOptionsScreen extends TableScreen<Lander> {
    public ControlsOptionsScreen(Lander lander) {
        super(lander);
    }

    public void show() {
        final SoundManager soundManager = game.getSoundManager();

        Skin skin = game.getGraphics().getSkin();
        Table table = getTable();

        final TextButton btnSpeedupOption = new TextButton("", skin);
        updateTextAt(btnSpeedupOption, LanderControls.SPEED_UP);
        btnSpeedupOption.addListener(new ClickListener() {
            public void clicked(ActorEvent event, float x, float y) {
                soundManager.play(LanderSounds.MENU_CLICK);

                getNewKey(Labels.SPEED_UP, btnSpeedupOption, Control.SPEED_UP);
            }
        });

        Table controlsTable = new Table(skin);
        controlsTable.defaults().padBottom(BOTTOM_SPACE);
        controlsTable.add(Labels.SPEED_UP);
        controlsTable.add(btnSpeedupOption).colspan(2);
        controlsTable.row();
        controlsTable.add(Labels.ROTATE_LEFT);
        controlsTable.row();
        controlsTable.add(Labels.ROTATE_RIGHT);
        controlsTable.row();
        controlsTable.add(Labels.PAUSE);
        controlsTable.row();
        controlsTable.add(Labels.RESTART);
        ScrollPane controlsPane = new ScrollPane(controlsTable);

        TextButton btnBack = new TextButton(Labels.OPTIONS$BACK, skin);
        btnBack.addListener(new ClickListener() {
            public void clicked(ActorEvent event, float x, float y) {
                soundManager.play(LanderSounds.MENU_CLICK);

                game.setScreen(new OptionsScreen(game));
            }
        });

        table.add(Labels.OPTIONS$CONTROLS).spaceBottom(TITLE_BOTTOM_SPACE).colspan(3);
        table.row();
        table.add(controlsPane).fill().padBottom(BOTTOM_SPACE);
        table.row();
        table.add(btnBack).colspan(3).size(BUTTONS_WIDTH, BUTTONS_HEIGHT)
                .fill().uniform();

        table.debug();
    }

    private static String getKeyString(int key) {
        return "Key " + key;
    }

    private void updateTextAt(TextButton button, int key) {
        button.setText(getKeyString(key));
    }

    private void setUpInput(Control control, int key) {
        switch (control) {
            case SPEED_UP: LanderControls.SPEED_UP = key; break;
        }
    }

    public void getNewKey(String controlText,
                          final TextButton button,
                          final Control control) {
        int screenWidth = Gdx.graphics.getWidth();
        int screenHeight = Gdx.graphics.getHeight();

        Pixmap p = new Pixmap(
                Utils.toPowerOfTwo(screenWidth),
                Utils.toPowerOfTwo(screenHeight),
                Pixmap.Format.RGBA8888
        );

        p.setColor(0, 0, 0, .8f);
        p.fill();

        TextureRegion tex = new TextureRegion(
                new Texture(p),
                screenWidth,
                screenHeight
        );

        p.dispose();

        final Group group = new Group();

        Image darkBack = new Image(tex);
        darkBack.addListener(new ActorListener() {
            public boolean keyDown(ActorEvent event, int keycode) {
                game.getSoundManager().play(LanderSounds.MENU_CLICK);

                setUpInput(control, keycode);
                updateTextAt(button, keycode);

                disableKeyboardInput(group);
                return true;
            }

            public boolean touchDown(ActorEvent event, float x, float y,
                                     int pointer, int button) {
                game.getSoundManager().play(LanderSounds.MENU_CLICK);

                disableKeyboardInput(group);
                return true;
            }
        });

        Table textTable = new Table(game.getGraphics().getSkin());
        textTable.setPosition(screenWidth / 2, screenHeight / 2);
        textTable.add(String.format("%s \"%s\"", Labels.PRESS_NEW_KEY_FOR, controlText));

        group.addActor(darkBack);
        group.addActor(textTable);
        getStage().addActor(group);
        getStage().setKeyboardFocus(darkBack);
    }

    private void disableKeyboardInput(Group group) {
        group.addAction(Actions.removeActor());
        getStage().setKeyboardFocus(null);
        
    }

    static enum Control {
        SPEED_UP, ROTATE_LEFT, ROTATE_RIGHT, PAUSE, RESTART
    }
}
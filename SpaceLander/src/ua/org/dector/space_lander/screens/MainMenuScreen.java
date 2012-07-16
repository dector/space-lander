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

package ua.org.dector.space_lander.screens;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import ua.org.dector.gcore.game.TableScreen;
import ua.org.dector.gcore.input.ClickActorListener;
import ua.org.dector.space_lander.Lander;
import ua.org.dector.space_lander.constants.Labels;

import static com.badlogic.gdx.Input.Keys;
import static ua.org.dector.space_lander.constants.UISizes.*;

/**
 * @author dector (dector9@gmail.com)
 */
public class MainMenuScreen extends TableScreen<Lander> {
    public MainMenuScreen(Lander lander) {
        super(lander);
    }

    public void show() {
        Skin skin = game.getGraphics().getSkin();
        Table table = getTable();

        Button btnOptions = new TextButton(Labels.OPTIONS$OPTIONS, skin);
        btnOptions.addListener(new ClickActorListener(btnOptions) {
            protected void onClick(int button) {
                if (button == Input.Buttons.LEFT)
                    game.setScreen(new OptionsScreen(game));
            }
        });

        Button btnExit = new TextButton(Labels.OPTIONS$EXIT, skin);
        btnExit.addListener(new ClickActorListener(btnExit) {
            protected void onClick(int button) {
                if (button == Input.Buttons.LEFT)
                    game.exit();
            }
        });

        table.add(Labels.TITLE).spaceBottom(TITLE_BOTTOM_SPACE);
        table.row();
        table.add(btnOptions).size(BUTTONS_WIDTH, BUTTONS_HEIGHT).
                spaceBottom(BOTTOM_SPACE).fill().uniform();
        table.row();
        table.add(btnExit).size(BUTTONS_WIDTH, BUTTONS_HEIGHT).fill().uniform();
    }

    public boolean keyDown(int keycode) {
        switch (keycode) {
            case Keys.ESCAPE: game.exit(); break;
        }

        return true;
    }
}

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

import static ua.org.dector.space_lander.constants.UISizes.*;

/**
 * @author dector (dector9@gmail.com)
 */
public class OptionsScreen extends TableScreen<Lander> {
    public OptionsScreen(Lander lander) {
        super(lander);
    }

    public void show() {
        Skin skin = game.getGraphics().getSkin();
        Table table = getTable();

        Button btnAudio     = new TextButton(Labels.OPTIONS$AUDIO, skin);
        Button btnGraphics  = new TextButton(Labels.OPTIONS$GRAPHICS, skin);
        Button btnControls  = new TextButton(Labels.OPTIONS$CONTROLS, skin);
        Button btnBack      = new TextButton(Labels.OPTIONS$BACK, skin);
        btnBack.addListener(new ClickActorListener(btnBack) {
            protected void onClick(int button) {
                if (button == Input.Buttons.LEFT)
                    game.setScreen(new MainMenuScreen(game));
            }
        });

        table.add(Labels.OPTIONS$OPTIONS).spaceBottom(TITLE_BOTTOM_SPACE).uniform();
        table.row();
        table.add(btnGraphics).size(BUTTONS_WIDTH, BUTTONS_HEIGHT).
                spaceBottom(BUTTON_BOTTOM_SPACE).fill().uniform();
        table.row();
        table.add(btnAudio).size(BUTTONS_WIDTH, BUTTONS_HEIGHT).
                spaceBottom(BUTTON_BOTTOM_SPACE).fill().uniform();
        table.row();
        table.add(btnControls).size(BUTTONS_WIDTH, BUTTONS_HEIGHT).
                spaceBottom(BUTTON_BOTTOM_SPACE).fill().uniform();
        table.row();
        table.add(btnBack).size(BUTTONS_WIDTH, BUTTONS_HEIGHT)
                .fill().uniform();
    }
}
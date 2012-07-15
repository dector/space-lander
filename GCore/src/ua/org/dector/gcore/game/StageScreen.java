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

import com.badlogic.gdx.scenes.scene2d.Stage;

/**
 * @author dector (dector9@gmail.com)
 */
public class StageScreen<ConcreteGame extends AbstractGame>
        extends AbstractScreen<ConcreteGame> {
    private Stage stage;

    public StageScreen(ConcreteGame concreteGame) {
        super(concreteGame);
    }

    public void render(float delta) {
        super.render(delta);
        stage.act(delta);
        stage.draw();
    }

    public Stage getStage() {
        if (stage == null) stage = new Stage();
        return stage;
    }

    public boolean scrolled(int amount) {
        return super.scrolled(amount)
                | stage.scrolled(amount);
    }

    public boolean mouseMoved(int x, int y) {
        return super.mouseMoved(x, y)
                | stage.mouseMoved(x,y);
    }

    public boolean touchDragged(int x, int y, int pointer) {
        return super.touchDragged(x, y, pointer)
                | stage.touchDragged(x, y, pointer);
    }

    public boolean touchUp(int x, int y, int pointer, int button) {
        return super.touchUp(x, y, pointer, button)
                | stage.touchUp(x, y, pointer, button);
    }

    public boolean touchDown(int x, int y, int pointer, int button) {
        return super.touchDown(x, y, pointer, button)
                | stage.touchDown(x, y, pointer, button);
    }

    public boolean keyTyped(char character) {
        return super.keyTyped(character)
                | stage.keyTyped(character);
    }

    public boolean keyUp(int keycode) {
        return super.keyUp(keycode)
                | stage.keyUp(keycode);
    }

    public boolean keyDown(int keycode) {
        return super.keyDown(keycode)
                | stage.keyDown(keycode);
    }
}

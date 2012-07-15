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

package ua.org.dector.gcore.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Matrix4;

/**
 * @author dector (dector9@gmail.com)
 */
public class GraphicsImpl implements Graphics {
    private SpriteBatch sb;
    private BitmapFont font;

    private GL10 gl10;

    public GraphicsImpl() {
        sb = new SpriteBatch();

        font = new BitmapFont();

        gl10 = Gdx.graphics.getGL10();
        setClearColor(0, 0, 0, 1);
    }

    public void setClearColor(Color c) {
        setClearColor(c.r, c.g, c.b, c.a);
    }

    public void setClearColor(float r, float g, float b, float a) {
        gl10.glClearColor(r, g, b, a);
    }

    public void begin() {
        sb.begin();
    }

    public void end() {
        sb.end();
    }

    public void draw(TextureRegion tex, float x, float y) {
        sb.draw(tex, x, y);
    }

    public void draw(TextureRegion tex, float x, float y,
                            int width, int height) {
        sb.draw(tex, x, y, width, height);
    }

    public void draw(TextureRegion tex, float x, float y,
                            int width, int height, float rotation) {
        draw(tex, x, y, width / 2, height / 2, width, height, rotation);
    }

    public void draw(TextureRegion tex, float x, float y, int originX, int originY,
                            int width, int height, float rotation) {
        sb.draw(tex, x, y, originX, originY, width, height, 1, 1, rotation - 90);
    }

    public void drawCentered(String string, int x, int y) {
        BitmapFont.TextBounds bounds = font.getBounds(string);

        x -= bounds.width / 2;
        y += bounds.height / 2;

        draw(string, x, y);
    }

    public void draw(String string, int x, int y) {
        font.draw(sb, string, x, y);
    }

    public void draw(int x, int y, int stepY, String... strings) {
        for (String s : strings) {
            draw(s, x, y);
            y -= stepY;
        }
    }

    public void clear() {
        gl10.glClear(GL10.GL_COLOR_BUFFER_BIT);
    }

    public SpriteBatch getSpriteBatch() {
        return sb;
    }

    public void setProjectionMatrix(Matrix4 matrix) {
        getSpriteBatch().setProjectionMatrix(matrix);
    }
}

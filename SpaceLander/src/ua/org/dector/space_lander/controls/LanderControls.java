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

package ua.org.dector.space_lander.controls;

import com.badlogic.gdx.Input;
import ua.org.dector.gcore.managers.PreferencesManager;

/**
 * @author dector (dector9@gmail.com)
 */
public class LanderControls {
    public static int SPEED_UP;
    public static int ROTATE_LEFT;
    public static int ROTATE_RIGHT;
    public static int PAUSE;
    public static int RESTART;

    public static String PREF_SPEED_UP      = "keys.speed.up";
    public static String PREF_ROTATE_LEFT   = "keys.rotate.left";
    public static String PREF_ROTATE_RIGHT  = "keys.rotate.right";
    public static String PREF_PAUSE         = "keys.pause";
    public static String PREF_RESTART       = "keys.restart";

    public static void restore(PreferencesManager prefs) {
        SPEED_UP      = prefs.getInt(PREF_SPEED_UP, Input.Keys.UP);
        ROTATE_LEFT   = prefs.getInt(PREF_ROTATE_LEFT, Input.Keys.LEFT);
        ROTATE_RIGHT  = prefs.getInt(PREF_ROTATE_RIGHT, Input.Keys.RIGHT);
        PAUSE         = prefs.getInt(PREF_PAUSE, Input.Keys.P);
        RESTART       = prefs.getInt(PREF_RESTART, Input.Keys.R);
    }

    public static void store(PreferencesManager prefs) {
        prefs.putInt(PREF_SPEED_UP, SPEED_UP);
        prefs.putInt(PREF_ROTATE_LEFT, ROTATE_LEFT);
        prefs.putInt(PREF_ROTATE_RIGHT, ROTATE_RIGHT);
        prefs.putInt(PREF_PAUSE, PAUSE);
        prefs.putInt(PREF_RESTART, RESTART);
    }
}

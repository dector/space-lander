package ua.org.dector.gcore.utils;

import com.badlogic.gdx.Gdx;

import static com.badlogic.gdx.Graphics.DisplayMode;

/**
 * @author dector (dector9@gmail.com)
 */
public class ScreenMode {
    private int width;
    private int height;

    public ScreenMode(int width, int height) {
        setWidth(width);
        setHeight(height);
    }

    public static ScreenMode[] getAvailable() {
        DisplayMode[] dispModes = Gdx.graphics.getDisplayModes();
        ScreenMode[] scrModes = new ScreenMode[dispModes.length];

        int i = 0;
        for (DisplayMode mode : dispModes) {
            scrModes[i++] = new ScreenMode(
                    mode.width, mode.height
            );
        }

        return scrModes;
    }

    public static ScreenMode getCurrent() {
        DisplayMode mode = Gdx.graphics.getDesktopDisplayMode();

        return new ScreenMode(
                mode.width, mode.height
        );
    }

    public static void setUp(ScreenMode screenMode, boolean fullscreen) {
        Gdx.graphics.setDisplayMode(
                screenMode.getWidth(),
                screenMode.getHeight(),
                fullscreen
        );
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String toString() {
        return String.format("%dx%d", width, height);
    }
}

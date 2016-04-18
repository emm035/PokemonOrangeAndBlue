/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiComponents;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.geom.RoundedRectangle;

/**
 * A MenuButton draws and represents a button in a menu. It can be either drawn
 * separately, or managed by a MenuLayoutManager
 *
 * @author Eric
 */
public class MenuButton {

    // Data for rendering
    protected String[] text;
    protected RoundedRectangle drawArea;
    protected TrueTypeFont font;
    protected boolean isHighlighted = false;
    protected Color highlightColor;
    protected boolean enabled = true;

    //=====================
    // Mark: - Constructors
    //=====================
    /**
     * Constructor for a button with only the displayed text in it. This
     * buttons size must be manually set, or managed by a MenuLayoutManager.
     *
     * @author Eric
     * @param text The string to draw on the button
     */
    public MenuButton(String text) {
        this(text, Color.red);
    }

    /**
     * Constructor for a button with only the displayed text in it. This
     * buttons size must be manually set, or managed by a MenuLayoutManager.
     * This constructor also allows the highlight color to be set.
     *
     * @author Eric
     * @param text The string to draw on the button
     * @param highlightColor The Color to outline with when the button is
     * highlighted
     */
    public MenuButton(String text, Color highlightColor) {
        this(0, 0, 0, 0, text, highlightColor);
    }

    /**
     * The full constructor for a button. Allows the user to set position, size,
     * text, and highlight color
     *
     * @author Eric
     * @param x The x position in the window in pixels
     * @param y The y position in the window in pixels
     * @param width The width of the button in pixels
     * @param height The height of the button in pixels
     * @param text The string to draw on the button
     * @param highlightColor The Color to outline with when the button is
     * highlighted
     */
    public MenuButton(float x, float y, float width, float height, String text, Color highlightColor) {
        this.highlightColor = highlightColor;
        drawArea = new RoundedRectangle(x, y, width, height, 5);
        try {
            font = FontUtils.getStdPixelFont();
        } catch (SlickException ex) {
        }
        this.text = new String[]{text};
        updateWrapSize();
    }

    //==================
    // Mark: - Rendering
    //==================
    /**
     * Draws the button in the given container with the given graphics context
     *
     * @author Eric
     * @param container The container to draw in
     * @param g The graphics context to draw with
     */
    public void render(GameContainer container, Graphics g) {
        if (isHighlighted && enabled) {
            g.setColor(highlightColor);
            g.draw(drawArea);
        }

        g.setFont(font);
        g.setColor(Color.black);
        int i = 0;
        for (String s : text) {
            g.drawString(s, centerStringX(s), stringLocY(s, i));
            i++;
        }

    }

    //================
    // Mark: - Setters
    //================
    public void setSize(float width, float height) {
        drawArea.setWidth(width);
        drawArea.setHeight(height);
        drawArea.setCornerRadius(5);
        updateWrapSize();
        drawArea.prune();
    }

    public void setPosition(float x, float y) {
        drawArea.setX(x);
        drawArea.setY(y);
        drawArea.prune();
    }

    public void setHighlighted(boolean highlighted) {
        isHighlighted = highlighted;
    }

    public void setText(String text) {
        this.text = new String[]{text};
        updateWrapSize();
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    //================
    // Mark: - Getters
    //================
    public float getX() {
        return drawArea.getWidth();
    }

    public float getY() {
        return drawArea.getY();
    }

    public float getWidth() {
        return drawArea.getWidth();
    }

    public float getHeight() {
        return drawArea.getHeight();
    }

    public boolean getHighlighted() {
        return isHighlighted;
    }

    public float[] getCenter() {
        return drawArea.getCenter();
    }

    public String getText() {
        return String.join(" ", text);
    }

    public boolean isEnabled() {
        return enabled;
    }

    //================
    // Mark: - Helpers
    //================
    /**
     * Gets the coordinate to draw s at so that it is centered within the
     * button
     *
     * @param s The string to draw
     * @return The x position to draw the string at
     */
    private float centerStringX(String s) {
        return drawArea.getX() + drawArea.getWidth() / 2 - font.getWidth(s) / 2;
    }

    /**
     * Gets the coordinate to draw s at so that it is at the right location
     * within the button when the text is wrapped
     *
     * @param s The string to draw
     * @param num The line number, starting at 0
     * @return The y position to draw the string at
     */
    private float stringLocY(String s, int num) {
        return (int) (drawArea.getY() + (drawArea.getHeight() * (num + 1) * 1.0f / (text.length + 1)) - (font.getHeight(s) / 2));
    }

    /**
     * Updates the strings that are printed on the button.
     */
    private void updateWrapSize() {
        try {
            this.text = FontUtils.wrapString(String.join(" ", text), this.drawArea.getWidth() - 10);
        } catch (Exception ex) {
        }
    }

    //=======================
    // Mark: - Button control
    //=======================
    /**
     * Tells whether the point given by the ordered pair (x, y) is contained
     * within the button
     *
     * @param x The x position in pixels
     * @param y The y position in pixels
     * @return true if the point lies within the button
     */
    public boolean contains(float x, float y) {
        return drawArea.contains(x, y);
    }

}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiComponents;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.RoundedRectangle;

/**
 *
 * @author Eric
 * @param <T>
 */
public class MenuLayoutManager<T extends MenuButton> {

    private MenuButton[][] buttonMatrix;
    private MenuButton[] buttonArray;
    private int[] selected = new int[]{-1, -1};
    private int size = 0;
    private RoundedRectangle drawArea;
    private float[] buttonRectSize;
    private boolean drawBackground;
    private boolean shouldShowHighlight = true;

    // Constants for drawing
    private static final float X_PADDING = 5;
    private static final float Y_PADDING = 5;

    public MenuLayoutManager(RoundedRectangle drawArea, int x, int y) {
        this(drawArea, x, y, true);
    }

    public MenuLayoutManager(RoundedRectangle drawArea, int x, int y, boolean drawBackground) {
        buttonMatrix = new MenuButton[x][y];
        this.drawArea = drawArea;
        this.drawBackground = drawBackground;
        calculateButtonRectSize();
    }

    public RoundedRectangle getDrawArea() {
        return drawArea;
    }

    private void calculateButtonRectSize() {
        int width = (int) ((drawArea.getWidth() - (buttonMatrix.length + 1) * X_PADDING) / buttonMatrix.length);
        int height = (int) ((drawArea.getHeight() - (buttonMatrix[0].length + 1) * Y_PADDING) / buttonMatrix[0].length);
        buttonRectSize = new float[]{width, height};
    }

    private int[] getButtonCoords(int gridX, int gridY) {
        int x = (int) (drawArea.getX() + (X_PADDING * (gridX + 1)) + buttonRectSize[0] * gridX);
        int y = (int) (drawArea.getY() + (Y_PADDING * (gridY + 1)) + buttonRectSize[1] * gridY);
        return new int[]{x, y};
    }

    private void setInMatrix(int x, int y, MenuButton b) {
        if (b != null) {
            if (buttonMatrix[x][y] == null) {
                size += 1;
            } else {
                buttonMatrix[x][y].setHighlighted(false);
            }
            buttonMatrix[x][y] = b;
            if (size == 1) {
                selected[0] = x;
                selected[1] = y;
                buttonMatrix[x][y].setHighlighted(true);
            }
        } else {
            if (buttonMatrix[x][y] != null) {
                buttonMatrix[x][y].setHighlighted(false);
                size -= 1;
                buttonMatrix[x][y] = null;
            }
            if (size == 0) {
                selected[0] = -1;
                selected[1] = -1;
            }
        }
        refreshArray();
    }

    public void set(int x, int y, MenuButton b) {
        if (b != null) {
            int[] coords = getButtonCoords(x, y);
            b.setPosition(coords[0], coords[1]);
            b.setSize(buttonRectSize[0], buttonRectSize[1]);
            b.setHighlighted(false);
            setInMatrix(x, y, b);
        } else {
            setInMatrix(x, y, null);
        }
    }

    public MenuButton getLeft() {
        if (selected[0] != 0 && buttonMatrix[selected[0] - 1][selected[1]] != null) {
            return buttonMatrix[selected[0] - 1][selected[1]];
        } else {
            return buttonMatrix[selected[0]][selected[1]];
        }
    }

    public MenuButton getRight() {
        if (selected[0] < buttonMatrix.length - 1 && buttonMatrix[selected[0] + 1][selected[1]] != null) {
            return buttonMatrix[selected[0] + 1][selected[1]];
        } else {
            return buttonMatrix[selected[0]][selected[1]];
        }
    }

    public MenuButton getUp() {
        if (selected[1] != 0 && buttonMatrix[selected[0]][selected[1] - 1] != null) {
            return buttonMatrix[selected[0]][selected[1] - 1];
        } else {
            return buttonMatrix[selected[0]][selected[1]];
        }
    }

    public MenuButton getDown() {
        if (selected[1] < buttonMatrix[0].length - 1 && buttonMatrix[selected[0]][selected[1] + 1] != null) {
            return buttonMatrix[selected[0]][selected[1] + 1];
        } else {
            return buttonMatrix[selected[0]][selected[1]];
        }
    }

    public T getSelected() {
        return getButton(selected[0], selected[1]);
    }

    public int[] find(MenuButton b) {
        for (int x = 0; x < buttonMatrix.length; x++) {
            for (int y = 0; y < buttonMatrix[0].length; y++) {
                if (buttonMatrix[x][y] == b) {
                    return new int[]{x, y};
                }
            }
        }
        return null;
    }

    public void setSelected(MenuButton b) {
        int[] tmp = find(b);
        if (buttonMatrix[selected[0]][selected[1]] != b && tmp != null && buttonMatrix[tmp[0]][tmp[1]].isEnabled()) {
            buttonMatrix[selected[0]][selected[1]].setHighlighted(false);
            selected = tmp;
            buttonMatrix[selected[0]][selected[1]].setHighlighted(true);
        }
    }

    public void disable() {
        for (MenuButton b : getButtons()) {
            b.setEnabled(false);
            b.setHighlighted(false);
        }
    }

    public void enable() {
        for (MenuButton b : buttonArray) {
            b.setEnabled(true);
            b.setHighlighted(false);
        }
        setSelected(getSelected());
    }

    public T getButton(int x, int y) {
        return buttonMatrix[x][y] != null ? (T) buttonMatrix[x][y] : null;
    }

    public boolean getDrawBackground() {
        return drawBackground;
    }

    public void setDrawBackground(boolean drawBackground) {
        this.drawBackground = drawBackground;
    }

    private void refreshArray() {
        buttonArray = new MenuButton[size];
        int i = 0;
        for (MenuButton[] row : buttonMatrix) {
            for (MenuButton btn : row) {
                if (btn != null) {
                    buttonArray[i] = btn;
                    i += 1;
                }
            }
        }
    }

    public T[] getButtons() {
        return (T[]) buttonArray;
    }

    public void render(GameContainer container, Graphics g) {
        if (drawBackground) {
            g.setColor(Color.white);
            g.fill(drawArea);
        }
        for (MenuButton b : buttonArray) {
            if (buttonMatrix[selected[0]][selected[1]] == b) {
                b.setHighlighted(true);
            } else {
                b.setHighlighted(false);
            }
            b.render(container, g);
        }
    }
}
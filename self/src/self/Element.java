/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package self;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author hamza
 */
 class Element {
    Position position;
    Color color;
    int radius = 10;
    boolean isTarget() {
        return false;
    }
    Element(double x, double y) {
        position = new Position(x, y);
    }
    void setPosition(Position p) {
        position = p;
    }
    void draw(Graphics g) {
        g.setColor(color);
        g.fillOval((int)position.x - radius, (int)-position.y - radius, 2 * radius, 2 * radius); // minus because of reversed y coordinate
    }
}

class Obstacle extends Element {
    Obstacle(double x, double y) {
        super(x, y);
        color = Color.RED;
    }
    Obstacle(double x, double y, int r) {
        this(x, y);
        radius = r;
    }
}


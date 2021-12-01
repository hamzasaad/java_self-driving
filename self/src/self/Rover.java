/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package self;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author hamza
 */
 class Rover extends Element {
     double orientation;
    Rover(double x, double y, double o) {
        super(x, y);
        orientation = o;
        color = Color.YELLOW;
    }
    void setOrientation(double o) {
        orientation = o;
    }
    void draw(Graphics g) {
        super.draw(g);
        g.setColor(Color.BLACK);
        g.drawLine((int)position.x,
                   (int)-position.y,
                   (int)(position.x + radius * Math.cos(Math.PI * orientation / 180.0)),
                   (int)(-position.y - radius * Math.sin(Math.PI * orientation / 180.0))); // minus because of reversed y coordinate
    }
}

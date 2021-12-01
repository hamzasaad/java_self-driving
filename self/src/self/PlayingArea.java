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
public class PlayingArea extends Canvas {
    List<Element> elements;
    PlayingArea(List<Element> elements) {
        this.elements = elements;
        setBackground(Color.GREEN);
    }
    boolean targetReached = false;
    public void paint(Graphics g) {
        Dimension d = getSize();
        g.translate(d.width / 2, d.height / 2); // shift origin to centre
        elements.forEach(e -> e.draw(g));
        if (targetReached) {
            g.setColor(Color.BLACK);
            g.setFont(new Font("SansSerif", Font.BOLD, 30));
            g.drawString("Target Reached!", -120, 0);
        }
    }
}


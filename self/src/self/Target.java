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
 class Target extends Element{
     Target(double x, double y) {
        super(x, y);
        color = Color.BLUE;
    }
    boolean isTarget() {
        return true;
    }
}

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
public class World extends WindowAdapter {
    Frame f;
    List<Element> elements;
    Rover rover;
    Target target;
    Vehicle vehicle;
    static final double DT = 0.1;

    World() {
        elements = new ArrayList<Element>();
        elements.add(new Obstacle(65, 7));
        elements.add(new Obstacle(80, -10));
        elements.add(new Obstacle(60, 30));
        elements.add(new Obstacle(-60, 60, 15));
        elements.add(new Obstacle(-100, -40, 20));
        elements.add(new Obstacle(-120, 70, 15));
        elements.add(new Obstacle(-160, 0, 25));
        elements.add(new Obstacle(-200, -100));
        target = new Target(200, 30);
        elements.add(target);
        rover = new Rover(0, 0, 90);
        elements.add(rover);
    }

    public void go() {
        f = new Frame("The World");
        f.setSize(600, 400);
        f.addWindowListener(this);
        PlayingArea playingArea = new PlayingArea(elements);
        f.add(playingArea);
        f.setVisible(true);
        Position oldPosition;
        while (true) {
            if (distanceToRover(target) < 1.0) {
                playingArea.targetReached = true;
                playingArea.repaint();
                return;
            }
            elements.forEach(e -> {
                if (e != rover) {
                    vehicle.addSignal(new Signal(distanceToRover(e), angleWRTRover(e), e.isTarget()));
                }
            });
            oldPosition = vehicle.getPosition().clone();
            rover.setPosition(vehicle.drive(DT));
            if (overlap()) {
                vehicle.bounceBack(oldPosition);
            }
            rover.setPosition(vehicle.getPosition());
            rover.setOrientation(vehicle.getOrientation());
            playingArea.repaint();
            try {
                Thread.sleep((long)(100 * DT));
            } catch(Exception e) {}
        }
    }

    private boolean overlap() {
        boolean ret = false;
        for (Element e : elements) {
            if ((distanceToRover(e) < 0.0) && (e != rover)) {
                ret = true;
            }
        }
        return ret;
    }

    private double distanceToRover(Element e) {
        return rover.position.distance(e.position) - e.radius - rover.radius;
    }

    private double angleWRTRover(Element e) {
        double angleToElement = rover.position.angle(e.position);
        return (angleToElement - rover.orientation + 520) % 360 - 180; // between -180 and 180
    }

    public void windowClosing(WindowEvent e) {
        f.dispose();
        System.exit(0);
    }

    public void addVehicle(Vehicle v) {
        vehicle = v;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package self;

/**
 *
 * @author hamza
 */
public class Position {
    public double x;
	public double y;
	Position() {
        this(0.0, 0.0);
    }
	Position(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public Position clone() {
        return new Position(x, y);
    }
    double distance(Position p) {
        double dx = p.x - x;
        double dy = p.y - y;
        return Math.sqrt(dx * dx + dy * dy);
    }
    double angle(Position p) {
        double dx = p.x - x;
        double dy = p.y - y;
        return (180.0 * Math.atan2(dy, dx) / Math.PI + 360) % 360; // between 0 and 360
    }
}

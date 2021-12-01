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
public class Signal {
    double distance;
    double angle;
    boolean target;
	Signal(double distance, double angle, boolean target) {
        this.distance = distance;
        this.angle = angle;
        this.target = target;
    }
	public double getDistance() {
        return distance;
    }
	public double getAngle() {
        return angle;
    }
	public boolean isTarget() {
        return target;
    }
}

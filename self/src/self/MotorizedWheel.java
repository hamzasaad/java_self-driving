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
public class MotorizedWheel {
    /*field*/
	//private want mag alleen binnen deze class gebruikt worden
	private double speed;
	
    /*methods*/
	//geeft 10 terug als de motor in z'n vooruit staat
    public void forward() {
    	speed = 10.0;
    }

    //geeft -10 terug als de motor in z'n achteruit staat
    public void reverse() {
        speed = -10.0;
    }

	//geeft 0.0 terug als de motor stilstaat
    public void stop() {
        speed = 0.0;
    }

	//de waarde ligt eraan of de auto in zijn forward, reverse of stop staat
    public double getSpeed() {
    	return speed;
    }
}


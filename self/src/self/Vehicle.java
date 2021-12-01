/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package self;
import java.util.Stack;
/**
 *
 * @author hamza
 */
public class Vehicle {
    /*fields*/
	private MotorizedWheel leftWheel;
	private MotorizedWheel rightWheel;
	private Position position = new Position();
	private double orientation;
	private double angle;	
	private double distance;
	private boolean target;
	
	//maakt een instance van de class Stack
	Stack<Signal> stack = new Stack<Signal>();
	
	/*Constructor*/
	//leftWheel and rightWheel geinstantieerd in de constructor van Vehicle
	public Vehicle(MotorizedWheel lW, MotorizedWheel rW) {
		leftWheel = lW;
		rightWheel = rW;
	}

   

    
	
    /*public methods*/
	//method met als argument een object van class Signal, dat signal op de stack zet
    public void addSignal(Signal s) {
    	stack.push(s);
    }

    public Position drive(double dt) {
    	//targetSignal is van class Signal, null is van type targetSignal
    	Signal targetSignal = null;
    	
    	//geeft aan of er een obstakel is
    	boolean obstacle = false;
    	
    	//geeft aan of er een obstakel voor de vehicle is
    	boolean obstacleInFront = false;
    	
    	while(!stack.empty()) { 	
    		//removes the object at the top of this stack and returns that object as the value of this function
    		Signal value = stack.pop();
    		
    		//negatieve waarde, obstakel is rechts van vehicle, positieve waarde, obstakel is links van vehicle
    		//loopt van -180° tot 180°
            angle = value.getAngle();
            
            //vraagt de afstand op, deze is t.o.v. de huidige positie van vehicle en houdt rekening met de afmetingen van vehicle en obstakel
            distance = value.getDistance();
            
            //is true als vehicle de target heeft bereikt
            target = value.isTarget();

			//als vehicle target niet in zicht heeft en distance tussen vehicle en obstakel kleiner is dan 3
        	//en als de angle tussen vehicle en obstakel kleiner/groter is dan 50/-50
            //vehicle heeft nu een obstakel voor zich en zet dit dus op true
            if(!target && distance < 3 && angle < 50 && angle > -50) {
            	System.out.println("vehicle is 3 away from obstacle");
        		System.out.println("angle of obstacle is 50");
        		leftWheel.forward();
        		rightWheel.reverse();
        		obstacle = true;
            }
            
            //als vehicle target niet in zicht heeft en de angle tussen vehicle en obstakel kleiner/groter is dan 90/-90
            //vehicle heeft nu een obstakel voor zich en zet dit dus op true
	    	if(!target && angle < 90 && angle > -90) {
	    		System.out.println("obstacle in front");
	    		obstacleInFront = true;
	    	}
	    	
	    	//als vehicle een signaal binnen krijgt van target
	    	if(target) {
	    		System.out.println("vehicle is going for the target");
	    		targetSignal = value;
	    	}
    	}
    	
    	//vehicle heeft het signal van targetSignal en er is geen obstakel tussen vehicle en target
    	if(!obstacleInFront) {
    		System.out.println("there is no obstacle between target and vehicle");
    		
			//zorgt ervoor dat de vehicle naar de target toegaat
			orientation += targetSignal.angle;
    	}
    	
    	//als er geen obstakel is en de weg dus vrij is, kan de auto rechtdoor rijden
    	if(!obstacle) {
			leftWheel.forward();
			rightWheel.forward();
    	}
    	
    	//de nieuwe positie van vehicle wordt teruggegeven als object van class position
    	updateVehicle(dt);
    	return position;
    }

    //als het voertuig tegen een obstakel aanbotst, wordt het voertuig terug geplaatst naar de gegeven lokatie, zie World.java
    public void bounceBack(Position p) {
    	position = p;
    }

    //positie van het voertuig kan worden opgevraagd
    public Position getPosition() {
        return position;
    }

	//geeft de huidige oriëntatie van het voertuig terug in graden (0-360)
    public double getOrientation() {
    	return orientation;
    }

    /*private methods*/
    //past de positie en de oriëntatie aan op basis van Motorized leftWheel en rightWheel
    private void updateVehicle(double dt) {				//dt is de duur van het tijd stapje waarin gerekend wordt
		position.x += Math.cos(Math.PI * orientation / 180.0) * dt *
		(leftWheel.getSpeed() + rightWheel.getSpeed()) / 2;
		position.y += Math .sin(Math.PI * orientation / 180.0) * dt *
		(leftWheel.getSpeed() + rightWheel.getSpeed()) / 2;
		orientation += 0.5 * dt * ( rightWheel . getSpeed () - leftWheel . getSpeed ());
		orientation = (orientation + 360) % 360; 		//keep orientation within range 0°-360°
    } 
}

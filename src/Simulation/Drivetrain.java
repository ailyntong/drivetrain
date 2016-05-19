package Simulation;
import java.awt.Color;
import java.awt.Graphics;

/**
 * The class representing the drive train
 */
public class Drivetrain {

	/** The lateral x-position of the drive train along the rail in pixels **/
	private double position;
	/** The lateral velocity of the drive train along the rail in pixels/second **/
	private double velocity;
	
	/** The lateral x-position the drive train is targeted towards **/
	private double target;
	
	/** The mass of the drive train in arbitrary units **/
	private double mass;
	
	/** The force being applied on the base this update cycle **/
	private double force;
	
	/**
	 * Parameterized constructor, initializes all variables through setters
	 * 
	 * @param position the lateral position in pixels
	 * @param velocity the lateral velocity in pixels/second
	 * @param mass the mass of the base
	 */
	public Drivetrain(double position, double velocity, double mass, double target) {
		this.position = position;
		this.velocity = velocity;
		this.mass = mass;
		this.target = target;
	}
	
	/**
	 * Updates the base by calculating the acceleration from force and mass then updating position and velocity
	 */
	void update() {
		double acceleration = force/mass;
		
		velocity += acceleration/Constants.updateRate;		
		
		if(velocity > 0) {
			velocity -= Math.min(velocity, Constants.friction * Constants.driveMass);
		}
		if(velocity < 0) {
			velocity += Math.min(-velocity, Constants.friction * Constants.driveMass);
		}
		
		position += velocity/Constants.updateRate;
	}
	
	public void drive(double force) {
		this.force = Math.max(Math.min(force * Constants.driveForce, Constants.driveForce), -Constants.driveForce);
	}
	
	double getMass() {
		return mass;
	}
	
	public double getPosition() {
		return position;
	}
	
	public double getVelocity() {
		return velocity;
	}
	
	public double getTarget() {
		return target;
	}
	
	/**
	 * Draws the base based off of screen and base size constants found in the constants class
	 * 
	 * @param graphics the awt graphics object to be drawn on
	 */
	void draw(Graphics graphics) {
		int pixelPosition = (int) ((position + Constants.railWidth/2)*Constants.screenWidth/Constants.railWidth);
		int drawXPosition = pixelPosition - Constants.driveWidth/2;
		int drawYPosition = Constants.screenHeight/2-Constants.driveHeight/2;
		
		graphics.setColor(Color.DARK_GRAY);
		graphics.fillRect(0, Constants.screenHeight/2 - 5, Constants.screenWidth, 10);
		
		graphics.setColor(Color.GRAY);
		graphics.fillRect(drawXPosition, drawYPosition, Constants.driveWidth, Constants.driveHeight);
	}
}

package Simulation;

/**
 * The class containing constants relevant to the simulation
 */
public class Constants {
	
	/** Simulation Specifications **/
	
	public static final double updateRate = 50.0;
	public static final double speed = 1.0;
	public static final int simulationTrials = 10000;
	public static final boolean randomColor = false;
	
	
	/** World Specifications **/
	
	public static final double noiseFactor = 0.0;
	public static final double maximumNoiseForce = 0.0;
	public static final double railWidth = 1000.0;
	
	
	/** Pendulum Specifications **/
	
	public static final double driveMass = 1.0;
	public static final double driveForce = 1000.0;
	public static final double friction = 0.99;
	
	
	/** Control Specifications **/
	
	public static final double startPosition = -400.0;
	public static final double targetPosition = 0.0;
	
	public static final double acceptableError = 0.00001;
	public static final double acceptableVelocity = 0.0;
	
	
	/** Graphics Constants **/
	
	public static final int screenWidth = 1000;
	public static final int screenHeight = 200;
	
	public static final int driveWidth = 100;
	public static final int driveHeight = 50;
}

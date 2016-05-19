package Controller;
import Simulation.*;

public class Controller {
	public static boolean visual = true;
	public static Drivetrain drivetrain;
	
	public static double integral = 0;
	
	public static void updateDrivetrain() {
		PID(1000, 1, 187);
	}
	
	public static void PID(double p, double i, double d) {
		double proportional = drivetrain.getTarget() - drivetrain.getPosition();
		double derivative = -drivetrain.getVelocity();
		integral += drivetrain.getPosition() / Constants.updateRate;
		
		drivetrain.drive(p*proportional + i*integral + d*derivative);
	}
	
	public static void bangBang(double speed) {
		if(drivetrain.getPosition() > drivetrain.getTarget()) {
			drivetrain.drive(-speed);
		}
		if(drivetrain.getPosition() < drivetrain.getTarget()) {
			drivetrain.drive(speed);
		}
	}
}

package Controller;
import Simulation.*;

public class Controller {
	public static boolean visual = true;
	public static Drivetrain drivetrain;
	
	public static void updateDrivetrain() {

	}
	
	public static void PD(double p, double d) {
		double proportional = drivetrain.getTarget() - drivetrain.getPosition();
		double derivative = -drivetrain.getVelocity();
		
		drivetrain.drive(p*proportional + d*derivative);
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

package Simulation;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import Controller.*;

public class SimulationScreen extends JPanel implements KeyListener {	
	public static Drivetrain drivetrain;
	public static double time;
	public static double averageTime;
	
	public static void main(String[]args) throws InterruptedException {
		JFrame frame = new JFrame();
		frame.setSize(Constants.screenWidth, Constants.screenHeight);
		frame.setTitle("Drivetrain Simulation");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		SimulationScreen panel = new SimulationScreen();
		frame.addKeyListener(panel);
		frame.add(panel);
		frame.setVisible(true);
		
		drivetrain = new Drivetrain(Constants.startPosition, 0.0, Constants.driveMass, Constants.targetPosition);
		Controller.drivetrain = drivetrain;
		
		time = 0.0;
		averageTime = 0.0;
		
		if(Controller.visual) {
			while (Math.abs(drivetrain.getPosition() - drivetrain.getTarget()) > Constants.acceptableError || Math.abs(drivetrain.getVelocity()) > Constants.acceptableVelocity) {
				time += 1/Constants.updateRate;
				
				drivetrain.update();
				
				frame.repaint();
				Thread.sleep((int) (1000/(Constants.speed*Constants.updateRate)));
				
				Controller.updateDrivetrain();
			}
		}
		else {
			for(int i = 0; i < Constants.simulationTrials; i ++) {
				while (Math.abs(drivetrain.getPosition() - drivetrain.getTarget()) > Constants.acceptableError || Math.abs(drivetrain.getVelocity()) > Constants.acceptableVelocity) {
					time += 1/Constants.updateRate;
					
					drivetrain.update();
					
					Controller.updateDrivetrain();
				}
				
				averageTime += time;
				drivetrain = new Drivetrain(Constants.startPosition, 0.0, Constants.driveMass, Constants.targetPosition);
				Controller.drivetrain = drivetrain;
				
				time = 0.0;
			}
			
			averageTime /= Constants.simulationTrials;
			
			frame.repaint();
		}
	}
	
	@Override
	public void paintComponent(Graphics graphics) {
		if(Controller.visual) {
			drivetrain.draw(graphics);
			graphics.setColor(Color.BLACK);
			graphics.drawString("Time: " + ((double)(int)(time*100))/100, 50, 50);
		}
		else {
			graphics.drawString("Average Time: " + ((double)(int)(averageTime*100))/100, 50, 50);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}
}

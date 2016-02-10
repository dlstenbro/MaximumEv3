package remoteDragRacer;

import lejos.hardware.sensor.EV3IRSensor;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.motor.UnregulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;

public class RemoteController {
	/*
	 * initialize motor objects 
	 */
	UnregulatedMotor wheelMotorB = new UnregulatedMotor(MotorPort.B);
	UnregulatedMotor wheelMotorC = new UnregulatedMotor(MotorPort.C);
	EV3MediumRegulatedMotor A = new EV3MediumRegulatedMotor(MotorPort.A);

	EV3IRSensor rc = new EV3IRSensor(SensorPort.S4);		// IR sensor is located in port 4
	int rcChannel = 0;								// have the default channel by 0
	byte [] cmds = new byte[4];
	/*
	 * IR Sensor buttons
	 * 1 TOP-LEFT 
	 * 2 BOTTOM-LEFT 
	 * 3 TOP-RIGHT 
	 * 4 BOTTOM-RIGHT
	 */
	
	public int getRCInput(){
		return rc.getRemoteCommand(rcChannel);		// function to return remote controller input
	}
	
	public void idleInput(){
		A.rotate(0);
	}
	
	public void turnRight(){
		A.rotate(-170, true);		
	}
	public void turnLeft(){
		A.rotate(170, true);
	}
	
	public void forward(){
		
		wheelMotorB.setPower(100);
		wheelMotorC.setPower(100);
		
		wheelMotorB.forward();
		wheelMotorC.forward();
		
		if(getRCInput()==0){
			stopMotors();			// if the button is released, stop motor function
		}
				
	}
	private void stopMotors() {
									// "stop" motor function by "floating into stop"
		wheelMotorB.flt();
		wheelMotorC.flt();					
	}

	public void closeConnection(){
		/*
		 * deallocate memory used for all motor functions. Closes all connections to all motors
		 */
		
		A.close();
		wheelMotorB.close();
		wheelMotorC.close();
		
	}
	
	public void reverse(){
		wheelMotorB.setPower(100);
		wheelMotorC.setPower(100);
		
		wheelMotorB.backward();
		wheelMotorC.backward();

		if(getRCInput()==0){		// if the button is released, stop motor function
			stopMotors();
		}		
		
	}
}

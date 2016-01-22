package remoteDragRacer;
import lejos.hardware.*;
import lejos.hardware.motor.*;
import lejos.hardware.port.MotorPort;
import lejos.hardware.lcd.LCD;

public class RemoteControllerCar {
	
	public static void main(String[] args){
		
		LCD.drawString("Creating remote controller object...\n", 0,4);
		RemoteController rc = new RemoteController();
		LCD.drawString("Waiting for input from remote...\n", 0,4);
		
		while(true){

			switch(rc.getRCInput()){
					
				case 1:
					LCD.drawString("input received: "+ rc.getRCInput() +" ", 0,4);
					LCD.drawString("\n", 0,4);
					break;
				case 2:
					LCD.drawString("input received: "+ rc.getRCInput() +" ", 0,4);
					break;
				case 3:
					LCD.drawString("input received: "+ rc.getRCInput() +" " + "Forward", 0,4);
					LCD.drawString("\n", 0,4);
					rc.forward();
					
					break;
				case 4:
					LCD.drawString("input received: "+ rc.getRCInput() +" "+ "Reverse", 0,4);
					LCD.drawString("\n", 0,4);
					rc.reverse();
					break;

				case 0:
					LCD.drawString("no input received "+ rc.getRCInput(), 0,4);
					rc.idleInput();
					break;
			
			}
		}
		
		
		
	}
}

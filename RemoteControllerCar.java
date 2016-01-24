package remoteDragRacer;
import lejos.hardware.lcd.LCD;

public class RemoteControllerCar {
	
	public static void main(String[] args){
		
		LCD.drawString("Creating remote controller object...\n", 0,1);
		RemoteController rc = new RemoteController();
		LCD.drawString("Waiting for input from remote...\n", 0,1);
		
		while(true){
			if(rc.getRCInput()==8)		// if user presses bottom left + bottom right, end program
			{
				rc.closeConnection();
				break;
			}
			switch(rc.getRCInput()){
				/*
				 * Check the input given from the remote controller
				 * 		Top Left Button = turn right
				 * 		Bottom Left Button = turn left
				 * 		Top Right = forward
				 * 		Bottom Right = reverse
				 * 
				 *	if no input is received, then input returned by user is "0"
				 */
					
				case 1:
					LCD.drawString("input received: "+ rc.getRCInput() +" ", 0,4);
					LCD.drawString("\n", 0,4);
					rc.turnRight();
					break;
				case 2:
					LCD.drawString("input received: "+ rc.getRCInput() +" ", 0,4);
					rc.turnLeft();
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
					rc.idleInput();
					break;
		
			}
		}		
	}
}

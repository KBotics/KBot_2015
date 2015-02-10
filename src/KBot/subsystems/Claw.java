package KBot.subsystems;

import KBot.RobotMap;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Claw extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public Claw()
	{
		RobotMap.clawTalon.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		RobotMap.clawTalon.enableControl();
		RobotMap.clawTalon.setPID(0, 0, 0);
		RobotMap.clawTalon.setProfile(0);
	}
	
    public void initDefaultCommand() 
    {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}


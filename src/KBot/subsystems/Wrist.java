package KBot.subsystems;

import KBot.Robot;
import KBot.RobotMap;
import KBot.commands.GetVisionData;
import KBot.commands.MoveWrist;
import KBot.commands.OpenClaw;
import KBot.commands.WristController;
import edu.wpi.first.wpilibj.CANTalon.ControlMode;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * The Wrist subsystem uses Talon SRX position mode PID using a potentiometer to
 * rotate the wrist.
 */
public class Wrist extends Subsystem {
	
	private final static int THRESHOLD = 10;	

	public Wrist()
	{
		RobotMap.wristTalon.setProfile(0);
		RobotMap.wristTalon.changeControlMode(ControlMode.Position);
		RobotMap.wristTalon.setFeedbackDevice(FeedbackDevice.AnalogPot);
		//RobotMap.wristTalon.reverseSensor(true);	// NOT needed
		RobotMap.wristTalon.setVoltageRampRate(24);		// use if necessary
		RobotMap.wristTalon.setCloseLoopRampRate(0);
		RobotMap.wristTalon.setPID(50.0, 0.0001, 2.0);
		RobotMap.wristTalon.enableControl();
	}

    public void initDefaultCommand() {
        setDefaultCommand(new WristController());   	
    }
    
    public void setAngle(double angle)
    {
		if (Robot.oi.operator.getOverride()  && Robot.isTeleop()) {
			//System.out.println("Wrist ignored a command due to Manual Override");
			return;
		}
		double pos = 756+angle*1.411;
    	RobotMap.wristTalon.set(pos);
    	//System.out.println("Wrist set to angle adc="+pos);
    }
    
    public void up()
    {
    	setAngle(105);
    }
    
    public void level()
    {
    	setAngle(0);
    }

    public void down()
    {
    	setAngle(-30);	
    }
    
    public void setVoltageMode()
    {
		RobotMap.wristTalon.changeControlMode(ControlMode.PercentVbus);
		RobotMap.wristTalon.enableControl();	//is it needed?
		RobotMap.wristTalon.set(0);
    }
    
    public void setPositionMode()
    {
		RobotMap.wristTalon.changeControlMode(ControlMode.Position);
		RobotMap.wristTalon.enableControl();	//is it needed?
		RobotMap.wristTalon.set(RobotMap.wristTalon.getPosition());	// set setpoint to current position
    }
    
    public void setSpeed(double speed)
    {
		RobotMap.wristTalon.set(-speed); // Make positive up
    }
    
    public void stop()
    {
		if (RobotMap.wristTalon.getControlMode() != ControlMode.Position) {
			RobotMap.wristTalon.changeControlMode(ControlMode.Position);
		} 

		RobotMap.wristTalon.set(RobotMap.wristTalon.getPosition());	// set setpoint to current position
		RobotMap.wristTalon.ClearIaccum();							// clear built up error term
		
		// Leave PID on to maintain the position.
	}
    
    public boolean isLimitSwitchFaulted()
    {
    	return false; //TODO: put back:  RobotMap.wristTalon.getFaultForLim()!=0 || RobotMap.wristTalon.getFaultRevLim()!=0;
    }
    
    public boolean isFinished()
    {
    	return RobotMap.wristTalon.getClosedLoopError()<THRESHOLD;
    }
    
    public int getPIDError()
    {
    	return RobotMap.wristTalon.getClosedLoopError();
    }
}


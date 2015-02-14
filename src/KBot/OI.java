package KBot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import KBot.XboxController;
import KBot.commands.ClawController;
import KBot.commands.LiftController;
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
	public Joystick leftDriver = new Joystick(0);
	public Joystick rightDriver = new Joystick(1);
	public OperatorController operator = new OperatorController(2);
	
	public OI()
	{
		
		Button level0 = new JoystickButton(operator.m_joy, OperatorController.OPERATOR_0);
		Button level1 = new JoystickButton(operator.m_joy, OperatorController.OPERATOR_1);
		Button level2 = new JoystickButton(operator.m_joy, OperatorController.OPERATOR_2);
		Button level3 = new JoystickButton(operator.m_joy, OperatorController.OPERATOR_3);
		Button level4 = new JoystickButton(operator.m_joy, OperatorController.OPERATOR_4);
		Button level5 = new JoystickButton(operator.m_joy, OperatorController.OPERATOR_5);
		Button open = new JoystickButton(operator.m_joy, OperatorController.OPERATOR_OPEN);
		Button close = new JoystickButton(operator.m_joy, OperatorController.OPERATOR_CLOSE);
		Button raise = new JoystickButton(operator.m_joy, OperatorController.OPERATOR_RAISE);
		Button lower = new JoystickButton(operator.m_joy, OperatorController.OPERATOR_LOWER);
		
		/*
		level0.whenPressed(new LiftController(0));
		level1.whenPressed(new LiftController(0));
		level2.whenPressed(new LiftController(0));
		level3.whenPressed(new LiftController(0));
		level4.whenPressed(new LiftController(0));
		level5.whenPressed(new LiftController(0));
		
		open.whenPressed(new ClawController());
		close.whenPressed(new ClawController());
		raise.whenPressed(new LiftController(LiftController.offset.RAISE));
		lower.whenPressed(new LiftController(LiftController.offset.LOWER));
		*/
		
	}

	
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
}

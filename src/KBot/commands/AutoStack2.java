package KBot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import KBot.subsystems.Lift;

/**
 * Get 1 bin and 2 totes in autonomous.
 * Procedure:
 * - close claw (on bin)
 * - raise it up
 * - tilt back
 * - move up to tote
 * - raise tote
 * - track next tote
 * - lower onto tote
 * - move back, down, fwd
 * - raise stack of 3

 * - turn left
 * - drive fwd into auto zone
 * - lower and back up
 */
public class AutoStack2 extends CommandGroup {
    
	// Might be able to do this from the other end (beside the yellow tote) and pick up the bin over the tote.
	
    public  AutoStack2() {
    	addSequential(new CloseClaw());
    	// MUST RAISE BEFORE TILTING!!
    	addSequential(new MoveLifter(Lift.level.LVL0, Lift.offset.LOWER));
    	//addSequential(new RotateWrist(105));
    	addSequential(new DriveRelative(0.5, 0.0, 0.4));	// move up to first tote
    	addParallel(new DriveRelative(0.2, 0.0, 0.2));		// drive a bit while lifting tote out of blind spot
    	addSequential(new MoveLifter(Lift.level.LVL0, Lift.offset.RAISE));
    	// raise more while tracking next tote
    	addParallel(new MoveLifter(Lift.level.LVL1, Lift.offset.RAISE));
    	addSequential(new TrackYellowTote());
    	addSequential(new DriveRelative(0.0, 0.0, 0.1)); 	// stop
    	
       	addSequential(new MoveLifter(Lift.level.LVL1, Lift.offset.LOWER));
    	addSequential(new DriveRelative(-0.2, 0.0, 0.1));	// get hook out of the way
    	addSequential(new MoveLifter(Lift.level.LVL0, Lift.offset.LOWER));
    	addSequential(new DriveRelative(+0.2, 0.0, 0.1));	// back in
    	addParallel(new DriveRelative(0.2, 0.0, 0.2));		// drive a bit while lifting 3 totes 
    	addSequential(new MoveLifter(Lift.level.LVL0, Lift.offset.RAISE));
    	
    	addSequential(new DriveRelative(0.45, -1.0, 0.45));	// turn left 90
    	addSequential(new DriveRelative(0.5, 0.0, 3.0));	// drive to auto zone
    	addSequential(new MoveLifter(Lift.level.LVL0, Lift.offset.LOWER));
    	addSequential(new DriveRelative(-0.4, 0.0, 0.25));	// don't touch it!
    	
    	addSequential(new MoveLifter(Lift.level.LVL0, Lift.offset.LOWER)); // placeholder??

    	addSequential(new DriveRelative(0.0, 0.0, 10)); 	// stop
    }
}

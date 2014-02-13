package edu.wpi.first.wpilibj.templates.commands;


/**
 * This command causes the arms to swing inward, picking up balls
 *
 * @author Jackson
 */
public class ArmPickUpCommand extends CommandBase {
    private boolean isFinished = false;
    
    public ArmPickUpCommand() {
        requires(arms);        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        System.out.println("Arms - IN: Start"); //<<<<<<<<< Debugger message
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        arms.pickUp();
        if (oi.armIn.get() == false) {
            isFinished = true;
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isFinished;
    }

    // Called once after isFinished returns true
    protected void end() {
        isFinished = false;
        arms.stop();
        System.out.println("Arms - IN: Stop"); //<<<<<<<<< Debugger message
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

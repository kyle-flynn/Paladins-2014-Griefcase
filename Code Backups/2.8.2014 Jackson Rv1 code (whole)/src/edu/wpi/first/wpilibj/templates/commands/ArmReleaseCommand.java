package edu.wpi.first.wpilibj.templates.commands;


/**
 *
 * @author Jackson
 */
public class ArmReleaseCommand extends CommandBase {
    private boolean isFinished = false;
    
    public ArmReleaseCommand() {
        requires(arms);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        arms.letGo();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (oi.armOut.get() == false) {
            isFinished = true;
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isFinished;      
    }

    // Called once after isFinished returns true
    protected void end() {
        arms.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

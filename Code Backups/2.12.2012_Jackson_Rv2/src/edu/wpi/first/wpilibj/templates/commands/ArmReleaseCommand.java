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
        System.out.println("Arms - OUT: Start"); //<<<<<<<<< Debugger message
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        arms.releaseBall();
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
        isFinished = false;
        arms.stop();
        System.out.println("Arms - OUT: Stop"); //<<<<<<<<< Debugger message
    }

    /*
     * Establishes that ArmPickUpCommand has precidence over ArmReleaseCommand
     */
    protected void interrupted() {
        end();
    }
}

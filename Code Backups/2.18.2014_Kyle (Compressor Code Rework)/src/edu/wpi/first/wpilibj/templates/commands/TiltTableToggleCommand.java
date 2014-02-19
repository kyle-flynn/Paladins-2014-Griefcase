/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

/**
 *
 * @author Kyle Flynn
 */
public class TiltTableToggleCommand extends CommandBase {
    
    public TiltTableToggleCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(tilt);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        if(tilt.getPosition() == Value.kForward) {
            tilt.tiltTableDown();
        } else {
            tilt.tiltTableUp();
        }
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

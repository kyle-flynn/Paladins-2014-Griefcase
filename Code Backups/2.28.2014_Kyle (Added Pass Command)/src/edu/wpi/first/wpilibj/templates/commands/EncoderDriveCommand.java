/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author Kyle Flynn
 */
public class EncoderDriveCommand extends CommandBase {
    
    public EncoderDriveCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        
        requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        chassis.resetEncoders();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        chassis.drive(0.25f);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return !(chassis.encoderClicksToFeet(chassis.getLeftEncoder().get()) < 5.0 && chassis.encoderClicksToFeet(chassis.getRightEncoder().get()) < 5.0);
    }

    // Called once after isFinished returns true
    protected void end() {
        chassis.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        chassis.stop();
    }
}

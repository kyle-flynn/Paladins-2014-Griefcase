/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author Jackson, Taylor, Thomas
 */
public class ArmsCommand extends CommandBase {
    
    public ArmsCommand() {
        requires(arms);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (oi.stickOne.getRawAxis(RobotMap.TRIGGER_AXIS) > 0) {
            arms.leftPickUp();
        }
        else if (oi.stickOne.getRawAxis(RobotMap.TRIGGER_AXIS) < 0) {
            arms.leftReleaseBall();
        }
        else {
            arms.leftStop();
        }
        if (oi.stickOne.getRawButton(RobotMap.BUTTON_LEFT_BUMPER)) {
            arms.rightPickUp();
        }
        else if (oi.stickOne.getRawButton(RobotMap.BUTTON_RIGHT_BUMPER)) {
            arms.rightReleaseBall();
        }
        else {
            arms.rightStop();
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

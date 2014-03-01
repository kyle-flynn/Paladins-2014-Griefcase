/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.autonomous;

import edu.wpi.first.wpilibj.templates.commands.CommandBase;

/**
 *
 * @author Kyle Flynn
 */
public class AutonomousArmsCommand extends CommandBase {
    
    private int dir;
    private float speed;
    
    public AutonomousArmsCommand(int dir, float speed) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        this.dir = dir;
        this.speed = speed;
        requires(arms);
    }

    public AutonomousArmsCommand(int dir) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        this.dir = dir;
        this.speed = 1.0f;
        requires(arms);
    }
    
    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if(dir == -1) {
            // Move arms in
            arms.leftPickUp(speed);
            arms.rightPickUp(speed);
        } else if(dir == 1) {
            // Move arms out
            arms.leftReleaseBall(speed);
            arms.rightReleaseBall(speed);
        } else {
            System.out.println("u dun screwed up. kill urself");
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
        arms.leftStop();
        arms.rightStop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        arms.leftStop();
        arms.rightStop();
    }
}

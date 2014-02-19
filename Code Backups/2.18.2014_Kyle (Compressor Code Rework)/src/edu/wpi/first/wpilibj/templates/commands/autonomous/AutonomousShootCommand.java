/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.autonomous;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;

/**
 *
 * @author Kyle Flynn
 */
public class AutonomousShootCommand extends CommandBase {
    
    private boolean isHot;
    
    public AutonomousShootCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        isHot = SmartDashboard.getBoolean("Hotness");
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(isHot) {
            return true;
        } else {
            return false;
        }
    }

    // Called once after isFinished returns true
    protected void end() {
        System.out.println("WE SHOT, YAY.");
        shooter.shoot();
        Timer.delay(0.25);
        shooter.unshoot();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        System.out.println("WE SHOT, YAY.");
//        shooter.shoot();
//        Timer.delay(0.25);
//        shooter.unshoot();
    }
}

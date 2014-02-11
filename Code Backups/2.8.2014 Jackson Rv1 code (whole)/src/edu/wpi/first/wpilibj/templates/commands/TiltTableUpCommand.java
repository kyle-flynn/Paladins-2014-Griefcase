/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author Jackson, Taylor, Thomas
 */
public class TiltTableUpCommand extends CommandBase {
    
    public TiltTableUpCommand() {
        requires(shooter);
    }
    
    protected void initialize() {
        shooter.tiltTableUp();
    }
    
    protected void execute() {
    }
    
    protected boolean isFinished() {
        return true;
    }
    
    protected void end() {
    }
    
    protected void interrupted() {
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author Jackson, Taylor, Thomas
 */
public class TiltTableDownCommand extends CommandBase {
    
    public TiltTableDownCommand() {
        requires(shooter);
    }
    
    protected void initialize() {
        shooter.tiltTableDown();
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

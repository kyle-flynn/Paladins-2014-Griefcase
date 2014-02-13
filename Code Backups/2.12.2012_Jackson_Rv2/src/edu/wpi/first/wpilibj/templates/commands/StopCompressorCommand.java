/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author Jackson, Taylor, Thomas
 */
public class StopCompressorCommand extends CommandBase {
    
    public StopCompressorCommand() {
        requires(compressor);
    }
    
    protected void initialize() {
        compressor.stopCompressor();       
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

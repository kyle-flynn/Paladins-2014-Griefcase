/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author Jackson, Taylor, Thomas
 */
public class StartCompressorCommand extends CommandBase {
    
    public StartCompressorCommand() {
        requires(compressor);
    }
    
    protected void initialize() {
        compressor.startCompressor();
    }
    
    protected void execute() {
        
    }
    
    protected boolean isFinished() {
        return compressor.getIsPressureSwitchTriggered();
    }
    
    protected void end() {
        compressor.stopCompressor();
    }
    
    protected void interrupted() {
        compressor.stopCompressor();
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.Relay;

/**
 *
 * @author Jackson, Taylor, Thomas
 */
public class CompressorSubsystem extends Subsystem {
    private DigitalInput pressureSwitch;
    private Relay        compressor;
    
    
    public void initDefaultCommand() {
        
    }
    
    public CompressorSubsystem() {
        pressureSwitch = new DigitalInput(RobotMap.PRESSURE_SWITCH);
        compressor     = new Relay(RobotMap.COMPRESSOR);
    }
    
    public void startCompressor() {
        compressor.set(Relay.Value.kOn);
    }
    
    public void stopCompressor() {
        compressor.set(Relay.Value.kOff);
    }
    
    public boolean getIsPressureSwitchTriggered() {
        return pressureSwitch.get();
    }
}

package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.ToggleLightCommand;

/**
 *
 * @author Jackson, Taylor, Thomas
 */
public class LightSubsystem extends Subsystem {
    private Relay lightRelay;
    
    public void initDefaultCommand() {
    }
    
    public LightSubsystem() {
        lightRelay = new Relay(RobotMap.CAMERA_LIGHT);
    }
    
    public void turnLightOn() {
        //lightRelay.set(Value.kOn);
        lightRelay.set(Value.kForward);
    }
    
    public void turnLightOff() {
        lightRelay.set(Value.kOff);
    }
    
    public boolean isLightOn() {
        if(lightRelay.get() == Value.kForward) {
            return true;
        } else {
            return false;
        }
    }
}

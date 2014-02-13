package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.templates.RobotMap;

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
        lightRelay.set(Relay.Value.kOn);
    }
    
    public void turnLightOff() {
        lightRelay.set(Relay.Value.kOff);
    }
    
    public boolean isLightOn() {
        final int LIGHT_ON  = 1;
        final int LIGHT_OFF = 0;
        
        switch(lightRelay.get().value) {
            case LIGHT_ON : return true;
            case LIGHT_OFF : return false;
            default : return false;
        }
    }
}

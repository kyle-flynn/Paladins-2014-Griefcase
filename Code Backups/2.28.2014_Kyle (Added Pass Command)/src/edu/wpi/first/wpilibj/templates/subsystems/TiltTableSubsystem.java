/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author Kyle Flynn
 */
public class TiltTableSubsystem extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    private DoubleSolenoid tiltPiston;
    
    public TiltTableSubsystem() {
        tiltPiston = new DoubleSolenoid(RobotMap.TABLE_TILT_UP, RobotMap.TABLE_TILT_DOWN);
    }
    
    public void tiltTableUp() {
        tiltPiston.set(DoubleSolenoid.Value.kForward);
    }
    
    public void tiltTableDown() {
        tiltPiston.set(DoubleSolenoid.Value.kReverse);
    }
    
    public Value getPosition() {
        return tiltPiston.get();
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

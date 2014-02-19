/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author Taylor, Drew, Jackson
 */
public class ShooterSubsystem extends Subsystem {
    private Talon kickerTalon;
    private Jaguar kickerJaguar;
    
    private DoubleSolenoid kickerLatch;
    private DigitalInput kickerLimitSwitch;
    private DigitalInput kickerMotorReturnSwitch;
    
    private final double KICK_MOTOR_SPEED = 0.3;
    public final int DRAW_KICKER_BACK        = -1;
    public final int ROTATE_KICKER_FORWARD   = 1;

    public void initDefaultCommand() {

    }
    
    public ShooterSubsystem() {
        kickerLatch = new DoubleSolenoid(RobotMap.KICKER_LATCH_RELEASE, RobotMap.KICKER_LATCH_RELOAD);
        kickerLatch.set(DoubleSolenoid.Value.kForward);
        
        if (RobotMap.IS_REAL_BOT == true) {
            kickerTalon = new Talon(RobotMap.KICKER_MOTOR);
            kickerTalon.set(0.0);
        }
        else if (RobotMap.IS_REAL_BOT == false) {
            kickerJaguar = new Jaguar(RobotMap.KICKER_MOTOR);
            kickerJaguar.set(0.0);
        }
        
        kickerLimitSwitch       = new DigitalInput(RobotMap.KICKER_RETRACTED_SWITCH);
        kickerMotorReturnSwitch = new DigitalInput(RobotMap.KICKER_MOTOR_RETURN_SWITCH);
    }
    
    public void shoot() {
        kickerLatch.set(Value.kReverse);
    }
    
    public void unshoot() {
        kickerLatch.set(DoubleSolenoid.Value.kForward);
    }
    
    public void shoot(float speed) {
        kickerTalon.set(speed);
    }
    
    /*
     * 
     * @param direction -1 to draw the arm back, +1 to rotate motor forward away from arm.
     * 
     */
    public void reload(int direction) {
        final int REVERSE = -1;
        
        if (direction == DRAW_KICKER_BACK) {
            if (RobotMap.IS_REAL_BOT == true) {
                kickerTalon.set(REVERSE * (0.6)); //TODO: Check to make sure the motors will draw back when recieving a positive voltage.
            }
            else if (RobotMap.IS_REAL_BOT == false) {
                kickerJaguar.set(REVERSE * KICK_MOTOR_SPEED);
            }
        }
        
        else if (direction == ROTATE_KICKER_FORWARD) {
            if (RobotMap.IS_REAL_BOT == true) {
                kickerTalon.set(KICK_MOTOR_SPEED);
            }
            else if (RobotMap.IS_REAL_BOT == false) {
                kickerJaguar.set(KICK_MOTOR_SPEED);
            }
        }
    }
    
    public void stopMotor() {
        if (RobotMap.IS_REAL_BOT == true) {
                kickerTalon.set(0.0);
        }
        else if (RobotMap.IS_REAL_BOT == false) {
            kickerJaguar.set(0.0);
        }
    }
    
    public boolean isKickerLimitSwitchTriggered() {
        return !kickerLimitSwitch.get();
    }
    
    public boolean isKickerMotorReturnSwitchTriggered() {
        return !kickerMotorReturnSwitch.get();
    }
}

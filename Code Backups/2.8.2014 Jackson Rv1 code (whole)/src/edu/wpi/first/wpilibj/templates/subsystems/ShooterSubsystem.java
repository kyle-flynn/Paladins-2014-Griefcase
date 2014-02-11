/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author Taylor, Drew, Jackson
 */
public class ShooterSubsystem extends Subsystem {
    private Talon kickerTalon;
    private Jaguar kickerJaguar;
    
    private DoubleSolenoid tiltPiston;
    
    private DoubleSolenoid kickerLatch;
    private DigitalInput kickerLimitSwitch;
    private DigitalInput kickerMotorReturnSwitch;
    
    private final double KICK_MOTOR_SPEED = 0.5;
    public final int DRAW_KICKER_BACK        = -1;
    public final int ROTATE_KICKER_FORWARD   = 1;

    public void initDefaultCommand() {

    }
    
    public ShooterSubsystem() {
        kickerLatch = new DoubleSolenoid(RobotMap.KICKER_LATCH_RELEASE, RobotMap.KICKER_LATCH_RELOAD);
        kickerLatch.set(DoubleSolenoid.Value.kReverse);
        
        tiltPiston = new DoubleSolenoid(RobotMap.TABLE_TILT_UP, RobotMap.TABLE_TILT_DOWN);
        
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
        kickerLatch.set(DoubleSolenoid.Value.kForward);
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
                kickerTalon.set(KICK_MOTOR_SPEED); //TODO: Check to make sure the motors will draw back when recieving a positive voltage.
            }
            else if (RobotMap.IS_REAL_BOT == false) {
                kickerJaguar.set(KICK_MOTOR_SPEED);
            }
        }
        
        else if (direction == ROTATE_KICKER_FORWARD) {
            if (RobotMap.IS_REAL_BOT == true) {
                kickerTalon.set(REVERSE * KICK_MOTOR_SPEED);
            }
            else if (RobotMap.IS_REAL_BOT == false) {
                kickerJaguar.set(REVERSE * KICK_MOTOR_SPEED);
            }
        }
        
        else {
            System.out.println("Parameter 'direction' in class ShooterSubsystem on line ** was found to be neither -1, nor 1.\nTry checking the Reload command for errors.");
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
    
    public void tiltTableUp() {
        tiltPiston.set(DoubleSolenoid.Value.kForward);
    }
    
    public void tiltTableDown() {
        tiltPiston.set(DoubleSolenoid.Value.kReverse);
    }
    
    public boolean isKickerLimitSwitchTriggered() {
        return kickerLimitSwitch.get();
    }
    
    public boolean isKickerMotorReturnSwitchTriggered() {
        return kickerMotorReturnSwitch.get();
    }
}

package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 * This subsystem operates the arms on the robot to pick up balls.
 * 
 * @author Taylor, Drew, Jackson
 */
public class ArmsSubsystem extends Subsystem {
    private final double ARM_MOTOR_SPEED = 0.5;
    private Talon armTalon;
    private Jaguar armJaguar;
    

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public ArmsSubsystem() {
        if (RobotMap.IS_REAL_BOT == true) {
            armTalon = new Talon(RobotMap.ARM_MOTORS);
            armTalon.set(0.0);
        }
        else if (RobotMap.IS_REAL_BOT == false) {
            armJaguar = new Jaguar(RobotMap.ARM_MOTORS);
            armJaguar.set(0.0);
        }
    }
    
    /*
     * Swings the arms inward.
     */
    public void pickUp() {
        if (RobotMap.IS_REAL_BOT == true) {
            armTalon.set(ARM_MOTOR_SPEED);            
        }
        else if (RobotMap.IS_REAL_BOT == false) {
            armJaguar.set(ARM_MOTOR_SPEED);
        }
    }
    
    /*
     * Swings the arms outward.
     */
    public void letGo() { //TODO: Rename this class to make more sense.
        if (RobotMap.IS_REAL_BOT == true) {
            armTalon.set(-1 * ARM_MOTOR_SPEED);            
        }
        else if (RobotMap.IS_REAL_BOT == false) {
            armJaguar.set(-1 * ARM_MOTOR_SPEED);
        }
    }
    
    public void stop() {
        if (RobotMap.IS_REAL_BOT == true) {
            armTalon.set(0.0);
        }
        else if (RobotMap.IS_REAL_BOT == false) {
            armJaguar.set(0.0);
        }
    }
}

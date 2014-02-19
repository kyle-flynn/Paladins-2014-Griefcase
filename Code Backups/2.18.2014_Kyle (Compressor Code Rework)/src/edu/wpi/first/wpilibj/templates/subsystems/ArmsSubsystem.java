package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.SafePWM;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.ArmsCommand;

/**
 * This subsystem operates the arms on the robot to pick up and let go of game balls.
 * 
 * @author Taylor, Drew, Jackson
 */
public class ArmsSubsystem extends Subsystem {
    private static final int REVERSE     = -1;
    private final double ARM_MOTOR_SPEED = 0.4;
    private Talon rightArmTalon;
    private Talon leftArmTalon;
    private Jaguar rightArmJaguar;
    private Jaguar leftArmJaguar;

    public void initDefaultCommand() {
        setDefaultCommand(new ArmsCommand());
    }
    
    public ArmsSubsystem() {
        if (RobotMap.IS_REAL_BOT == true) {
            leftArmTalon = new Talon(RobotMap.LEFT_ARM_MOTOR);
            rightArmTalon = new Talon(RobotMap.RIGHT_ARM_MOTOR);
        }
        else if (RobotMap.IS_REAL_BOT == false) {
            leftArmJaguar = new Jaguar(RobotMap.LEFT_ARM_MOTOR);
            rightArmJaguar = new Jaguar(RobotMap.RIGHT_ARM_MOTOR);
        }
    }
    
    /*
     * Swings the arms inward toward the robot.
     */
    public void rightPickUp() {
        if (RobotMap.IS_REAL_BOT == true) {
            rightArmTalon.set(ARM_MOTOR_SPEED + 0.075);
        }
        else {
           rightArmJaguar.set(ARM_MOTOR_SPEED + 0.075); 
        }
    }
    
    public void leftPickUp() {
        if (RobotMap.IS_REAL_BOT == true) {
            leftArmTalon.set(REVERSE * ARM_MOTOR_SPEED);
        }
        else {
           leftArmJaguar.set(REVERSE * ARM_MOTOR_SPEED); 
        }
    }
    
    /*
     * Swings the arms outward away from the robot.
     */
    public void rightReleaseBall() {
        if (RobotMap.IS_REAL_BOT == true) {
            rightArmTalon.set(REVERSE * (ARM_MOTOR_SPEED + 0.175));
        }
        else {
           rightArmJaguar.set(REVERSE * (ARM_MOTOR_SPEED + 0.175)); 
        }
    }
    
    public void leftReleaseBall() {
        if (RobotMap.IS_REAL_BOT == true) {
            leftArmTalon.set(ARM_MOTOR_SPEED);
        }
        else {
           leftArmJaguar.set(ARM_MOTOR_SPEED); 
        }
    }
    
    public void leftStop() {
        if (RobotMap.IS_REAL_BOT == true) {
            leftArmTalon.set(0.0);
        }
        else {
            leftArmJaguar.set(0.0);
        }
    }
    
    /*
     * Stops applying voltage to the arm motors.
     */
    public void rightStop() {
        if (RobotMap.IS_REAL_BOT == true) {
            rightArmTalon.set(0.0);
        }
        else if (RobotMap.IS_REAL_BOT == false) {
            rightArmJaguar.set(0.0);
        }
    }
    
    public SafePWM getLeftArm() {
        if(RobotMap.IS_REAL_BOT) {
            return leftArmTalon;
        } else {
            return leftArmJaguar;
        }
    }
    
    public SafePWM getRightArm() {
        if(RobotMap.IS_REAL_BOT) {
            return rightArmTalon;
        } else {
            return rightArmJaguar;
        }
    }
    
}

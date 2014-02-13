
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.DriveCommand;

/**
 *@author Kyle, Jackson, Taylor
 */
public class ChassisSubsystem extends Subsystem {
    RobotDrive chassis = new RobotDrive(RobotMap.LEFT_MOTORS, RobotMap.RIGHT_MOTORS); //<<<<<<<<< drive is not a problem here
    
    private DoubleSolenoid transmission;
    
    private Encoder leftEncoder = new Encoder(RobotMap.CHASSIS_ENCODER_L_A, RobotMap.CHASSIS_ENCODER_L_B);
    private Encoder rightEncoder = new Encoder(RobotMap.CHASSIS_ENCODER_R_A, RobotMap.CHASSIS_ENCODER_R_B);
    
    /*
     * Sets the initial transmission state to low gear.
     */
    public ChassisSubsystem() {
        transmission  = new DoubleSolenoid(RobotMap.TRANSMISSION_SOLENOID_LOW, RobotMap.TRANSMISSION_SOLENOID_HIGH);
        transmission.set(Value.kForward);
    }
    
    public void initDefaultCommand() {        
        setDefaultCommand(new DriveCommand());
    }
    
    public void drive(Joystick stick) {
        chassis.tankDrive(stick.getRawAxis(2), stick.getRawAxis(5));
        SmartDashboard.putNumber("y - axis left: ", stick.getY(GenericHID.Hand.kLeft));
        SmartDashboard.putNumber("x - axis left: ", stick.getX(GenericHID.Hand.kLeft));
        SmartDashboard.putNumber("z - axis left: ", stick.getZ(GenericHID.Hand.kLeft));
        SmartDashboard.putNumber("y - axis right: ", stick.getY(GenericHID.Hand.kRight));
        SmartDashboard.putNumber("x - axis right: ", stick.getX(GenericHID.Hand.kRight));
        SmartDashboard.putNumber("z - axis right: ", stick.getZ(GenericHID.Hand.kRight));
    }
    
    public void drive(float speed) {
        chassis.drive(speed, 0.0);
    }
    
    public void shiftGears() {        
        if (transmission.get().value == RobotMap.TRANSMISSION_SOLENOID_LOW) {
            transmission.set(Value.kReverse);
        }
        else {
            transmission.set(Value.kForward);
        }
    }
    
    /*
     * Stops outputting voltage to the drive motors.
     */
    public void stop() {
        chassis.drive(0, 0);
    }
    
    public void resetEncoders() {
        leftEncoder.reset();
        rightEncoder.reset();
    }
    
    public double encoderClicksToFeet(int clicks) {
        return clicks * RobotMap.DRIVE_WHEEL_DIAMETER_FEET * RobotMap.MOTOR_TO_WHEEL_GEAR_RATIO * Math.PI / RobotMap.ENCODER_PULSES_PER_REVOLUTION;
    }
    
    public int feetToEncoderClicks(double feet){
        return (int) (RobotMap.ENCODER_PULSES_PER_REVOLUTION * feet / (RobotMap.MOTOR_TO_WHEEL_GEAR_RATIO * RobotMap.DRIVE_WHEEL_DIAMETER_FEET * Math.PI));
    }
    
    public Encoder getLeftEncoder() {
        return leftEncoder;
    }
    
    public Encoder getRightEncoder() {
        return rightEncoder;
    }
    
    /*
     * Returns a 1 for low gear
     * Returns a 2 for high gear
     */
    public int getGear() {
        return transmission.get().value;
    }
}


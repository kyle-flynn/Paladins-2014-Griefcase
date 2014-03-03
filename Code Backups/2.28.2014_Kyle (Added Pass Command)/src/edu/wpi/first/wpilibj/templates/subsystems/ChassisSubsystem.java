
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.DriveCommand;

/**
 *@author Kyle, Jackson, Taylor
 */
public class ChassisSubsystem extends Subsystem {
    private RobotDrive chassis;
    private Gyro gyro;
    
    private final int HIGH_GEAR = 1;
    
    private DoubleSolenoid transmission;
    
    private Encoder leftEncoder;
    private Encoder rightEncoder;
    
    /*
     * Sets the initial transmission state to low gear.
     */
    public ChassisSubsystem() {
        transmission  = new DoubleSolenoid(RobotMap.TRANSMISSION_SOLENOID_LOW, RobotMap.TRANSMISSION_SOLENOID_HIGH);
        transmission.set(Value.kForward);
        
        chassis = new RobotDrive(RobotMap.LEFT_MOTORS, RobotMap.RIGHT_MOTORS);
        gyro = new Gyro(RobotMap.GYRO);
        leftEncoder = new Encoder(RobotMap.CHASSIS_ENCODER_L_A, RobotMap.CHASSIS_ENCODER_L_B);
        rightEncoder = new Encoder(RobotMap.CHASSIS_ENCODER_R_A, RobotMap.CHASSIS_ENCODER_R_B);
        
        leftEncoder.setReverseDirection(true);
        leftEncoder.start();
        rightEncoder.start();
        
        gyro.reset();
    }
    
    public void initDefaultCommand() {        
        setDefaultCommand(new DriveCommand());
    }
    
    public void drive(Joystick stick) {
        chassis.tankDrive(stick.getRawAxis(2), stick.getRawAxis(5));
    }
    
    public void drive(float speed) {
        chassis.drive(speed, 0.0);
    }
    
    public void shiftGears(int gear) {        
        if (gear == HIGH_GEAR) {
            transmission.set(Value.kReverse);
            System.out.println("Gear: high");
        }
        else {
            transmission.set(Value.kForward);
            System.out.println("Gear: low");
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
    
    public DoubleSolenoid getGearSolenoid() {
        return transmission;
    }
    
    public RobotDrive getRobotDrive() {
        return chassis;
    }
    
    public double getRobotAngle() {
        return gyro.getAngle();
    }
    
}


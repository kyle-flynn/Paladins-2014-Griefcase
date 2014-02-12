package edu.wpi.first.wpilibj.templates;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 * 
 * 
 * Any changes to this map should be confirmed by a leader on the programming or
 * electrical team!!!
 */

public class RobotMap {
    //Modes
    public static final boolean IS_REAL_BOT          = false;
    public static final boolean DOES_USE_AUTO_RELOAD = true;
    
    //Sidecar: PWM Out
    public static final int RIGHT_MOTORS  = 1;
    public static final int LEFT_MOTORS   = 2;
    public static final int ARM_MOTORS    = 3;
    public static final int KICKER_MOTOR  = 4;
    
    
    //Sidecar: Digital IO
    public static final int CHASSIS_ENCODER_R_A        = 1;
    public static final int CHASSIS_ENCODER_R_B        = 2;
    public static final int CHASSIS_ENCODER_L_A        = 3;
    public static final int CHASSIS_ENCODER_L_B        = 4;
    public static final int PRESSURE_SWITCH            = 10;
    public static final int KICKER_RETRACTED_SWITCH    = 13;
    public static final int KICKER_MOTOR_RETURN_SWITCH = 14;
    
    //Sidecar: Relay
    public static final int COMPRESSOR   = 1;
    public static final int CAMERA_LIGHT = 4;
    
    
    //Solenoid Breakout
    public static final int SOLENOID_MODULE_NUMBER     = 3;
    public static final int TRANSMISSION_SOLENOID_LOW  = 1; //Pistons are extended
    public static final int TRANSMISSION_SOLENOID_HIGH = 2; //Pistons are retracted
    public static final int TABLE_TILT_UP              = 3; //Piston is extended
    public static final int TABLE_TILT_DOWN            = 4; //Piston is retracted
    public static final int KICKER_LATCH_RELEASE       = 5; //Piston is extended, this shoots the ball
    public static final int KICKER_LATCH_RELOAD        = 6; //Piston is retracted, returning the latch to its normal state

    
    public static final int STICK_ONE = 1;
    
    //xbox controller button map
    public static final int BUTTON_A          = 1;
    public static final int BUTTON_B          = 2;
    public static final int BUTTON_X          = 3;
    public static final int BUTTON_Y          = 4;
    public static final int BUTTON_LEFT_BUMP  = 5;
    public static final int BUTTON_RIGHT_BUMP = 6;
    public static final int BUTTON_BACK       = 7;
    public static final int BUTTON_START      = 8;
    public static final int BUTTON_RIGHT_TRIG = -3;
    public static final int BUTTON_LEFT_TRIG  = 3;
    
    
    
    
    //Component Specifications
    public static final double DRIVE_WHEEL_DIAMETER_FEET  = 0.5;
    public static final double MOTOR_TO_WHEEL_GEAR_RATIO  = 12/30;
    public static final int ENCODER_PULSES_PER_REVOLUTION = 360;
    
    //misc
    public static final double KICKER_RELOAD_DELAY_SECONDS = 2.0;
    
    /*
     * 1 - LeftX
    2 - LeftY
    3 - Triggers (Each trigger = 0 to 1, axis value = right - left)
    4 - RightX
    5 - RightY
    6 - DPad Left/Right
    * 
    Button mapping matches Windows Control Panel>Game Pads display
     */
    
}

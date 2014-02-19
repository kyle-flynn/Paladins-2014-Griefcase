
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.templates.commands.EncoderDriveCommand;
import edu.wpi.first.wpilibj.templates.commands.GearChangeCommand;
import edu.wpi.first.wpilibj.templates.commands.ReloadKickerCommand;
import edu.wpi.first.wpilibj.templates.commands.ShooterCommand;
import edu.wpi.first.wpilibj.templates.commands.StartCompressorCommand;
import edu.wpi.first.wpilibj.templates.commands.StopCompressorCommand;
import edu.wpi.first.wpilibj.templates.commands.TestKickerBackCommand;
import edu.wpi.first.wpilibj.templates.commands.TestKickerForwardCommand;
import edu.wpi.first.wpilibj.templates.commands.TiltTableToggleCommand;
import edu.wpi.first.wpilibj.templates.commands.ToggleLightCommand;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    private final int HIGH = 1;
    private final int LOW  = 0;
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // Another type of button you can create is a DigitalIOButton, which is
    // a button or switch hooked up to the cypress module. These are useful if
    // you want to build a customized operator interface.
    // Button button = new DigitalIOButton(1);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
    
    public Joystick stickOne        = new Joystick(RobotMap.STICK_ONE);    
    public Button shiftLow          = new JoystickButton(stickOne,RobotMap.BUTTON_RIGHT_STICK);
    public Button shiftHigh         = new JoystickButton(stickOne, RobotMap.BUTTON_LEFT_STICK);
    public Button toggleLightButton = new JoystickButton(stickOne, RobotMap.BUTTON_START);
    public Button kickForward       = new JoystickButton(stickOne, RobotMap.BUTTON_Y);
    public Button kickBack          = new JoystickButton(stickOne, RobotMap.BUTTON_A);
    public Button reloadMe          = new JoystickButton(stickOne, RobotMap.BUTTON_X);
    public Button shootMe           = new JoystickButton(stickOne, RobotMap.BUTTON_B);
    public Button toggleTable       = new JoystickButton(stickOne, RobotMap.BUTTON_START);
    public Button toggleLights      = new JoystickButton(stickOne, RobotMap.BUTTON_BACK);
    
    public Button compressor        = new JoystickButton(stickOne, RobotMap.BUTTON_B);
    public Button stopComp          = new JoystickButton(stickOne, RobotMap.BUTTON_A);
    
    public Joystick launchpadA      = new Joystick(RobotMap.LAUNCHPAD_A);
    
    public OI() {
        shiftLow.whenPressed(new GearChangeCommand(LOW));
        shiftHigh.whenPressed(new GearChangeCommand(HIGH));
        toggleLightButton.whenPressed(new ToggleLightCommand());
        kickForward.whileHeld(new TestKickerForwardCommand());
        kickBack.whileHeld(new TestKickerBackCommand());
        reloadMe.whenPressed(new ReloadKickerCommand());
        //shootMe.whenPressed(new ShooterCommand());
        toggleTable.whenPressed(new TiltTableToggleCommand());
        toggleLights.whenPressed(new ToggleLightCommand());
        
        compressor.whenPressed(new StartCompressorCommand());
        compressor.whenPressed(new StopCompressorCommand());
    }    
}
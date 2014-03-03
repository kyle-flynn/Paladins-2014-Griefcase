/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.autonomous;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.ArmsCommand;
import edu.wpi.first.wpilibj.templates.commands.ReloadKickerCommand;
import edu.wpi.first.wpilibj.templates.commands.TiltTableDownCommand;
import edu.wpi.first.wpilibj.templates.commands.TiltTableUpCommand;
import edu.wpi.first.wpilibj.templates.commands.ToggleLightCommand;

/**
 *
 * @author Kyle Flynn
 */
public class AutonomousCommand extends CommandGroup {
    
    private DigitalInput ds1 = new DigitalInput(RobotMap.AUTONOMOUS_1);
    private DigitalInput ds2 = new DigitalInput(RobotMap.AUTONOMOUS_2);
    private DigitalInput ds3 = new DigitalInput(RobotMap.AUTONOMOUS_3);
    private DigitalInput ds4 = new DigitalInput(RobotMap.AUTONOMOUS_4);
    
    public AutonomousCommand() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
        
        // ------------ Autonomous #1 ------------ //
        // Open the arms a bit (1.0 seconds?) Kick ball into the hot goal and 
        // drive forward into colored zone
        
        if(ds1.get() == true) {
            addSequential(new ToggleLightCommand());
            addSequential(new AutonomousArmsCommand(1), 1.0);
            addSequential(new AutonomousShootCommand(true), 6.0);
            addSequential(new AutonomousDriveCommand(1.0f, 0.0f, 4.0));
            addSequential(new ToggleLightCommand());
            end();
        }
        
        // ------------ Autonomous #1 ------------ //
        
        //////////////////////////////////////////////
        
        // ------------ Autonomous #2 ------------ //
        // Open the arms a bit (1.0 seconds?) Kick ball into the hot goal and 
        //drive forward into colored zone and drive back
        
        if(ds2.get() == true) {
            addSequential(new ToggleLightCommand());
            addSequential(new AutonomousArmsCommand(1), 1.0);
            addSequential(new AutonomousShootCommand(true), 6.0);
            addSequential(new AutonomousDriveCommand(1.0f, 0.0f, 4.0));
            addSequential(new AutonomousDriveCommand(0.0f, 1.0f, 0.0), 2.0);
            addSequential(new AutonomousDriveCommand(1.0f, 0.0f, 4.0));
            addSequential(new ToggleLightCommand());
            end();
        }
        
        // ------------ Autonomous #2 ------------ //
        
        /////////////////////////////////////////////
        
        // ------------ Autonomous #3 ------------ //
        // Drive back then open the arms a bit (1.0 seconds?) 
        // Kick ball into the hot goal and get the ball placed in front of us
        
        if(ds3.get() == true) {
            addSequential(new ToggleLightCommand());
            addParallel(new AutonomousArmsCommand(1, 0.25f), 2.0);
            Timer.delay(0.5);
            addSequential(new AutonomousShootCommand(false));
            Timer.delay(0.5);
            addParallel(new ReloadKickerCommand());
            addParallel(new AutonomousDriveCommand(0.5f, 0.0f, 4.0));
            Timer.delay(0.5);
            //TODO: FIX ME PLZ
            addParallel(new TiltTableDownCommand());
            addSequential(new AutonomousArmsCommand(-1, 0.25f), 2.0);
            addSequential(new TiltTableUpCommand());
            addSequential(new AutonomousArmsCommand(1), 1.0);
            addSequential(new AutonomousShootCommand(false));
            addSequential(new ToggleLightCommand());
            end();
        }
        
        // ------------ Autonomous #3 ------------ //
        
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.templates.commands.ArmsCommand;
import edu.wpi.first.wpilibj.templates.commands.ToggleLightCommand;

/**
 *
 * @author Kyle Flynn
 */
public class AutonomousCommand extends CommandGroup {
    
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
        // Open the arms a bit (1.0 seconds?) Kick ball into the hot goal and drive forward into colored zone
        
        addSequential(new ToggleLightCommand());
        addSequential(new AutonomousArmsCommand(1), 1.0);
        addSequential(new AutonomousShootCommand());
        addSequential(new AutonomousDriveCommand(1.0f, 0.0f), 2.0);
        addSequential(new ToggleLightCommand());
        
        // ------------ Autonomous #1 ------------ //
        
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author Jackson
 */
public class ReloadKickerCommand extends CommandBase {
    private boolean isKickerLimitSwitchTriggered;
    
    public ReloadKickerCommand() {
        requires(shooter);
        
        resetIsKickerLimitSwtichTriggered();
        
        if (RobotMap.DOES_USE_AUTO_RELOAD == true) {
            Timer.delay(RobotMap.KICKER_RELOAD_DELAY_SECONDS);
        }
    }
    
    protected void initialize() {
        shooter.reload(shooter.DRAW_KICKER_BACK);
    }
    
    protected void execute() {
        if (isKickerLimitSwitchTriggered == false && shooter.isKickerLimitSwitchTriggered() == true) {
            isKickerLimitSwitchTriggered = true;
            shooter.reload(shooter.ROTATE_KICKER_FORWARD);
        }
    }
    
    protected boolean isFinished() {
        return shooter.isKickerMotorReturnSwitchTriggered();
    }
    
    protected void end() {
        shooter.stopMotor();
        resetIsKickerLimitSwtichTriggered();
    }
    
    protected void interrupted() {
    }
    
    private void resetIsKickerLimitSwtichTriggered() {
        isKickerLimitSwitchTriggered = false;
    }
}
/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

public class DefaultSoftRobotics extends Command {
  public DefaultSoftRobotics() {
    requires(Robot.softrobotics);
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    boolean top_limit_switch = Robot.softrobotics.getTalon().getSensorCollection().isRevLimitSwitchClosed();
    boolean bottom_limit_switch = Robot.softrobotics.getTalon().getSensorCollection().isFwdLimitSwitchClosed();
    System.out.println("Bottom: " + bottom_limit_switch);
    System.out.println("Top: " + top_limit_switch);
    System.out.println("---------");
    
    if(Robot.m_oi.gunner_button_X.get()){
      Robot.softrobotics.hatchTalon.set(1);
    }
    else if(Robot.m_oi.gunner_button_Y.get()){
      Robot.softrobotics.hatchTalon.set(-1);
    } /*else if (top_limit_switch || bottom_limit_switch) {
      Robot.softrobotics.hatchTalon.set(0);
    }*/
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}

/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Autonomous;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class StrafeLeft extends Command {

  int TAPE_VALUE = 3750;
  double STRAFE_SPEED = .5;

  public StrafeLeft() {
    requires(Robot.line_trackers);
    requires(Robot.drivetrain);
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

    System.out.println(Robot.line_trackers.center_line_tracker.getAverageValue());
    System.out.println(TAPE_VALUE);
    System.out.println("-------");

    boolean center_linetracker_triggered = Robot.line_trackers.center_line_tracker.getValue() < TAPE_VALUE;
    System.out.println(center_linetracker_triggered);
    
    if (center_linetracker_triggered) {
      Robot.drivetrain.getDriveTrain().drivePolar(0, 0, 0);
    } else {
      Robot.drivetrain.getDriveTrain().drivePolar(STRAFE_SPEED, -90, 0);
    }
    

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return true;
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

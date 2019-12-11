/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.VictorSP;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */

   //Use the joystick plugged into the first USB port
   private Joystick driverStick = new Joystick(0);

   //Create left side motors
   VictorSP leftController = new VictorSP(0);
   VictorSP rightController = new VictorSP(1);

   //Speed controller groups
   SpeedControllerGroup leftSide = new SpeedControllerGroup(leftController);
   SpeedControllerGroup rightSide = new SpeedControllerGroup(rightController);

   //Solenoid for controlling mode swapping
   Solenoid shifter = new Solenoid(0);

   //create the butterfly drive
   private ButterflyDrive butterfly = new ButterflyDrive(leftSide, rightSide, shifter);

  @Override
  public void robotInit() {

  }

  @Override
  public void autonomousInit() {
  }

  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
  }

  //This is what the driver actually does during the game
  @Override
  public void teleopPeriodic() {

    //Left side
    double leftStick = driverStick.getRawAxis(1);

    //rights side
    double rightStick = driverStick.getRawAxis(5);

    //check if the a button was pressed
    boolean aButtonPressed = driverStick.getRawButtonPressed(1);

    //drive the robot
    butterfly.drive(leftStick, rightStick);

    //if the a button is pressed shift gears
    if(aButtonPressed){

      //shift the robot
      butterfly.shift();
    }
  }

  //never used in a real competition
  @Override
  public void testInit() {
  }

  @Override
  public void testPeriodic() {
  }

}

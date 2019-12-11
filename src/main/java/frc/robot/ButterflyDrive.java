package frc.robot;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

public class ButterflyDrive {
    
     //Speed controllers for the left and right side of the robot
    private SpeedControllerGroup leftSide;
    private SpeedControllerGroup rightSide;

    //Shifter for shifting between 
    private Solenoid transition;

    private boolean shifted = false;

    /**
     * @param leftSide left side speed controllers
     * @param rightSide right side speed controllers
     * @param transition solenoid transition 
     */
    public ButterflyDrive(SpeedControllerGroup leftSide, SpeedControllerGroup rightSide, Solenoid transition) {
        this.leftSide = leftSide;
        this.rightSide = rightSide;
        this.transition = transition;
    }

    /**
     * 
     * @param leftSpeed left drive speed
     * @param rightSpeed right drive speed
     * @param driveMode what drive mode the robot is in 
     */
    public void drive(double leftSpeed, double rightSpeed){

        //tell the robot whether it should shift or not
        transition.set(shifted);

        //set the speed of the left side
        leftSide.set(leftSpeed);

        //set the speed of the right side
        rightSide.set(rightSpeed);
    }

    /**
     * shift the drive mode to the opposite of whatever it is
     */
    public void shift() {
        //change the shifted mode to the opposite of the current state
        shifted = !shifted;
    }
}
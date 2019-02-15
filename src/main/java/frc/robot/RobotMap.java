
package frc.robot;


public class RobotMap {
    public static class CAN {
        public static int compressor = 0;
        public static int driveLH1 = 1;
        public static int driveLH2 = 2;
        public static int driveRH1 = 3;
        public static int driveRH2 = 4;
        public static int driveClimber = 5;
        public static int ballIntake = 6;
        public static int linSlide = 7;
    }
    public static class Constants {
        public static double intake = 0.4;
    }
    public static class PCM {
        public static int guide = 6;
        public static int hatchRelease = 7;
        public static int hatchLower = 3;
        public static int climberFront = 4;
        public static int climberBack = 5;
    }
}

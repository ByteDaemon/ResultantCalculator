import java.util.Scanner;

public class ResultantForceCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of forces: ");
        int numberOfForces = scanner.nextInt();
        
        if (numberOfForces <= 0) {
            System.out.println("Number of forces must be a positive integer.");
            scanner.close();
            return;
        }

        double[] forces = new double[numberOfForces];
        double[] angles = new double[numberOfForces];

        System.out.println("Enter the forces in Newton scale: ");
        for (int i = 0; i < numberOfForces; i++) {
            forces[i] = scanner.nextDouble();
            if (forces[i] < 0) {
                System.out.println("Force values must be non-negative.");
                scanner.close();
                return;
            }
        }

        System.out.println("Enter the angles between each force and the x-axis (in degrees): ");
        for (int i = 0; i < numberOfForces; i++) {
            angles[i] = scanner.nextDouble();
            if (angles[i] < 0 || angles[i] >= 360) {
                System.out.println("Angles must be in the range [0, 360).");
                scanner.close();
                return;
            }
        }

        double resultantInX = 0;
        double resultantInY = 0;

        for (int i = 0; i < numberOfForces; i++) {
            resultantInX += forces[i] * Math.cos(Math.toRadians(angles[i]));
            resultantInY += forces[i] * Math.sin(Math.toRadians(angles[i]));
        }

        double resultantMagnitude = Math.sqrt(Math.pow(resultantInX, 2) + Math.pow(resultantInY, 2));
        double resultantAngle = Math.toDegrees(Math.atan2(resultantInY, resultantInX));

        double roundedResultantInX = Math.round(resultantInX * 1000.0) / 1000.0;
        double roundedResultantInY = Math.round(resultantInY * 1000.0) / 1000.0;
        double roundedResultantMagnitude = Math.round(resultantMagnitude * 1000.0) / 1000.0;
        double roundedResultantAngle = Math.round(resultantAngle * 1000.0) / 1000.0;

        System.out.printf("Resultant Force in X direction: %.3f N%n", roundedResultantInX);
        System.out.printf("Resultant Force in Y direction: %.3f N%n", roundedResultantInY);
        System.out.printf("Resultant Force Magnitude: %.3f N%n", roundedResultantMagnitude);
        System.out.printf("Resultant Force Angle with the x-axis: %.3f degrees%n", roundedResultantAngle);

        scanner.close();
        System.out.println();
        System.out.println();
        System.out.println("-----------------@byte.daemon-----------------");
    }
}

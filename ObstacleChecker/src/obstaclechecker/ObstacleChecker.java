/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obstaclechecker;

/**
 *
 * @author Shaeakh
 */
public class ObstacleChecker {
    private double xMin;
    private double yMin;
    private double zMin;
    private double xMax;
    private double yMax;
    private double zMax;

    public ObstacleChecker(double xMin, double yMin, double zMin, double xMax, double yMax, double zMax) {
        this.xMin = xMin;
        this.yMin = yMin;
        this.zMin = zMin;
        this.xMax = xMax;
        this.yMax = yMax;
        this.zMax = zMax;
    }

    public boolean hasObstacleBetween(Point3D p, Point3D q) {
        double minX = Math.min(p.getX(), q.getX());
        double maxX = Math.max(p.getX(), q.getX());
        double minY = Math.min(p.getY(), q.getY());
        double maxY = Math.max(p.getY(), q.getY());
        double minZ = Math.min(p.getZ(), q.getZ());
        double maxZ = Math.max(p.getZ(), q.getZ());

        // Check if the bounding boxes of the line segment and the obstacle intersect
        if (maxX < xMin || minX > xMax ||
                maxY < yMin || minY > yMax ||
                maxZ < zMin || minZ > zMax) {
            return false;  // No intersection, no obstacle between the points
        }

        return true;
    }

    public static void main(String[] args) {
        double xMin = 10.783;
        double yMin = -9.8899;
        double zMin = 4.8385;
        double xMax = 11.071;
        double yMax = -9.6929;
        double zMax = 5.0665;

        ObstacleChecker obstacleChecker = new ObstacleChecker(xMin, yMin, zMin, xMax, yMax, zMax);

        // Define the points to check
        Point3D p = new Point3D(11, -8.989, 5.1);
        Point3D q = new Point3D(11.55, -8.933, 4.7175);

        // Check if there is an obstacle between the points
        boolean hasObstacle = obstacleChecker.hasObstacleBetween(p, q);

        System.out.println("Obstacle between points: " + hasObstacle);
    }
}

import java.util.Properties;
/**
 * Assignment 2: System Information Reporter
 * 
 * This program accepts command-line arguments to report various system details such as
 * CPU count, memory status, working directories, OS details, and JVM information.
 * The program is designed to be built and executed using Gradle.
 * 
 * Usage:
 * gradle -q run -PrunArgs="-cpu"
 * gradle -q run -PrunArgs="-mem"
 * gradle -q run -PrunArgs="-dirs"
 * gradle -q run -PrunArgs="-os"
 * gradle -q run -PrunArgs="-java"
 * 
 * CS3100
 * Hans Gamlien
 */
public class Assign2 {
    public static void main(String[] args) {
        if (args.length == 0) {
            return; // Do nothing if no arguments are provided
        }
        for (String arg : args) {
            switch (arg) {
                case "-cpu":
                    reportCPU();
                    break;
                case "-mem":
                    reportMemory();
                    break;
                case "-dirs":
                    reportDirectories();
                    break;
                case "-os":
                    reportOS();
                    break;
                case "-java":
                    reportJava();
                    break;
                default:
                    // None
                    break;
            }
        }
    }
    /** Reports the number of available CPUs.*/
    private static void reportCPU() {
        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println("Processors   : " + cores);
    }
    /**Reports the memory status: free, total and max memory.*/
    private static void reportMemory() {
        Runtime runtime = Runtime.getRuntime();
        System.out.println("Free Memory  : " + runtime.freeMemory());
        System.out.println("Total Memory : " + runtime.totalMemory());
        System.out.println("Max Memory   : " + runtime.maxMemory());
    }
    /**Reports the working and home directories.*/
    private static void reportDirectories() {
        System.out.println("Working Directory   : " + System.getProperty("user.dir"));
        System.out.println("User Home Directory : " + System.getProperty("user.home"));
    }
    /**Reports OS name and version.*/
    private static void reportOS() {
        System.out.println("OS Name             : " + System.getProperty("os.name"));
        System.out.println("OS Version          : " + System.getProperty("os.version"));
    }
    /** Reports Java runtime details.*/
    private static void reportJava() {
        Properties props = System.getProperties();
        System.out.println("Java Vendor         : " + props.getProperty("java.vendor"));
        System.out.println("Java Runtime        : " + props.getProperty("java.runtime.name"));
        System.out.println("Java Version        : " + props.getProperty("java.version"));
        System.out.println("Java VM Version     : " + props.getProperty("java.vm.version"));
        System.out.println("Java VM Name        : " + props.getProperty("java.vm.name"));
    }
}

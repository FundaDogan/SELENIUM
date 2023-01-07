package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import utilities.TestBase;

public class Day15_Log4J2 {

    //create object
    private static Logger logger = LogManager.getLogger(Day15_Log4J2.class.getName());

    @Test
    public void log4jTest() {

        // use logger object to log/print information
        logger.fatal("Fatal Log !!!"); // prints by default
        logger.error("Error Log !!!");  // prints by default
        logger.warn("Warning Log !!!");
        logger.debug("Debug Log !!!");
        logger.info("Info Log !!!");
    }
}

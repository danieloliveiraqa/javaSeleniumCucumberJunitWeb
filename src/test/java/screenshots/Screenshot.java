package screenshots;

import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Screenshot {

    public static BufferedImage takeScreenshot(WebDriver driver) {
        try {
            Robot robot = new Robot();
            Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage image = robot.createScreenCapture(screenRect);
            return image;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}

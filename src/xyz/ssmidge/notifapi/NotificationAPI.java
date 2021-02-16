/*
 * Copyright (c) 2021. Ssmidge https://ssmidge.xyz
 *
 *  * @author Ssmidge / ignSsmidge
 *
 */

package xyz.ssmidge.notifapi;

import java.awt.*;


public class NotificationAPI {

    public NotificationAPI(String text, String caption, String image, String tooltip, TrayIcon.MessageType type) {
        try {
            //Obtain only one instance of the SystemTray object
            SystemTray tray = SystemTray.getSystemTray();

            // If you want to create an icon in the system tray to preview
            Image Notifimage = Toolkit.getDefaultToolkit().createImage(image);
            //Alternative (if the icon is on the classpath):
            //Image image = Toolkit.getDefaultToolkit().createImage(getClass().getResource("icon.png"));

            TrayIcon trayIcon = new TrayIcon(Notifimage, "Ssmidge");
            //Let the system resize the image if needed
            trayIcon.setImageAutoSize(true);
            //Set tooltip text for the tray icon
            trayIcon.setToolTip(tooltip);
            tray.add(trayIcon);

            // Display info notification:

            trayIcon.displayMessage(text, caption, type);
            System.exit(0);
            // Error:
            // trayIcon.displayMessage("Hello, World", "Java Notification Demo", MessageType.ERROR);
            // Warning:
            // trayIcon.displayMessage("Hello, World", "Java Notification Demo", MessageType.WARNING);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}



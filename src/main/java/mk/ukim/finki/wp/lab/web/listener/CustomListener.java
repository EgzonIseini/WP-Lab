package mk.ukim.finki.wp.lab.web.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class CustomListener implements ServletRequestListener {
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("[WP-Log] {requestDestroyed()}");
    }

    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("[WP-Log] {requestInitialized()}");
    }

}

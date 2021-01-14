import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class ListenerDemo2 implements  HttpSessionAttributeListener {

    static int count = 0;

    @Override
    public void attributeAdded(HttpSessionBindingEvent e) {
            count++;
            System.out.println("当前在线人数..."+count);
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
            count--;
        System.out.println("当前在线人数..."+count);
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {

    }
}

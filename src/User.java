
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class User implements HttpSessionBindingListener {

    private String name;
    private String sex;
    private int age;
    private String ip;

    public User() {
        super();
    }

    public User(String name, String sex, int age) {
        super();
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public String toString() {
        return "User [name=" + name + ", sex=" + sex + ", age=" + age + ", ip=" + ip + "]";
    }

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        System.err.println("session中放入了一个User对象");
        System.out.println("user: " + event.getValue());
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        System.err.println("session中移除了一个User对象");
    }

}

package cn.aq.springboot.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener {
    /*监听器，在项目启动时打印，说明已经监听到web应用启动了*/
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("MyListener process...//contextInitialized...web应用");
    }

    /*项目销毁，点击 console 左面有个按钮是退出，Exit，就会打印下面的话，说明项目正常销毁了。小三角右边的退出就像拔电源一样*/
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("contextDestroyes...当前web项目销毁");
    }
}

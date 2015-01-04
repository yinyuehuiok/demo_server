package com.yjf.demoServer;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.nio.SelectChannelConnector;
import org.eclipse.jetty.webapp.WebAppContext;

public class JettyServer {
	static {
		System.setProperty("DWENV", "dev");
	}

	public static void main(String[] args) throws Exception {
		Server server = buildNormalServer(80, "/");
		server.start();
	}

	/**
     * 创建用于开发运行调试的Jetty Server, 以src/main/webapp为Web应用目录.
     */
    public static Server buildNormalServer(int port, String contextPath) {
        Server server = new Server();
        //设置在JVM退出时关闭Jetty的钩子。
        server.setStopAtShutdown(true);

        SelectChannelConnector connector = new SelectChannelConnector();
        connector.setPort(port);
        //解决Windows下重复启动Jetty居然不报告端口冲突的问题.
        connector.setReuseAddress(false);
        server.setConnectors(new Connector[] { connector });

        final String DEFAULT_WEBAPP_PATH = "src/main/webapp";
        WebAppContext webContext = new WebAppContext(DEFAULT_WEBAPP_PATH, contextPath);
        //修改webdefault.xml，解决Windows下Jetty Lock住静态文件的问题.
        final String WINDOWS_WEBDEFAULT_PATH = "src/test/resources/jetty-webdefault.xml";
        webContext.setDefaultsDescriptor(WINDOWS_WEBDEFAULT_PATH);
        server.setHandler(webContext);

        return server;
    }
}

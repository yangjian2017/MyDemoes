package cn.jt.module.config;

import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.plugins.mvc.websocket.AbstractWsEndpoint;
import org.nutz.plugins.mvc.websocket.NutWsConfigurator;

import javax.websocket.server.ServerEndpoint;

/**
 * @author yangjian
 */
@ServerEndpoint(value = "/websocket", configurator=NutWsConfigurator.class)
@IocBean
public class MyWebsocket extends AbstractWsEndpoint {
}
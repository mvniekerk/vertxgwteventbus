package za.co.dvt.jhb.sockjsgwtclient.client.vertx;

import jsinterop.annotations.*;

@JsType(isNative = true, name = "EventBus", namespace = JsPackage.GLOBAL)
public class VertxEventBus {

    public VertxEventBus(String url, Object options) {}

    public native <T> void registerHandler(String address, Handler<T> handler);

    @JsProperty(name = "onopen")
    public ConnectionOpened onConnectionOpened;

    @JsProperty(name = "onclose")
    public ConnectionClosed onConnectionClosed;

}

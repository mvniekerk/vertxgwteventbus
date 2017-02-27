package za.co.dvt.jhb.sockjsgwtclient.client.vertx;

import jsinterop.annotations.*;

@JsType(isNative = true, namespace = JsPackage.GLOBAL)
public class Message<T> {
    @JsProperty
    public T body;
}

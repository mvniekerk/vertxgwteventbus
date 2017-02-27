package za.co.dvt.jhb.sockjsgwtclient.client.vertx;

import jsinterop.annotations.JsFunction;

@JsFunction
public interface ConnectionClosed {
    void onClosed(Object e);
}

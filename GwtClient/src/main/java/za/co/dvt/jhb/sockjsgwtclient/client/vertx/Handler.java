package za.co.dvt.jhb.sockjsgwtclient.client.vertx;

import jsinterop.annotations.JsFunction;

@JsFunction
public interface Handler<T> {
    void onMesssageReceived(Object error, Message<T> message);
}

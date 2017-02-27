package za.co.dvt.jhb.sockjsgwtclient.client.events;

import com.google.gwt.event.shared.EventHandler;

public interface NewRandomNumberEventHandler extends EventHandler {
    void onNewRandomNumber(int number);
}

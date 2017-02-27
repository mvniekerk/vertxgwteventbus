package za.co.dvt.jhb.sockjsgwtclient.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import za.co.dvt.jhb.sockjsgwtclient.client.events.NewRandomNumberEvent;
import za.co.dvt.jhb.sockjsgwtclient.client.vertx.VertxEventBus;

class SockJsGwtClientEntryPoint implements EntryPoint {
    private EventBus eventBus;

    private void registerToLocalhostRandomNumber() {
        VertxEventBus vertxEventBus = new VertxEventBus("http://localhost:9999/randomnumber", new Object());
        vertxEventBus.onConnectionClosed = (e) -> RootPanel.get().insert(new Label("Closed"), 0);
        vertxEventBus.onConnectionOpened = () -> vertxEventBus.<Number>registerHandler(
                "randomnumber",
                (error, message) -> eventBus.fireEvent(new NewRandomNumberEvent(message.body.intValue()))
        );
    }

    @Override
    public void onModuleLoad() {
        eventBus = new SimpleEventBus();
        eventBus.addHandler(NewRandomNumberEvent.TYPE, (number) -> RootPanel.get().insert(new Label("" + number), 0));
        registerToLocalhostRandomNumber();
    }
}
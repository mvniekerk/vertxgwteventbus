package za.co.dvt.jhb.sockjsgwtclient.client.events;

import com.google.gwt.event.shared.GwtEvent;

public class NewRandomNumberEvent extends GwtEvent<NewRandomNumberEventHandler> {
    public static Type<NewRandomNumberEventHandler> TYPE = new Type<>();

    private final int newNumber;

    public NewRandomNumberEvent(int newNumber) {
        this.newNumber = newNumber;
    }

    @Override
    public Type<NewRandomNumberEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(NewRandomNumberEventHandler handler) {
        handler.onNewRandomNumber(newNumber);
    }

    public int getNewNumber() {
        return newNumber;
    }
}

package com.facebook.events.widget.rsvpaction;

import com.facebook.events.connectionqe.EventsConnectionStyleExperiment.PublicEventAction;
import com.facebook.inject.InjectorLike;

/* compiled from: api_error_code */
public class EventRsvpActionBarButtonHelper {

    /* compiled from: api_error_code */
    public /* synthetic */ class C27901 {
        public static final /* synthetic */ int[] f19632a = new int[PublicEventAction.values().length];

        static {
            try {
                f19632a[PublicEventAction.GOING.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f19632a[PublicEventAction.PRIVATE_GOING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f19632a[PublicEventAction.PRIVATE_MAYBE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f19632a[PublicEventAction.PRIVATE_NOT_GOING.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f19632a[PublicEventAction.WATCH_INTERESTED.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f19632a[PublicEventAction.NOT_INTERESTED_OR_NOT_GOING_OR_IGNORE.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    public static EventRsvpActionBarButtonHelper m19915a(InjectorLike injectorLike) {
        return new EventRsvpActionBarButtonHelper();
    }
}

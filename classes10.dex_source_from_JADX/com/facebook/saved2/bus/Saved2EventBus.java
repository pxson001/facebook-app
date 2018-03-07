package com.facebook.saved2.bus;

import android.os.Looper;
import com.facebook.crudolib.eventbus.Event;
import com.facebook.crudolib.eventbus.EventDispatcher;

/* compiled from: instant_shopping_document_open */
public class Saved2EventBus {
    public static EventDispatcher<FetchFailedData> f9368a = new EventDispatcher(Looper.getMainLooper());
    public static EventDispatcher<FetchSucceededData> f9369b = new EventDispatcher(Looper.getMainLooper());

    /* compiled from: instant_shopping_document_open */
    public class FetchFailedData implements Event {
        public final String f9365a;

        public FetchFailedData(String str) {
            this.f9365a = str;
        }
    }

    /* compiled from: instant_shopping_document_open */
    public class FetchSucceededData implements Event {
        public final String f9366a;
        public final int f9367b;

        public FetchSucceededData(String str, int i) {
            this.f9366a = str;
            this.f9367b = i;
        }
    }
}

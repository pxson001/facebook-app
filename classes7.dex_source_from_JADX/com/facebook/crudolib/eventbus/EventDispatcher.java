package com.facebook.crudolib.eventbus;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: for_sale_item_message_seller_button_clicked */
public class EventDispatcher<T extends Event> {
    private final DispatchHandler f17877a;
    private final Looper f17878b;
    private ArrayList<EventSubscriber<T>> f17879c = new ArrayList();
    private boolean f17880d;

    /* compiled from: for_sale_item_message_seller_button_clicked */
    class DispatchHandler extends Handler {
        final /* synthetic */ EventDispatcher f17876a;

        public DispatchHandler(EventDispatcher eventDispatcher, Looper looper) {
            this.f17876a = eventDispatcher;
            super(looper);
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    this.f17876a.m21727a((Event) message.obj);
                    return;
                default:
                    throw new IllegalArgumentException("Unknown what=" + message.what);
            }
        }
    }

    public EventDispatcher(Looper looper) {
        this.f17877a = new DispatchHandler(this, looper);
        this.f17878b = looper;
    }

    public final synchronized void m21728a(EventSubscriber<T> eventSubscriber) {
        if (eventSubscriber == null) {
            throw new IllegalArgumentException("eventSubscriber is null");
        }
        m21726c();
        if (this.f17879c.contains(eventSubscriber)) {
            throw new IllegalStateException("Subscriber " + eventSubscriber + " is already subscribed");
        }
        this.f17879c.add(eventSubscriber);
    }

    public final synchronized void m21730b(EventSubscriber<T> eventSubscriber) {
        if (eventSubscriber == null) {
            throw new IllegalArgumentException("eventSubscriber is null");
        }
        m21726c();
        int indexOf = this.f17879c.indexOf(eventSubscriber);
        if (indexOf == -1) {
            throw new IllegalStateException("Subscriber " + eventSubscriber + " was not registered");
        }
        this.f17879c.remove(indexOf);
    }

    public final void m21727a(T t) {
        Looper myLooper = Looper.myLooper();
        if (myLooper != this.f17878b) {
            throw new IllegalStateException("Cannot dispatch event from looper thread " + myLooper + "; expected " + this.f17878b);
        }
        ArrayList a = m21723a();
        try {
            int size = a.size();
            for (int i = 0; i < size; i++) {
                EventSubscriber eventSubscriber = (EventSubscriber) a.get(i);
                if (m21724a(a, eventSubscriber)) {
                    eventSubscriber.mo1383a(t);
                }
            }
        } finally {
            m21725b();
        }
    }

    public final void m21729b(T t) {
        DispatchHandler dispatchHandler = this.f17877a;
        dispatchHandler.sendMessage(dispatchHandler.obtainMessage(1, t));
    }

    private synchronized ArrayList<EventSubscriber<T>> m21723a() {
        if (this.f17880d) {
            throw new UnsupportedOperationException("Nested synchronous dispatching is not supported");
        }
        this.f17880d = true;
        return this.f17879c;
    }

    private synchronized void m21725b() {
        this.f17880d = false;
    }

    private synchronized boolean m21724a(ArrayList<EventSubscriber<T>> arrayList, EventSubscriber<T> eventSubscriber) {
        boolean z;
        z = this.f17879c == arrayList || this.f17879c.contains(eventSubscriber);
        return z;
    }

    private void m21726c() {
        if (this.f17880d) {
            this.f17879c = new ArrayList(this.f17879c);
        }
    }
}

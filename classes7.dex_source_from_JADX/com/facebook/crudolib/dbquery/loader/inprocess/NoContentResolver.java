package com.facebook.crudolib.dbquery.loader.inprocess;

import android.os.Looper;
import com.facebook.crudolib.dbquery.loader.inprocess.NoContentProviderCursorLoader.ForceLoadSubcriber;
import com.facebook.crudolib.eventbus.Event;
import com.facebook.crudolib.eventbus.EventDispatcher;
import com.facebook.crudolib.eventbus.EventSubscriber;
import com.facebook.infer.annotation.Assertions;
import java.util.ArrayList;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: ccta_type */
public final class NoContentResolver {
    public static final NoContentResolver f17873a = new NoContentResolver(Looper.getMainLooper());
    private final EventDispatcher<NotifyChangeData> f17874b;
    private ArrayList<NotifyChangeSubscriber> f17875c = new ArrayList();

    /* compiled from: ccta_type */
    final class NotifyChangeData implements Event {
        public final Object f17870a;

        public NotifyChangeData(Object obj) {
            this.f17870a = Assertions.b(obj);
        }
    }

    /* compiled from: ccta_type */
    public class NotifyChangeSubscriber implements EventSubscriber<NotifyChangeData> {
        public final Object f17871a;
        public final ForceLoadSubcriber f17872b;

        public final void mo1383a(Event event) {
            if (this.f17871a.equals(((NotifyChangeData) event).f17870a)) {
                this.f17872b.f17861a.w();
            }
        }

        public NotifyChangeSubscriber(Object obj, ForceLoadSubcriber forceLoadSubcriber) {
            this.f17871a = Assertions.b(obj);
            this.f17872b = (ForceLoadSubcriber) Assertions.b(forceLoadSubcriber);
        }
    }

    public static NoContentResolver m21716a() {
        return f17873a;
    }

    private NoContentResolver(Looper looper) {
        this.f17874b = new EventDispatcher(looper);
    }

    public final void m21718a(Object obj) {
        this.f17874b.m21729b(new NotifyChangeData(obj));
    }

    public final synchronized void m21719a(Object obj, ForceLoadSubcriber forceLoadSubcriber) {
        if (m21717c(obj, forceLoadSubcriber) >= 0) {
            throw new IllegalStateException("This observer is already registered: key=" + obj + "; observer=" + forceLoadSubcriber);
        }
        EventSubscriber notifyChangeSubscriber = new NotifyChangeSubscriber(obj, forceLoadSubcriber);
        this.f17875c.add(notifyChangeSubscriber);
        this.f17874b.m21728a(notifyChangeSubscriber);
    }

    public final synchronized void m21720b(Object obj, ForceLoadSubcriber forceLoadSubcriber) {
        int c = m21717c(obj, forceLoadSubcriber);
        if (c >= 0) {
            this.f17874b.m21730b((NotifyChangeSubscriber) this.f17875c.remove(c));
        }
    }

    private int m21717c(Object obj, ForceLoadSubcriber forceLoadSubcriber) {
        int size = this.f17875c.size();
        for (int i = 0; i < size; i++) {
            NotifyChangeSubscriber notifyChangeSubscriber = (NotifyChangeSubscriber) this.f17875c.get(i);
            Object obj2 = (notifyChangeSubscriber.f17871a.equals(obj) && notifyChangeSubscriber.f17872b.equals(forceLoadSubcriber)) ? 1 : null;
            if (obj2 != null) {
                return i;
            }
        }
        return -1;
    }
}

package com.facebook.events.dashboard;

import android.database.Cursor;
import com.facebook.events.data.EventsDAO;
import com.facebook.events.model.Event;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableCollection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: completion_dialog_shown */
public class EventsDashboardAdapterCollection {
    private static final Comparator<Event> f16536a;
    private static final Comparator<Event> f16537b;
    public final EventsDAO f16538c;
    public List<Event> f16539d = Collections.emptyList();
    public boolean f16540e;
    public ArrayList<Event> f16541f;
    public int f16542g;
    public int f16543h;

    /* compiled from: completion_dialog_shown */
    final class C23051 implements Comparator<Event> {
        C23051() {
        }

        public final int compare(Object obj, Object obj2) {
            Event event = (Event) obj2;
            long K = ((Event) obj).K();
            long K2 = event.K();
            if (K < K2) {
                return -1;
            }
            return K > K2 ? 1 : 0;
        }
    }

    /* compiled from: completion_dialog_shown */
    class C23062 extends AbstractIterator<Long> {
        final /* synthetic */ EventsDashboardAdapterCollection f16533a;
        private int f16534b;
        private int f16535c;

        C23062(EventsDashboardAdapterCollection eventsDashboardAdapterCollection) {
            this.f16533a = eventsDashboardAdapterCollection;
        }

        protected final Object m16944a() {
            if (this.f16534b < this.f16533a.f16538c.b() && this.f16535c < this.f16533a.f16539d.size()) {
                this.f16533a.f16538c.a(this.f16534b);
                long c = this.f16533a.f16538c.c();
                long K = ((Event) this.f16533a.f16539d.get(this.f16535c)).K();
                if (this.f16533a.f16540e ? c < K : c > K) {
                    this.f16534b++;
                    return Long.valueOf(c);
                }
                this.f16535c++;
                return Long.valueOf(K);
            } else if (this.f16534b < this.f16533a.f16538c.b()) {
                EventsDAO eventsDAO = this.f16533a.f16538c;
                r1 = this.f16534b;
                this.f16534b = r1 + 1;
                eventsDAO.a(r1);
                return Long.valueOf(this.f16533a.f16538c.c());
            } else if (this.f16535c >= this.f16533a.f16539d.size()) {
                return (Long) b();
            } else {
                List list = this.f16533a.f16539d;
                r1 = this.f16535c;
                this.f16535c = r1 + 1;
                return Long.valueOf(((Event) list.get(r1)).K());
            }
        }
    }

    private static EventsDashboardAdapterCollection m16946b(InjectorLike injectorLike) {
        return new EventsDashboardAdapterCollection(EventsDAO.a(injectorLike));
    }

    static {
        Comparator c23051 = new C23051();
        f16536a = c23051;
        f16537b = Collections.reverseOrder(c23051);
    }

    @Inject
    public EventsDashboardAdapterCollection(EventsDAO eventsDAO) {
        this.f16538c = eventsDAO;
    }

    public final void m16947a(@Nullable Cursor cursor, ImmutableCollection<Event> immutableCollection) {
        m16945a(cursor, immutableCollection, true);
    }

    public final void m16950b(@Nullable Cursor cursor, ImmutableCollection<Event> immutableCollection) {
        m16945a(cursor, immutableCollection, false);
    }

    private void m16945a(@Nullable Cursor cursor, ImmutableCollection<Event> immutableCollection, boolean z) {
        this.f16542g = 0;
        this.f16543h = 0;
        this.f16540e = z;
        this.f16538c.a(cursor);
        this.f16539d = new ArrayList(immutableCollection);
        if (z) {
            Collections.sort(this.f16539d, f16536a);
        } else {
            Collections.sort(this.f16539d, f16537b);
        }
        this.f16541f = new ArrayList(this.f16538c.b() + this.f16539d.size());
    }

    public final boolean m16948a() {
        return m16949b() == 0;
    }

    public final int m16949b() {
        return this.f16538c.b() + this.f16539d.size();
    }

    public final Iterator<Long> m16951c() {
        return new C23062(this);
    }
}

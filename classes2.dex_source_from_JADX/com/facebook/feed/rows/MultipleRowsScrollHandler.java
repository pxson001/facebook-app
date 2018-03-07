package com.facebook.feed.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.events.EventsStream;
import com.facebook.feed.rows.core.events.ScrollStoppedEvent;
import com.facebook.feed.rows.core.persistence.ContextStateMap;
import com.facebook.feed.rows.core.persistence.ScrollPersistentState;
import com.facebook.feed.rows.core.persistence.ScrollStateKey;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.listview.ScrollingViewProxy.OnScrollListener;
import javax.inject.Inject;

@ContextScoped
/* compiled from: omnistore_ */
public class MultipleRowsScrollHandler {
    private static MultipleRowsScrollHandler f11222f;
    private static final Object f11223g = new Object();
    public final ScrollStoppedEvent f11224a = new ScrollStoppedEvent();
    public final EventsStream f11225b;
    public final ScrollPersistentState f11226c;
    public final FeedFrameRateLogger f11227d;
    public int f11228e;

    /* compiled from: omnistore_ */
    public class C05141 implements OnScrollListener {
        final /* synthetic */ MultipleRowsScrollHandler f12254a;

        public C05141(MultipleRowsScrollHandler multipleRowsScrollHandler) {
            this.f12254a = multipleRowsScrollHandler;
        }

        public final void mo1262a(ScrollingViewProxy scrollingViewProxy, int i) {
            this.f12254a.f11226c.f11315a = i;
            switch (i) {
                case 0:
                    this.f12254a.f11225b.m15231a(this.f12254a.f11224a);
                    this.f12254a.f11227d.m16544a(this.f12254a.f11228e);
                    return;
                case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                    this.f12254a.f11228e = 0;
                    this.f12254a.f11227d.f11231a.m16572a();
                    return;
                default:
                    return;
            }
        }

        public final void mo1263a(ScrollingViewProxy scrollingViewProxy, int i, int i2, int i3) {
            MultipleRowsScrollHandler multipleRowsScrollHandler = this.f12254a;
            multipleRowsScrollHandler.f11228e += Math.abs(scrollingViewProxy.mo2411z());
        }
    }

    private static MultipleRowsScrollHandler m16540b(InjectorLike injectorLike) {
        return new MultipleRowsScrollHandler(ContextStateMap.m14935a(injectorLike), EventsStream.m15220a(injectorLike), FeedFrameRateLogger.m16541a(injectorLike));
    }

    @Inject
    public MultipleRowsScrollHandler(ContextStateMap contextStateMap, EventsStream eventsStream, FeedFrameRateLogger feedFrameRateLogger) {
        this.f11225b = eventsStream;
        this.f11226c = (ScrollPersistentState) contextStateMap.m14939a(ScrollStateKey.f11313a);
        this.f11226c.f11315a = 0;
        this.f11227d = feedFrameRateLogger;
    }

    public static MultipleRowsScrollHandler m16539a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            MultipleRowsScrollHandler b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f11223g) {
                MultipleRowsScrollHandler multipleRowsScrollHandler;
                if (a2 != null) {
                    multipleRowsScrollHandler = (MultipleRowsScrollHandler) a2.mo818a(f11223g);
                } else {
                    multipleRowsScrollHandler = f11222f;
                }
                if (multipleRowsScrollHandler == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m16540b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f11223g, b3);
                        } else {
                            f11222f = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = multipleRowsScrollHandler;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}

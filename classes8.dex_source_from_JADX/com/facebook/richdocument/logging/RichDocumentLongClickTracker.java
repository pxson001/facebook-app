package com.facebook.richdocument.logging;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.content.event.FbEvent;
import com.facebook.feed.analytics.LongClickTracker;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.richdocument.event.RichDocumentEventBus;
import com.facebook.richdocument.event.RichDocumentEventSubscribers.RichDocumentBlocksAppendedSubscriber;
import com.facebook.richdocument.event.RichDocumentEvents.RichDocumentBlocksAppendedEvent;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;

@ContextScoped
/* compiled from: place_picker_milliseconds_since_start */
public class RichDocumentLongClickTracker {
    private static RichDocumentLongClickTracker f5504n;
    private static final Object f5505o = new Object();
    public final LongClickTracker f5506a;
    public final MonotonicClock f5507b;
    public final RichDocumentEventBus f5508c;
    public final RichDocumentSessionTracker f5509d;
    public final Context f5510e;
    public RichDocumentBlocksAppendedSubscriber f5511f = new C07101(this);
    public long f5512g = this.f5507b.now();
    public long f5513h;
    public long f5514i;
    public long f5515j;
    public double f5516k;
    public String f5517l;
    public String f5518m;

    /* compiled from: place_picker_milliseconds_since_start */
    class C07101 extends RichDocumentBlocksAppendedSubscriber {
        final /* synthetic */ RichDocumentLongClickTracker f5503a;

        C07101(RichDocumentLongClickTracker richDocumentLongClickTracker) {
            this.f5503a = richDocumentLongClickTracker;
        }

        public final void m5380b(FbEvent fbEvent) {
            RichDocumentBlocksAppendedEvent richDocumentBlocksAppendedEvent = (RichDocumentBlocksAppendedEvent) fbEvent;
            RichDocumentLongClickTracker richDocumentLongClickTracker = this.f5503a;
            String string = richDocumentBlocksAppendedEvent.f5167a.f5669b.getString("url");
            String str = richDocumentBlocksAppendedEvent.f5167a.f5668a;
            richDocumentLongClickTracker.f5513h = richDocumentLongClickTracker.f5507b.now() - richDocumentLongClickTracker.f5512g;
            richDocumentLongClickTracker.f5514i = richDocumentLongClickTracker.f5507b.now();
            richDocumentLongClickTracker.f5517l = string;
            richDocumentLongClickTracker.f5518m = str;
            this.f5503a.f5508c.b(this);
            this.f5503a.f5511f = null;
        }
    }

    private static RichDocumentLongClickTracker m5382b(InjectorLike injectorLike) {
        return new RichDocumentLongClickTracker((Context) injectorLike.getInstance(Context.class), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), LongClickTracker.a(injectorLike), RichDocumentEventBus.m5130a(injectorLike), RichDocumentSessionTracker.m5403a(injectorLike));
    }

    @Inject
    public RichDocumentLongClickTracker(Context context, MonotonicClock monotonicClock, LongClickTracker longClickTracker, RichDocumentEventBus richDocumentEventBus, RichDocumentSessionTracker richDocumentSessionTracker) {
        this.f5507b = monotonicClock;
        this.f5506a = longClickTracker;
        this.f5508c = richDocumentEventBus;
        this.f5509d = richDocumentSessionTracker;
        this.f5510e = context;
        this.f5508c.a(this.f5511f);
    }

    public static RichDocumentLongClickTracker m5381a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            RichDocumentLongClickTracker b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f5505o) {
                RichDocumentLongClickTracker richDocumentLongClickTracker;
                if (a2 != null) {
                    richDocumentLongClickTracker = (RichDocumentLongClickTracker) a2.a(f5505o);
                } else {
                    richDocumentLongClickTracker = f5504n;
                }
                if (richDocumentLongClickTracker == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m5382b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f5505o, b3);
                        } else {
                            f5504n = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = richDocumentLongClickTracker;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final void m5384b() {
        m5383e();
    }

    private void m5383e() {
        if (this.f5517l != null) {
            long now = this.f5507b.now();
            if (this.f5513h > 0) {
                now -= this.f5514i;
                this.f5515j += now;
                this.f5516k += (double) this.f5513h;
                this.f5509d.m5405a((double) now);
            }
        }
    }

    public final void m5385c() {
        m5383e();
        if (this.f5517l != null) {
            Map hashMap = new HashMap();
            hashMap.putAll(this.f5509d.m5407b());
            hashMap.put("article_ID", this.f5518m);
            hashMap.put("article_depth_level", Integer.toString(this.f5509d.m5409c(this.f5510e)));
            hashMap.put("article_aggregate_view_time", Long.toString(this.f5515j / 1000));
            hashMap.put("article_aggregate_load_time", Double.toString(this.f5516k / 1000.0d));
            this.f5506a.a(this.f5517l, this.f5513h > 0 ? (double) this.f5513h : (double) (this.f5507b.now() - this.f5512g), (double) this.f5515j, hashMap);
        }
        this.f5506a.a();
    }
}

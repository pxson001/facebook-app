package com.facebook.feed.tooltip;

import android.content.Context;
import android.support.v4.app.Fragment;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.util.TriState;
import com.facebook.content.event.FbEvent;
import com.facebook.content.event.FbEventSubscriber;
import com.facebook.feed.util.event.FeedEvent;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.event.FeedEventSubscriber;
import com.facebook.feed.util.event.StoryEvents$OutboundClickedEvent;
import com.facebook.feed.util.event.StoryEvents$OutboundClickedEventSubscriber;
import com.facebook.feed.util.event.StoryEvents$PermalinkClickedEvent;
import com.facebook.feed.util.event.StoryEvents$PermalinkClickedEventSubscriber;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.collect.Sets;
import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;

@ContextScoped
/* compiled from: poll_facepile_size */
public class FeedReturnDetector {
    private static FeedReturnDetector f9503i;
    private static final Object f9504j = new Object();
    public final FeedEventBus f9505a;
    protected final MonotonicClock f9506b;
    public final Set<FeedReturnListener<? extends FeedEvent>> f9507c = new HashSet();
    public final Set<Class<? extends Fragment>> f9508d = new HashSet();
    public final Set<FeedEventSubscriber<? extends FeedEvent>> f9509e = Sets.m1315a(new OutboundClickedEventSubscriber(this), new PermalinkClickedEventSubscriber(this));
    protected long f9510f;
    protected Optional<? extends FeedEvent> f9511g = Absent.INSTANCE;
    protected final TriState f9512h;

    /* compiled from: poll_facepile_size */
    class OutboundClickedEventSubscriber extends StoryEvents$OutboundClickedEventSubscriber {
        final /* synthetic */ FeedReturnDetector f9513a;

        public OutboundClickedEventSubscriber(FeedReturnDetector feedReturnDetector) {
            this.f9513a = feedReturnDetector;
        }

        public final void mo650b(FbEvent fbEvent) {
            FeedReturnDetector.m14489a(this.f9513a, (StoryEvents$OutboundClickedEvent) fbEvent);
        }
    }

    /* compiled from: poll_facepile_size */
    class PermalinkClickedEventSubscriber extends StoryEvents$PermalinkClickedEventSubscriber {
        final /* synthetic */ FeedReturnDetector f9514a;

        public PermalinkClickedEventSubscriber(FeedReturnDetector feedReturnDetector) {
            this.f9514a = feedReturnDetector;
        }

        public final void mo650b(FbEvent fbEvent) {
            FeedReturnDetector.m14489a(this.f9514a, (StoryEvents$PermalinkClickedEvent) fbEvent);
        }
    }

    /* compiled from: poll_facepile_size */
    public interface FeedReturnListener<E extends FeedEvent> {
        Class<E> mo2661a();

        void mo2662a(FeedEvent feedEvent, long j);
    }

    private static FeedReturnDetector m14491b(InjectorLike injectorLike) {
        return new FeedReturnDetector(FeedEventBus.m4573a(injectorLike), AwakeTimeSinceBootClockMethodAutoProvider.m1697a(injectorLike), GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike).m2185a(80));
    }

    @Inject
    public FeedReturnDetector(FeedEventBus feedEventBus, MonotonicClock monotonicClock, TriState triState) {
        this.f9505a = feedEventBus;
        this.f9506b = monotonicClock;
        this.f9510f = -1;
        this.f9512h = triState;
    }

    public static FeedReturnDetector m14488a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FeedReturnDetector b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f9504j) {
                FeedReturnDetector feedReturnDetector;
                if (a2 != null) {
                    feedReturnDetector = (FeedReturnDetector) a2.mo818a(f9504j);
                } else {
                    feedReturnDetector = f9503i;
                }
                if (feedReturnDetector == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m14491b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f9504j, b3);
                        } else {
                            f9503i = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = feedReturnDetector;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    private boolean m14490a() {
        return this.f9512h.asBoolean(false);
    }

    public final void m14492a(FeedReturnListener<? extends FeedEvent> feedReturnListener) {
        this.f9507c.add(feedReturnListener);
    }

    public final void m14494b(FeedReturnListener<? extends FeedEvent> feedReturnListener) {
        this.f9507c.remove(feedReturnListener);
    }

    public final void m14493a(Class<? extends Fragment> cls) {
        if (m14490a()) {
            if (this.f9508d.isEmpty()) {
                for (FbEventSubscriber a : this.f9509e) {
                    this.f9505a.m4568a(a);
                }
            }
            this.f9508d.add(cls);
            if (this.f9511g.isPresent()) {
                FeedEvent feedEvent = (FeedEvent) this.f9511g.get();
                long now = this.f9506b.now() - this.f9510f;
                for (FeedReturnListener feedReturnListener : this.f9507c) {
                    if (feedReturnListener.mo2661a().equals(feedEvent.getClass())) {
                        feedReturnListener.mo2662a(feedEvent, now);
                        break;
                    }
                }
            }
            this.f9511g = Absent.INSTANCE;
        }
    }

    public final void m14495b(Class<? extends Fragment> cls) {
        if (m14490a()) {
            this.f9508d.remove(cls);
            if (this.f9508d.isEmpty()) {
                for (FbEventSubscriber b : this.f9509e) {
                    this.f9505a.m4569b(b);
                }
            }
        }
    }

    public static void m14489a(FeedReturnDetector feedReturnDetector, FeedEvent feedEvent) {
        feedReturnDetector.f9511g = Optional.of(feedEvent);
        feedReturnDetector.f9510f = feedReturnDetector.f9506b.now();
    }
}

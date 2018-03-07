package com.facebook.feed.tooltip;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.content.event.FbEvent;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feedplugins.saved.nux.SavedOnlyMeShareTooltipTrigger;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ufiservices.event.UfiEvents$ShareStoryPublishEvent;
import com.facebook.ufiservices.event.UfiEvents$ShareStoryPublishEventSubscriber;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: pic_cover */
public class OnlyMeShareDetector {
    private static OnlyMeShareDetector f9855f;
    private static final Object f9856g = new Object();
    private final FeedEventBus f9857a;
    public final List<Listener> f9858b = new ArrayList();
    private final ShareClickedEventSubscriber f9859c = new ShareClickedEventSubscriber(this);
    @Nullable
    public UfiEvents$ShareStoryPublishEvent f9860d;
    private GatekeeperStoreImpl f9861e;

    /* compiled from: pic_cover */
    class ShareClickedEventSubscriber extends UfiEvents$ShareStoryPublishEventSubscriber {
        final /* synthetic */ OnlyMeShareDetector f9862a;

        public ShareClickedEventSubscriber(OnlyMeShareDetector onlyMeShareDetector) {
            this.f9862a = onlyMeShareDetector;
        }

        public final void mo650b(FbEvent fbEvent) {
            this.f9862a.f9860d = (UfiEvents$ShareStoryPublishEvent) fbEvent;
        }
    }

    private static OnlyMeShareDetector m14885b(InjectorLike injectorLike) {
        return new OnlyMeShareDetector(FeedEventBus.m4573a(injectorLike), GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike));
    }

    @Inject
    public OnlyMeShareDetector(FeedEventBus feedEventBus, GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f9857a = feedEventBus;
        this.f9861e = gatekeeperStoreImpl;
    }

    private boolean m14886d() {
        return this.f9861e.m2189a(812, false);
    }

    public static OnlyMeShareDetector m14884a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            OnlyMeShareDetector b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f9856g) {
                OnlyMeShareDetector onlyMeShareDetector;
                if (a2 != null) {
                    onlyMeShareDetector = (OnlyMeShareDetector) a2.mo818a(f9856g);
                } else {
                    onlyMeShareDetector = f9855f;
                }
                if (onlyMeShareDetector == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m14885b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f9856g, b3);
                        } else {
                            f9855f = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = onlyMeShareDetector;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public final void m14887a() {
        if (m14886d()) {
            this.f9857a.m4568a(this.f9859c);
        }
    }

    public final void m14888b() {
        if (m14886d()) {
            this.f9857a.m4569b(this.f9859c);
        }
    }

    public final void m14889c() {
        if (m14886d() && this.f9860d != null) {
            for (SavedOnlyMeShareTooltipTrigger a : this.f9858b) {
                a.m20119a(this.f9860d);
            }
            this.f9860d = null;
        }
    }
}

package com.facebook.instantshopping.logging;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.content.event.FbEvent;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.instantshopping.fetcher.InstantShoppingDocumentFetcher;
import com.facebook.instantshopping.utils.InstantShoppingDocumentContext;
import com.facebook.richdocument.event.RichDocumentEventBus;
import com.facebook.richdocument.event.RichDocumentEventSubscribers.RichDocumentBlocksAppendedSubscriber;
import com.facebook.richdocument.event.RichDocumentEventSubscribers.RichDocumentFirstRenderSubscriber;
import com.facebook.richdocument.event.RichDocumentEvents.RichDocumentBlocksAppendedEvent;
import com.facebook.richdocument.event.RichDocumentEvents.RichDocumentFirstRenderEvent;
import javax.inject.Inject;

@ContextScoped
/* compiled from: ShareType.facebookShare */
public class InstantShoppingPerfInfoLogger {
    private static InstantShoppingPerfInfoLogger f23560n;
    private static final Object f23561o = new Object();
    public final InstantShoppingDocumentFetcher f23562a;
    public final InstantShoppingAnalyticsLogger f23563b;
    protected final RichDocumentEventBus f23564c;
    protected final RichDocumentFirstRenderSubscriber f23565d = new C33911(this);
    public long f23566e;
    public boolean f23567f = false;
    public long f23568g;
    public long f23569h;
    public boolean f23570i;
    public float f23571j;
    public long f23572k;
    public final InstantShoppingDocumentContext f23573l;
    private final RichDocumentBlocksAppendedSubscriber f23574m = new C33922(this);

    /* compiled from: ShareType.facebookShare */
    class C33911 extends RichDocumentFirstRenderSubscriber {
        final /* synthetic */ InstantShoppingPerfInfoLogger f23558a;

        C33911(InstantShoppingPerfInfoLogger instantShoppingPerfInfoLogger) {
            this.f23558a = instantShoppingPerfInfoLogger;
        }

        public final void m24885b(FbEvent fbEvent) {
            RichDocumentFirstRenderEvent richDocumentFirstRenderEvent = (RichDocumentFirstRenderEvent) fbEvent;
            this.f23558a.f23569h = richDocumentFirstRenderEvent.b;
            this.f23558a.f23568g = richDocumentFirstRenderEvent.a - this.f23558a.f23566e;
        }
    }

    /* compiled from: ShareType.facebookShare */
    class C33922 extends RichDocumentBlocksAppendedSubscriber {
        final /* synthetic */ InstantShoppingPerfInfoLogger f23559a;

        C33922(InstantShoppingPerfInfoLogger instantShoppingPerfInfoLogger) {
            this.f23559a = instantShoppingPerfInfoLogger;
        }

        public final void m24886b(FbEvent fbEvent) {
            boolean z;
            RichDocumentBlocksAppendedEvent richDocumentBlocksAppendedEvent = (RichDocumentBlocksAppendedEvent) fbEvent;
            InstantShoppingPerfInfoLogger instantShoppingPerfInfoLogger = this.f23559a;
            if (richDocumentBlocksAppendedEvent.b != DataFreshnessResult.FROM_SERVER) {
                z = true;
            } else {
                z = false;
            }
            instantShoppingPerfInfoLogger.f23570i = z;
            this.f23559a.f23564c.b(this);
        }
    }

    private static InstantShoppingPerfInfoLogger m24888b(InjectorLike injectorLike) {
        return new InstantShoppingPerfInfoLogger(RichDocumentEventBus.a(injectorLike), (Context) injectorLike.getInstance(Context.class), InstantShoppingDocumentContext.a(injectorLike), InstantShoppingAnalyticsLogger.m24853a(injectorLike), InstantShoppingDocumentFetcher.a(injectorLike));
    }

    public static InstantShoppingPerfInfoLogger m24887a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            InstantShoppingPerfInfoLogger b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23561o) {
                InstantShoppingPerfInfoLogger instantShoppingPerfInfoLogger;
                if (a2 != null) {
                    instantShoppingPerfInfoLogger = (InstantShoppingPerfInfoLogger) a2.a(f23561o);
                } else {
                    instantShoppingPerfInfoLogger = f23560n;
                }
                if (instantShoppingPerfInfoLogger == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m24888b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23561o, b3);
                        } else {
                            f23560n = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = instantShoppingPerfInfoLogger;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public InstantShoppingPerfInfoLogger(RichDocumentEventBus richDocumentEventBus, Context context, InstantShoppingDocumentContext instantShoppingDocumentContext, InstantShoppingAnalyticsLogger instantShoppingAnalyticsLogger, InstantShoppingDocumentFetcher instantShoppingDocumentFetcher) {
        this.f23564c = richDocumentEventBus;
        this.f23573l = instantShoppingDocumentContext;
        this.f23563b = instantShoppingAnalyticsLogger;
        this.f23562a = instantShoppingDocumentFetcher;
        this.f23564c.a(this.f23565d);
        this.f23564c.a(this.f23574m);
    }
}

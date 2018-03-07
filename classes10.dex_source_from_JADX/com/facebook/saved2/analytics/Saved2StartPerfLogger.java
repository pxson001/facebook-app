package com.facebook.saved2.analytics;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.saved2.analytics.Saved2DashboardSequences.Saved2DashboardStartSequence;
import com.facebook.sequencelogger.Sequence;
import com.facebook.sequencelogger.SequenceLogger;
import com.facebook.sequencelogger.SequenceLoggerImpl;
import com.facebook.tools.dextr.runtime.detour.SequenceLoggerDetour;
import com.google.common.collect.ImmutableMap;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: instant_shopping_document_pause */
public class Saved2StartPerfLogger {
    private static Saved2StartPerfLogger f9362b;
    private static final Object f9363c = new Object();
    private final SequenceLogger f9364a;

    private static Saved2StartPerfLogger m9522b(InjectorLike injectorLike) {
        return new Saved2StartPerfLogger((SequenceLogger) SequenceLoggerImpl.a(injectorLike));
    }

    @Inject
    public Saved2StartPerfLogger(SequenceLogger sequenceLogger) {
        this.f9364a = sequenceLogger;
    }

    public final void m9526a() {
        this.f9364a.a(Saved2DashboardSequences.f9361a);
        m9520a("DASH_START");
    }

    public final void m9527b() {
        m9520a("DASH_ITEMS_LOAD_FROM_CACHE");
    }

    public final void m9528c() {
        m9523b("DASH_ITEMS_LOAD_FROM_CACHE");
    }

    public final void m9529d() {
        m9520a("DASH_ITEMS_LOAD_FROM_NETWORK");
    }

    public final void m9530e() {
        m9523b("DASH_ITEMS_LOAD_FROM_NETWORK");
        m9523b("DASH_START");
        this.f9364a.b(Saved2DashboardSequences.f9361a);
    }

    public static Saved2StartPerfLogger m9519a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            Saved2StartPerfLogger b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9363c) {
                Saved2StartPerfLogger saved2StartPerfLogger;
                if (a2 != null) {
                    saved2StartPerfLogger = (Saved2StartPerfLogger) a2.a(f9363c);
                } else {
                    saved2StartPerfLogger = f9362b;
                }
                if (saved2StartPerfLogger == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9522b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9363c, b3);
                        } else {
                            f9362b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = saved2StartPerfLogger;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final void m9531f() {
        m9523b("DASH_START");
    }

    public final void m9532g() {
        m9520a("DASH_TABS_LOAD_FROM_CACHE");
    }

    public final void m9533h() {
        m9523b("DASH_TABS_LOAD_FROM_CACHE");
    }

    public final void m9534i() {
        m9520a("DASH_TABS_LOAD_FROM_NETWORK");
    }

    public final void m9535j() {
        m9523b("DASH_TABS_LOAD_FROM_NETWORK");
    }

    @Nullable
    private Sequence<Saved2DashboardStartSequence> m9525k() {
        return this.f9364a.e(Saved2DashboardSequences.f9361a);
    }

    private void m9520a(String str) {
        m9521a(str, null);
    }

    private void m9521a(String str, @Nullable ImmutableMap<String, String> immutableMap) {
        Sequence k = m9525k();
        if (k != null && !k.f(str)) {
            SequenceLoggerDetour.a(k, str, null, immutableMap, 1345596725);
        }
    }

    private void m9523b(String str) {
        m9524b(str, null);
    }

    private void m9524b(String str, @Nullable ImmutableMap<String, String> immutableMap) {
        Sequence k = m9525k();
        if (k != null && k.f(str)) {
            SequenceLoggerDetour.b(k, str, null, immutableMap, 733354090);
        }
    }
}

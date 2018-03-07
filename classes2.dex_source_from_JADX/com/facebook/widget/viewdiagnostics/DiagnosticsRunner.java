package com.facebook.widget.viewdiagnostics;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.proxygen.HTTPTransportCallback;
import com.google.common.base.Throwables;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: search_awareness_unit_dismissed */
public class DiagnosticsRunner {
    private static DiagnosticsRunner f5884e;
    private static final Object f5885f = new Object();
    private final MonotonicClock f5886a;
    public WeakHashMap<Object, Long> f5887b = new WeakHashMap();
    public WeakHashMap<Object, Long> f5888c = new WeakHashMap();
    public WeakHashMap<Object, Long> f5889d = new WeakHashMap();

    /* compiled from: search_awareness_unit_dismissed */
    public enum Action {
        PREPARE,
        PREPARE_ASYNC,
        BIND
    }

    /* compiled from: search_awareness_unit_dismissed */
    /* synthetic */ class C05961 {
        static final /* synthetic */ int[] f14337a = new int[Action.values().length];

        static {
            try {
                f14337a[Action.PREPARE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f14337a[Action.PREPARE_ASYNC.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f14337a[Action.BIND.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    private static DiagnosticsRunner m10047b(InjectorLike injectorLike) {
        return new DiagnosticsRunner(AwakeTimeSinceBootClockMethodAutoProvider.m1697a(injectorLike));
    }

    @Inject
    public DiagnosticsRunner(MonotonicClock monotonicClock) {
        this.f5886a = monotonicClock;
    }

    public final void m10048a(Action action, Callable<?> callable) {
        long now = this.f5886a.now();
        try {
            Object call = callable.call();
            now = this.f5886a.now() - now;
            switch (C05961.f14337a[action.ordinal()]) {
                case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                    this.f5887b.put(call, Long.valueOf(now));
                    return;
                case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                    this.f5888c.put(call, Long.valueOf(now));
                    return;
                case 3:
                    this.f5889d.put(call, Long.valueOf(now));
                    return;
                default:
                    throw new UnsupportedOperationException();
            }
        } catch (Throwable e) {
            throw Throwables.propagate(e);
        }
    }

    public static DiagnosticsRunner m10045a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            DiagnosticsRunner b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f5885f) {
                DiagnosticsRunner diagnosticsRunner;
                if (a2 != null) {
                    diagnosticsRunner = (DiagnosticsRunner) a2.mo818a(f5885f);
                } else {
                    diagnosticsRunner = f5884e;
                }
                if (diagnosticsRunner == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m10047b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f5885f, b3);
                        } else {
                            f5884e = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = diagnosticsRunner;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public static long m10044a(Map<Object, Long> map, Object obj) {
        return map.get(obj) == null ? 0 : ((Long) map.get(obj)).longValue();
    }

    @Nullable
    public static ViewDiagnostics m10046a(View view) {
        if (view instanceof SupportsViewDiagnostics) {
            return ((SupportsViewDiagnostics) view).getViewDiagnostics();
        }
        return null;
    }
}

package com.facebook.saved.perf;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.saved.fragment.SavedItemsListAdapter.ItemsFreshness;
import com.facebook.saved.perf.SavedDashboardSequences.SavedDashboardStartSequence;
import com.facebook.saved.prefs.SavedPrefKeys;
import com.facebook.sequencelogger.Sequence;
import com.facebook.sequencelogger.SequenceLogger;
import com.facebook.sequencelogger.SequenceLoggerImpl;
import com.facebook.tools.dextr.runtime.detour.SequenceLoggerDetour;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableMap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
import javax.inject.Inject;

@ContextScoped
@NotThreadSafe
/* compiled from: intent is null */
public class SavedDashboardStartPerfLogger {
    private static SavedDashboardStartPerfLogger f9228g;
    private static final Object f9229h = new Object();
    private final SequenceLogger f9230a;
    public final MonotonicClock f9231b;
    private final FbSharedPreferences f9232c;
    public long f9233d;
    private Long f9234e = null;
    private Long f9235f = null;

    private static SavedDashboardStartPerfLogger m9248b(InjectorLike injectorLike) {
        return new SavedDashboardStartPerfLogger((SequenceLogger) SequenceLoggerImpl.a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike));
    }

    @Inject
    public SavedDashboardStartPerfLogger(SequenceLogger sequenceLogger, MonotonicClock monotonicClock, FbSharedPreferences fbSharedPreferences) {
        this.f9230a = sequenceLogger;
        this.f9231b = monotonicClock;
        this.f9232c = fbSharedPreferences;
    }

    public static SavedDashboardStartPerfLogger m9242a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SavedDashboardStartPerfLogger b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9229h) {
                SavedDashboardStartPerfLogger savedDashboardStartPerfLogger;
                if (a2 != null) {
                    savedDashboardStartPerfLogger = (SavedDashboardStartPerfLogger) a2.a(f9229h);
                } else {
                    savedDashboardStartPerfLogger = f9228g;
                }
                if (savedDashboardStartPerfLogger == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9248b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9229h, b3);
                        } else {
                            f9228g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = savedDashboardStartPerfLogger;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final void m9263b() {
        m9247a(false, this.f9233d);
        m9250b(this.f9233d);
    }

    public final void m9260a(long j) {
        this.f9234e = Long.valueOf(j);
        this.f9235f = Long.valueOf(this.f9231b.now() - j);
        m9247a(true, this.f9235f.longValue());
        m9244a("SAVED_EARLY_FETCH_LOAD", this.f9235f.longValue());
        m9245a("SAVED_EARLY_FETCH_LOAD", ImmutableBiMap.b("SAVED_DASH_START_EARLY_FETCH_ADVANTAGE", Long.toString(j)));
        m9250b(this.f9233d);
    }

    public final void m9265c() {
        if (m9257n() != null) {
            this.f9230a.d(SavedDashboardSequences.f9227a);
        }
    }

    private void m9255l() {
        m9251b("SAVED_EARLY_FETCH_LOAD");
        m9251b("SAVED_CACHED_ITEM_LOAD");
        m9251b("SAVED_FRESH_ITEM_LOAD");
    }

    public final void m9266d() {
        m9244a("SAVED_CACHED_ITEM_LOAD", this.f9235f == null ? this.f9231b.now() : this.f9235f.longValue());
    }

    public final void m9261a(@Nullable Long l) {
        if (l == null) {
            m9243a("SAVED_CACHED_ITEM_LOAD");
        } else {
            m9245a("SAVED_CACHED_ITEM_LOAD", ImmutableMap.of("cache_age", l == null ? "" : Long.toString(l.longValue()), "SAVED_DASH_START_EARLY_FETCH_ADVANTAGE", this.f9234e == null ? "" : Long.toString(this.f9234e.longValue())));
        }
    }

    public final void m9267e() {
        m9253c("SAVED_CACHED_ITEM_LOAD");
        m9253c("SAVED_DASH_START_TO_CACHE_ITEM_DRAWN");
    }

    public final void m9268f() {
        Sequence n = m9257n();
        if (n != null && n.f("SAVED_CACHED_ITEM_LOAD")) {
            m9251b("SAVED_CACHED_ITEM_LOAD");
            m9251b("SAVED_DASH_START_TO_CACHE_ITEM_DRAWN");
        }
    }

    public final void m9258a(int i) {
        Sequence n = m9257n();
        if (n != null && n.f("SAVED_DASH_START_TO_CACHE_ITEM_DRAWN")) {
            m9245a("SAVED_DASH_START_TO_CACHE_ITEM_DRAWN", ImmutableBiMap.b("items_count", Integer.toString(i)));
            m9249b(i, ItemsFreshness.FROM_CACHE);
        }
    }

    public final void m9269g() {
        m9251b("SAVED_DASH_START_TO_CACHE_ITEM_DRAWN");
    }

    public final void m9270h() {
        m9244a("SAVED_FRESH_ITEM_LOAD", this.f9235f == null ? this.f9231b.now() : this.f9235f.longValue());
    }

    public final void m9271i() {
        m9245a("SAVED_FRESH_ITEM_LOAD", ImmutableBiMap.b("SAVED_DASH_START_EARLY_FETCH_ADVANTAGE", this.f9234e == null ? "" : Long.toString(this.f9234e.longValue())));
    }

    public final void m9272j() {
        m9253c("SAVED_FRESH_ITEM_LOAD");
        m9253c("SAVED_DASH_START_TO_FRESH_ITEM_DRAWN");
    }

    public final void m9264b(int i) {
        Sequence n = m9257n();
        if (n != null && n.f("SAVED_DASH_START_TO_FRESH_ITEM_DRAWN")) {
            m9245a("SAVED_DASH_START_TO_FRESH_ITEM_DRAWN", ImmutableBiMap.b("items_count", Integer.toString(i)));
            m9249b(i, ItemsFreshness.FROM_SERVER);
        }
    }

    public final void m9273k() {
        m9251b("SAVED_DASH_START_TO_FRESH_ITEM_DRAWN");
    }

    public final void m9262a(boolean z) {
        m9256m();
        if (z) {
            m9254d("SUCCESS");
            this.f9232c.edit().putBoolean(SavedPrefKeys.e, true).commit();
            return;
        }
        m9254d("FAILURE");
    }

    public final void m9259a(int i, ItemsFreshness itemsFreshness) {
        m9252b("SAVED_ON_VIEW_DRAWN", ImmutableMap.of("items_count", Integer.toString(i), "freshness", itemsFreshness.toString()));
    }

    private void m9249b(int i, ItemsFreshness itemsFreshness) {
        m9245a("SAVED_DASH_START_TO_INTERACT", ImmutableMap.of("items_drawn", Boolean.toString(true), "items_count", Integer.toString(i), "freshness", itemsFreshness.toString(), "has_loaded_before", this.f9232c.b(SavedPrefKeys.e).toString()));
    }

    private void m9250b(long j) {
        m9244a("SAVED_DASH_START_TO_FRESH_ITEM_DRAWN", j);
        m9244a("SAVED_DASH_START_TO_CACHE_ITEM_DRAWN", j);
        m9246a("SAVED_DASH_START_TO_INTERACT", ImmutableBiMap.b("EARLY_START", Boolean.toString(this.f9235f != null)), j);
    }

    private void m9256m() {
        m9255l();
        m9251b("SAVED_DASH_START_TO_CACHE_ITEM_DRAWN");
        m9251b("SAVED_DASH_START_TO_FRESH_ITEM_DRAWN");
        m9251b("SAVED_DASH_START_TO_INTERACT");
    }

    @Nullable
    private Sequence<SavedDashboardStartSequence> m9257n() {
        return this.f9230a.e(SavedDashboardSequences.f9227a);
    }

    private void m9247a(boolean z, long j) {
        this.f9230a.a(SavedDashboardSequences.f9227a, ImmutableBiMap.b("EARLY_START", Boolean.toString(z)), j);
    }

    private void m9244a(String str, long j) {
        m9246a(str, null, j);
    }

    private void m9246a(String str, @Nullable ImmutableMap<String, String> immutableMap, long j) {
        Sequence n = m9257n();
        if (n != null && !n.f(str)) {
            SequenceLoggerDetour.a(n, str, null, immutableMap, j, 2020564648);
        }
    }

    private void m9243a(String str) {
        m9245a(str, null);
    }

    private void m9245a(String str, @Nullable ImmutableMap<String, String> immutableMap) {
        Sequence n = m9257n();
        if (n != null && n.f(str)) {
            SequenceLoggerDetour.b(n, str, null, immutableMap, 1126351677);
        }
    }

    private void m9251b(String str) {
        Sequence n = m9257n();
        if (n != null && n.f(str)) {
            SequenceLoggerDetour.d(n, str, -99952362);
        }
    }

    private void m9253c(String str) {
        Sequence n = m9257n();
        if (n != null && n.f(str)) {
            SequenceLoggerDetour.c(n, str, -946165767);
        }
    }

    private void m9252b(String str, @Nullable ImmutableMap<String, String> immutableMap) {
        Sequence n = m9257n();
        if (n != null) {
            SequenceLoggerDetour.a(n, str, immutableMap, this.f9231b.now(), 1927938051);
        }
    }

    private void m9254d(String str) {
        this.f9230a.b(SavedDashboardSequences.f9227a, ImmutableBiMap.b("RESULT_STATUS", str));
    }
}

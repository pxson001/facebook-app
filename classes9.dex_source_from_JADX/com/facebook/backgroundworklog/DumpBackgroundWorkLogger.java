package com.facebook.backgroundworklog;

import com.facebook.backgroundworklog.observer.MultiplexBackgroundWorkObserver;
import com.facebook.common.appchoreographer.DefaultAppChoreographer;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.executors.BackgroundWorkLogger.OnTrackingChangeListener;
import com.facebook.common.executors.BackgroundWorkLogger.StatsCollector;
import com.facebook.common.executors.BaseBackgroundWorkLogger;
import com.facebook.common.executors.FbHandlerThreadFactory.FbHandlerThread.1;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.debug.pref.DebugLoggingPrefKeys;
import com.facebook.inject.Lazy;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.OnSharedPreferenceChangeListener;
import com.facebook.prefs.shared.PrefKey;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: select_country */
public class DumpBackgroundWorkLogger extends BaseBackgroundWorkLogger {
    private final Lazy<FbSharedPreferences> f4241a;
    private final DumpStatsCollectorProvider f4242b;

    @Nullable
    public final /* synthetic */ List m4249a(1 1) {
        return b(1);
    }

    @Inject
    public DumpBackgroundWorkLogger(Lazy<FbSharedPreferences> lazy, DumpStatsCollectorProvider dumpStatsCollectorProvider, @Nullable MultiplexBackgroundWorkObserver multiplexBackgroundWorkObserver) {
        super(multiplexBackgroundWorkObserver);
        this.f4241a = lazy;
        this.f4242b = dumpStatsCollectorProvider;
    }

    public final StatsCollector m4248a(String str, Object obj) {
        if (!m4247b()) {
            return super.a(str, obj);
        }
        DumpStatsCollectorProvider dumpStatsCollectorProvider = this.f4242b;
        return new DumpStatsCollector(str, obj, AppStateManager.a(dumpStatsCollectorProvider), DefaultAppChoreographer.a(dumpStatsCollectorProvider), (BackgroundWorkRecorder) dumpStatsCollectorProvider.getInstance(BackgroundWorkRecorder.class), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(dumpStatsCollectorProvider));
    }

    public final boolean m4250a() {
        return m4247b() || super.a();
    }

    @Nullable
    public final ArrayList<Object> m4251b(final OnTrackingChangeListener onTrackingChangeListener) {
        ArrayList<Object> arrayList;
        ArrayList<Object> b = super.b(onTrackingChangeListener);
        if (b == null) {
            arrayList = new ArrayList(1);
        } else {
            arrayList = b;
        }
        C03861 c03861 = new OnSharedPreferenceChangeListener(this) {
            final /* synthetic */ DumpBackgroundWorkLogger f4240b;

            public final void m4246a(FbSharedPreferences fbSharedPreferences, PrefKey prefKey) {
                onTrackingChangeListener.a(this.f4240b.a());
            }
        };
        arrayList.add(c03861);
        ((FbSharedPreferences) this.f4241a.get()).a(DebugLoggingPrefKeys.e, c03861);
        return arrayList;
    }

    private boolean m4247b() {
        return ((FbSharedPreferences) this.f4241a.get()).a() && ((FbSharedPreferences) this.f4241a.get()).a(DebugLoggingPrefKeys.e, false);
    }
}

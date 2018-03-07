package com.facebook.common.executors;

import com.facebook.common.executors.BackgroundWorkLogger.OnTrackingChangeListener;
import com.facebook.common.executors.BackgroundWorkLogger.StatsCollector;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: marketplace_your_items */
public class NoOpBackgroundWorkLogger implements BackgroundWorkLogger {
    public static final StatsCollector f14986a = new C06491();

    /* compiled from: marketplace_your_items */
    final class C06491 implements StatsCollector {
        C06491() {
        }

        public final void mo2832a() {
        }

        public final void mo2833a(boolean z) {
        }
    }

    public final StatsCollector mo229a(String str, Object obj) {
        return f14986a;
    }

    public final boolean mo231a() {
        return false;
    }

    @Nullable
    public final List<Object> mo230a(OnTrackingChangeListener onTrackingChangeListener) {
        return null;
    }
}

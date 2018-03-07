package com.facebook.common.executors;

import java.util.List;
import javax.annotation.Nullable;

/* compiled from: webview/?url={%s} */
public interface BackgroundWorkLogger {

    /* compiled from: webview/?url={%s} */
    public interface StatsCollector {
        void mo2832a();

        void mo2833a(boolean z);
    }

    StatsCollector mo229a(String str, Object obj);

    @Nullable
    List<Object> mo230a(OnTrackingChangeListener onTrackingChangeListener);

    boolean mo231a();
}

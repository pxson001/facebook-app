package com.facebook.composer.analytics;

import android.util.Pair;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.time.Clock;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: place_picker_minutiae_to_place_skip */
public class ComposerLocationProductsPresenterLogger {
    public final AnalyticsLogger f7784a;
    public final Clock f7785b;
    public final Stats f7786c = new Stats(this);
    public String f7787d;

    /* compiled from: place_picker_minutiae_to_place_skip */
    public enum Mode {
        REQUESTED,
        SUCCEEDED,
        FAILED;

        public final String toString() {
            return super.toString().toLowerCase();
        }
    }

    /* compiled from: place_picker_minutiae_to_place_skip */
    public class Stats {
        public final /* synthetic */ ComposerLocationProductsPresenterLogger f7782a;
        public final List<Pair<String, Long>> f7783b = new ArrayList();

        public Stats(ComposerLocationProductsPresenterLogger composerLocationProductsPresenterLogger) {
            this.f7782a = composerLocationProductsPresenterLogger;
        }

        public static void m11161a(Stats stats, String str) {
            stats.f7783b.add(Pair.create(str, Long.valueOf(stats.f7782a.f7785b.a())));
        }
    }

    @Inject
    public ComposerLocationProductsPresenterLogger(AnalyticsLogger analyticsLogger, Clock clock) {
        this.f7784a = analyticsLogger;
        this.f7785b = clock;
    }

    public final void m11163a(boolean z, Mode mode) {
        Stats.m11161a(this.f7786c, "place_list_" + mode.toString() + "_" + (z ? "use_prefixed_location" : "use_device_location"));
    }

    public final void m11162a(Mode mode) {
        Stats.m11161a(this.f7786c, "device_location_" + mode.toString());
    }
}

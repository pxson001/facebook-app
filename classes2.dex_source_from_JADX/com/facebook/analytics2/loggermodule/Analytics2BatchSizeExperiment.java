package com.facebook.analytics2.loggermodule;

import com.facebook.analytics2.logger.MaxEventsPerBatchProvider;
import com.facebook.analytics2.logger.UploadSchedulerParams;
import com.facebook.analytics2.logger.UploadSchedulerParamsProvider;
import com.facebook.analytics2.loggermodule.qe.ExperimentsForAnalytics2LoggerModule;
import com.facebook.common.init.AppInitLock;
import com.facebook.inject.Lazy;
import com.facebook.qe.api.QeAccessor;
import com.facebook.tools.dextr.runtime.detour.TraceCompatDetour;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* compiled from: tap_to_load_image */
class Analytics2BatchSizeExperiment {
    public static final long f3398a = TimeUnit.MINUTES.toMillis(15);
    public static final long f3399b = TimeUnit.MINUTES.toMillis(45);
    public static final long f3400c = TimeUnit.MINUTES.toMillis(30);

    /* compiled from: tap_to_load_image */
    public class NormalPriMaxEventsPerBatchProvider implements MaxEventsPerBatchProvider {
        private final Lazy<AppInitLock> f3186a;
        private final Lazy<QeAccessor> f3187b;
        private int f3188c = -1;

        public NormalPriMaxEventsPerBatchProvider(Lazy<AppInitLock> lazy, Lazy<QeAccessor> lazy2) {
            this.f3186a = lazy;
            this.f3187b = lazy2;
        }

        public final int mo737a() {
            if (this.f3188c == -1) {
                m5350b();
            }
            return this.f3188c;
        }

        private void m5350b() {
            Analytics2BatchSizeExperiment.m5615b((AppInitLock) this.f3186a.get());
            TraceCompatDetour.a("readMaxEventsPerBatchQE", 701284822);
            try {
                this.f3188c = ((QeAccessor) this.f3187b.get()).mo572a(ExperimentsForAnalytics2LoggerModule.f3409i, 50);
            } finally {
                TraceCompatDetour.a(1936470242);
            }
        }
    }

    /* compiled from: tap_to_load_image */
    public class NormalPriUploadSchedulerParamsProvider implements UploadSchedulerParamsProvider {
        private final Lazy<AppInitLock> f3189a;
        private final Lazy<QeAccessor> f3190b;
        @Nullable
        private UploadSchedulerParams f3191c;
        @Nullable
        private UploadSchedulerParams f3192d;

        public NormalPriUploadSchedulerParamsProvider(Lazy<AppInitLock> lazy, Lazy<QeAccessor> lazy2) {
            this.f3189a = lazy;
            this.f3190b = lazy2;
        }

        public final UploadSchedulerParams mo738a() {
            if (this.f3191c == null) {
                m5353c();
            }
            return this.f3191c;
        }

        public final UploadSchedulerParams mo739b() {
            if (this.f3192d == null) {
                m5354d();
            }
            return this.f3192d;
        }

        private void m5353c() {
            Analytics2BatchSizeExperiment.m5615b((AppInitLock) this.f3189a.get());
            TraceCompatDetour.a("readForegroundParamsQEData", 2138332111);
            try {
                this.f3191c = new UploadSchedulerParams(((QeAccessor) this.f3190b.get()).mo575a(ExperimentsForAnalytics2LoggerModule.f3408h, Analytics2BatchSizeExperiment.f3398a), ((QeAccessor) this.f3190b.get()).mo575a(ExperimentsForAnalytics2LoggerModule.f3406f, Analytics2BatchSizeExperiment.f3399b), ((QeAccessor) this.f3190b.get()).mo575a(ExperimentsForAnalytics2LoggerModule.f3407g, 0), ((QeAccessor) this.f3190b.get()).mo575a(ExperimentsForAnalytics2LoggerModule.f3405e, Analytics2BatchSizeExperiment.f3400c));
            } finally {
                TraceCompatDetour.a(1219360866);
            }
        }

        private void m5354d() {
            Analytics2BatchSizeExperiment.m5615b((AppInitLock) this.f3189a.get());
            TraceCompatDetour.a("readBackgroundParamsQEData", 1856582888);
            try {
                this.f3192d = new UploadSchedulerParams(((QeAccessor) this.f3190b.get()).mo575a(ExperimentsForAnalytics2LoggerModule.f3404d, Analytics2BatchSizeExperiment.f3398a), ((QeAccessor) this.f3190b.get()).mo575a(ExperimentsForAnalytics2LoggerModule.f3402b, Analytics2BatchSizeExperiment.f3399b), ((QeAccessor) this.f3190b.get()).mo575a(ExperimentsForAnalytics2LoggerModule.f3403c, 0), ((QeAccessor) this.f3190b.get()).mo575a(ExperimentsForAnalytics2LoggerModule.f3401a, Analytics2BatchSizeExperiment.f3400c));
            } finally {
                TraceCompatDetour.a(955067544);
            }
        }
    }

    Analytics2BatchSizeExperiment() {
    }

    public static void m5615b(AppInitLock appInitLock) {
        TraceCompatDetour.a("waitForInitialization", -1571867740);
        try {
            appInitLock.m2277b();
        } finally {
            TraceCompatDetour.a(1329496813);
        }
    }
}

package com.facebook.debug.fieldusage;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.executors.C0109x696ccb0c;
import com.facebook.common.random.Random_InsecureRandomMethodAutoProvider;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.debug.fieldusage.abtest.ExperimentsForFieldUsageExperimentModule;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.flatbuffers.MutableFlattenable;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.fasterxml.jackson.core.JsonParser;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;

/* compiled from: send_to_montage */
public class FieldUsageReporterFactory {
    private final AnalyticsLogger f5592a;
    private final ScheduledExecutorService f5593b;
    private final MonotonicClock f5594c;
    public final Random f5595d;
    public final QeAccessor f5596e;

    public static FieldUsageReporterFactory m9546b(InjectorLike injectorLike) {
        return new FieldUsageReporterFactory(QeInternalImplMethodAutoProvider.m3744a(injectorLike), AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike), C0109x696ccb0c.m2944a(injectorLike), AwakeTimeSinceBootClockMethodAutoProvider.m1697a(injectorLike), Random_InsecureRandomMethodAutoProvider.m2102a(injectorLike));
    }

    @Inject
    public FieldUsageReporterFactory(QeAccessor qeAccessor, AnalyticsLogger analyticsLogger, ScheduledExecutorService scheduledExecutorService, MonotonicClock monotonicClock, Random random) {
        this.f5592a = analyticsLogger;
        this.f5593b = scheduledExecutorService;
        this.f5596e = qeAccessor;
        this.f5594c = monotonicClock;
        this.f5595d = random;
        FieldAccessQueryContext.f5597a = this;
    }

    public final boolean m9548a() {
        return this.f5596e.mo572a(ExperimentsForFieldUsageExperimentModule.f15031a, 0) != 0;
    }

    public final long m9549b() {
        return (long) (this.f5596e.mo572a(ExperimentsForFieldUsageExperimentModule.f15031a, 0) * 2);
    }

    public final long m9550c() {
        return (long) this.f5596e.mo572a(ExperimentsForFieldUsageExperimentModule.f15032b, 10);
    }

    public final void m9547a(String str, String str2, Object obj) {
        if (m9548a()) {
            Object obj2;
            if (this.f5595d.nextLong() % ((long) this.f5596e.mo572a(ExperimentsForFieldUsageExperimentModule.f15033c, 10)) == 0) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if (obj2 != null) {
                Object w_;
                if (obj instanceof MutableFlattenable) {
                    w_ = ((MutableFlattenable) obj).w_();
                } else {
                    w_ = obj;
                }
                FieldAccessQueryTracker fieldAccessQueryTracker = new FieldAccessQueryTracker(str, str2, this.f5594c, w_ instanceof MutableFlatBuffer);
                if (w_ instanceof JsonParser) {
                    String a = FieldAccessQueryContext.m9553a(((JsonParser) w_).mo1779j());
                    if (a != null) {
                        fieldAccessQueryTracker.b(a);
                    }
                }
                if (FieldAccessQueryContext.m9556a(w_, fieldAccessQueryTracker)) {
                    FieldUsageReporter fieldUsageReporter = new FieldUsageReporter(this.f5592a, fieldAccessQueryTracker, w_);
                    int a2 = this.f5596e.mo572a(ExperimentsForFieldUsageExperimentModule.f15031a, 0);
                    if (a2 > 0) {
                        this.f5593b.schedule(fieldUsageReporter, (long) a2, TimeUnit.SECONDS);
                    }
                }
            }
        }
    }
}

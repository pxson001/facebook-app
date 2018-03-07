package com.facebook.debug.fps;

import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.util.injectable.DisplayUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.proguard.annotations.DoNotStrip;
import javax.inject.Inject;

/* compiled from: _count */
public class AnimationLogger implements FpsListener {
    private final FPSController f11781a;
    private final DisplayUtil f11782b;
    private final MonotonicClock f11783c;
    private boolean f11784d = false;
    private int f11785e;

    private static AnimationLogger m19807b(InjectorLike injectorLike) {
        return new AnimationLogger((FPSControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FPSControllerProvider.class), DisplayUtil.a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike));
    }

    @DoNotStrip
    @Inject
    public AnimationLogger(FPSControllerProvider fPSControllerProvider, DisplayUtil displayUtil, MonotonicClock monotonicClock) {
        this.f11781a = fPSControllerProvider.a(Boolean.valueOf(false));
        this.f11781a.f = this;
        this.f11782b = displayUtil;
        this.f11783c = monotonicClock;
    }

    public final void m19808a(int i) {
        if (this.f11784d) {
            this.f11785e++;
        }
    }
}

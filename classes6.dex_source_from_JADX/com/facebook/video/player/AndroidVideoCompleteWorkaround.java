package com.facebook.video.player;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: composer_prompt_text */
public class AndroidVideoCompleteWorkaround {
    private final long f18970a = 50;
    public final MonotonicClock f18971b;
    public final AbstractFbErrorReporter f18972c;
    public String f18973d;
    public long f18974e;
    public long f18975f;

    public static AndroidVideoCompleteWorkaround m27634a(InjectorLike injectorLike) {
        return new AndroidVideoCompleteWorkaround((MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public AndroidVideoCompleteWorkaround(MonotonicClock monotonicClock, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f18971b = monotonicClock;
        this.f18972c = abstractFbErrorReporter;
    }

    public final void m27635a() {
        this.f18973d = null;
        this.f18975f = 0;
        this.f18974e = -100;
    }
}

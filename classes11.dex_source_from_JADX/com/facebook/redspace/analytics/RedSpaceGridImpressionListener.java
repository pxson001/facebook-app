package com.facebook.redspace.analytics;

import com.facebook.inject.InjectorLike;
import com.facebook.redspace.analytics.logger.RedSpaceLogger;
import javax.inject.Inject;

/* compiled from: ProfileVideoView */
public class RedSpaceGridImpressionListener {
    public final RedSpaceLogger f11755a;

    public static RedSpaceGridImpressionListener m12192a(InjectorLike injectorLike) {
        return new RedSpaceGridImpressionListener(RedSpaceLogger.a(injectorLike));
    }

    @Inject
    public RedSpaceGridImpressionListener(RedSpaceLogger redSpaceLogger) {
        this.f11755a = redSpaceLogger;
    }
}

package com.facebook.debug.fps;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.common.executors.C0055x2995691a;
import com.facebook.common.util.injectable.DisplayUtil;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Optional;

/* compiled from: old_status */
public class FrameRateLoggerProvider extends AbstractAssistedProvider<FrameRateLogger> {
    public final FrameRateLogger m16560a(Boolean bool, String str, Optional<String> optional) {
        return new FrameRateLogger(C0055x2995691a.m1881a(this), AnalyticsLoggerMethodAutoProvider.m3509a(this), (FPSControllerProvider) getOnDemandAssistedProviderForStaticDi(FPSControllerProvider.class), DisplayUtil.m16577a(this), FrameRateBlameMarkers.m16545a((InjectorLike) this), TimeSinceTTI.m14650a(this), bool, str, optional);
    }
}

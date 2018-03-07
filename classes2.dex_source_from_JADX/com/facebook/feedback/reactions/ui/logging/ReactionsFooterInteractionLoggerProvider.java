package com.facebook.feedback.reactions.ui.logging;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.funnellogger.FunnelLoggerImpl;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: has_icc_card */
public class ReactionsFooterInteractionLoggerProvider extends AbstractAssistedProvider<ReactionsFooterInteractionLogger> {
    public final ReactionsFooterInteractionLogger m29073a(String str, String str2, String str3) {
        return new ReactionsFooterInteractionLogger(FunnelLoggerImpl.m8018a((InjectorLike) this), AnalyticsLoggerMethodAutoProvider.m3509a(this), SystemClockMethodAutoProvider.m1498a(this), str, str2, str3);
    }
}

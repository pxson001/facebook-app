package com.facebook.facecastdisplay;

import android.os.Bundle;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.facecastdisplay.protocol.LiveCommentDelayLoggingMethod.Params;
import com.facebook.facecastdisplay.protocol.LiveVideosWatchingEventsLoggingMethod;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import java.util.Random;
import javax.inject.Inject;

/* compiled from: pop.m4a */
public class LiveEventsLogger {
    private final Clock f4448a;
    private final DefaultBlueServiceOperationFactory f4449b;
    private final Random f4450c;
    private final AnalyticsLogger f4451d;

    public static LiveEventsLogger m4947b(InjectorLike injectorLike) {
        return new LiveEventsLogger((Clock) SystemClockMethodAutoProvider.a(injectorLike), DefaultBlueServiceOperationFactory.b(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public LiveEventsLogger(Clock clock, DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, AnalyticsLogger analyticsLogger) {
        this.f4448a = clock;
        this.f4449b = defaultBlueServiceOperationFactory;
        this.f4451d = analyticsLogger;
        this.f4450c = new Random(clock.a());
    }

    public final void m4948a(LiveEventModel liveEventModel) {
        if ((liveEventModel instanceof LiveCommentEventModel) && this.f4450c.nextInt(10) == 1) {
            LiveCommentEventModel liveCommentEventModel = (LiveCommentEventModel) liveEventModel;
            if (liveCommentEventModel.d != null) {
                Params params = new Params(liveCommentEventModel.d, ((double) this.f4448a.a()) / 1000.0d);
                Bundle bundle = new Bundle();
                bundle.putParcelable("liveCommentLogDelayParamsKey", params);
                BlueServiceOperationFactoryDetour.a(this.f4449b, "live_comment_log_delay", bundle, -989847096).a();
            }
        }
    }

    public final void m4949a(String str, int i) {
        if (str != null) {
            LiveVideosWatchingEventsLoggingMethod.Params params = new LiveVideosWatchingEventsLoggingMethod.Params(str, i);
            Bundle bundle = new Bundle();
            bundle.putParcelable("liveVideoLogWatchTimeParamsKey", params);
            BlueServiceOperationFactoryDetour.a(this.f4449b, "live_video_log_watch_time", bundle, 1268622923).a();
        }
    }

    public final void m4950a(String str, String str2, String str3, boolean z) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("live_scribe_impression");
        honeyClientEvent.c = "Facecast";
        this.f4451d.a(honeyClientEvent.b("live_video_id", str).b("broadcaster_id", str2).b("surface", str3).a("is_live_streaming", z));
    }
}

package com.facebook.video.engine;

import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.subtitles.controller.Subtitles;
import com.google.common.base.Preconditions;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: compost_draft */
public class ExitFullScreenResult {
    public final boolean f18782a;
    public final boolean f18783b;
    public final int f18784c;
    public final int f18785d;
    public final boolean f18786e;
    public final EventTriggerType f18787f;
    public final Subtitles f18788g;

    public ExitFullScreenResult(boolean z, boolean z2, int i, int i2, boolean z3, Subtitles subtitles, EventTriggerType eventTriggerType) {
        boolean z4 = true;
        Preconditions.checkArgument(i >= 0);
        if (i2 < 0) {
            z4 = false;
        }
        Preconditions.checkArgument(z4);
        this.f18782a = z;
        this.f18783b = z2;
        this.f18784c = i;
        this.f18785d = i2;
        this.f18786e = z3;
        this.f18788g = subtitles;
        this.f18787f = eventTriggerType;
    }
}

package com.facebook.video.videohome.metadata;

import com.facebook.debug.log.BLog;
import com.facebook.notifications.common.JewelCounters;
import com.facebook.notifications.common.JewelCounters.Jewel;
import com.facebook.video.videohome.abtest.VideoHomeConfig;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: source_longitude */
public class VideoHomeBadgeUpdater {
    private static final String f2970a = VideoHomeBadgeUpdater.class.getSimpleName();
    private final JewelCounters f2971b;
    private final VideoHomeConfig f2972c;
    @Nullable
    public VideoHomeMetadata f2973d;

    @Inject
    public VideoHomeBadgeUpdater(JewelCounters jewelCounters, VideoHomeConfig videoHomeConfig) {
        this.f2971b = jewelCounters;
        this.f2972c = videoHomeConfig;
    }

    public final void m2882c() {
        if (!this.f2972c.a()) {
            return;
        }
        if (this.f2973d != null) {
            Integer.valueOf(this.f2973d.f2980a);
            if (m2881a(this.f2973d.f2980a)) {
                this.f2971b.a(Jewel.VIDEO_HOME, this.f2973d.f2980a);
                return;
            }
            return;
        }
        BLog.b(f2970a, "maybeUpdateBadgeCount mMetadata was null");
    }

    public final boolean m2881a(int i) {
        return this.f2971b.a(Jewel.VIDEO_HOME) != i;
    }

    public final void m2883d() {
        this.f2971b.a(Jewel.VIDEO_HOME, 0);
    }
}

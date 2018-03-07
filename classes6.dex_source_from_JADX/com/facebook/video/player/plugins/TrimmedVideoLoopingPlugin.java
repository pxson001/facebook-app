package com.facebook.video.player.plugins;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.events.RVPRequestSeekingEvent;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: composerConfigurationFromDraft */
public class TrimmedVideoLoopingPlugin extends RichVideoPlayerPlugin {
    private Handler f19383a;
    public int f19384b;
    public int f19385c;
    private Runnable f19386d;
    public int f19387l;

    /* compiled from: composerConfigurationFromDraft */
    class C14471 implements Runnable {
        final /* synthetic */ TrimmedVideoLoopingPlugin f19382a;

        C14471(TrimmedVideoLoopingPlugin trimmedVideoLoopingPlugin) {
            this.f19382a = trimmedVideoLoopingPlugin;
        }

        public void run() {
            if (this.f19382a.h == null || !this.f19382a.h.i() || this.f19382a.f19385c == -1) {
                TrimmedVideoLoopingPlugin.m28158d(this.f19382a);
                return;
            }
            int f = this.f19382a.h.f();
            if (f < this.f19382a.f19384b) {
                if (this.f19382a.f19387l != 3) {
                    this.f19382a.f19387l = 3;
                    TrimmedVideoLoopingPlugin.m28159e(this.f19382a);
                }
            } else if (f > this.f19382a.f19384b && f < TrimmedVideoLoopingPlugin.getVideoEndTime(this.f19382a)) {
                this.f19382a.f19387l = 1;
            } else if (this.f19382a.f19387l != 3) {
                this.f19382a.f19387l = 3;
                TrimmedVideoLoopingPlugin.m28159e(this.f19382a);
            }
            TrimmedVideoLoopingPlugin.m28158d(this.f19382a);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: composerConfigurationFromDraft */
    @interface State {
    }

    public TrimmedVideoLoopingPlugin(Context context) {
        this(context, null);
    }

    private TrimmedVideoLoopingPlugin(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private TrimmedVideoLoopingPlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f19387l = 2;
        this.f19383a = new Handler();
        this.f19386d = new C14471(this);
    }

    public static void m28158d(TrimmedVideoLoopingPlugin trimmedVideoLoopingPlugin) {
        int videoEndTime;
        int i = 1000;
        if (getVideoEndTime(trimmedVideoLoopingPlugin) - trimmedVideoLoopingPlugin.f19384b > 0) {
            videoEndTime = getVideoEndTime(trimmedVideoLoopingPlugin) - trimmedVideoLoopingPlugin.f19384b;
        } else {
            videoEndTime = 0;
        }
        int i2 = videoEndTime;
        if (i2 > 0) {
            i = (int) (((float) i2) * 0.15f);
        }
        HandlerDetour.a(trimmedVideoLoopingPlugin.f19383a, trimmedVideoLoopingPlugin.f19386d);
        HandlerDetour.b(trimmedVideoLoopingPlugin.f19383a, trimmedVideoLoopingPlugin.f19386d, (long) i, -1846568172);
    }

    public static void m28159e(TrimmedVideoLoopingPlugin trimmedVideoLoopingPlugin) {
        if (trimmedVideoLoopingPlugin.g != null) {
            trimmedVideoLoopingPlugin.g.a(new RVPRequestSeekingEvent(trimmedVideoLoopingPlugin.f19384b, EventTriggerType.BY_PLAYER));
        }
    }

    protected final void m28160a(RichVideoPlayerParams richVideoPlayerParams, boolean z) {
        super.a(richVideoPlayerParams, z);
        if (richVideoPlayerParams.b.containsKey("TrimStartPosition")) {
            this.f19384b = ((Integer) richVideoPlayerParams.b.get("TrimStartPosition")).intValue();
        } else {
            this.f19384b = 0;
        }
        if (richVideoPlayerParams.b.containsKey("TrimEndPosition")) {
            this.f19385c = ((Integer) richVideoPlayerParams.b.get("TrimEndPosition")).intValue();
        } else {
            this.f19385c = -1;
        }
        HandlerDetour.a(this.f19383a, this.f19386d, 1638421819);
    }

    protected final void m28161c() {
        HandlerDetour.a(this.f19383a, this.f19386d);
    }

    public static int getVideoEndTime(TrimmedVideoLoopingPlugin trimmedVideoLoopingPlugin) {
        if (trimmedVideoLoopingPlugin.f19385c != -1) {
            return trimmedVideoLoopingPlugin.f19385c;
        }
        return trimmedVideoLoopingPlugin.h == null ? 0 : trimmedVideoLoopingPlugin.h.h();
    }
}

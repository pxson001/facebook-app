package com.facebook.feed.ui.fullscreenvideoplayer.plugins;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.attachments.utils.CallToActionUtil;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.feed.ui.fullscreenvideoplayer.plugins.CallToActionEndscreenBasePlugin.EndscreenType;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.player.events.RVPChromeBehaviorChangeEvent;
import com.facebook.video.player.events.RVPRequestPlayingEvent;
import com.facebook.video.player.plugins.ChromeBehavior;
import javax.annotation.Nullable;
import javax.inject.Inject;

@DoNotStrip
/* compiled from: TimelineBindHeader */
public class FullscreenCallToActionEndscreenPlugin extends CallToActionEndscreenBasePlugin {
    @Inject
    public CallToActionUtil f22113m;
    private final OnClickListener f22114n;

    /* compiled from: TimelineBindHeader */
    class C18871 implements OnClickListener {
        final /* synthetic */ FullscreenCallToActionEndscreenPlugin f22112a;

        C18871(FullscreenCallToActionEndscreenPlugin fullscreenCallToActionEndscreenPlugin) {
            this.f22112a = fullscreenCallToActionEndscreenPlugin;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -618361470);
            if (this.f22112a.g != null) {
                this.f22112a.g.a(new RVPRequestPlayingEvent(EventTriggerType.BY_USER));
                this.f22112a.g.a(new RVPChromeBehaviorChangeEvent(ChromeBehavior.AUTO));
                if (this.f22112a.b == EndscreenType.ENDSCREEN) {
                    this.f22112a.k();
                }
            }
            Logger.a(2, EntryType.UI_INPUT_END, 1850989005, a);
        }
    }

    public static void m24735a(Object obj, Context context) {
        ((FullscreenCallToActionEndscreenPlugin) obj).f22113m = CallToActionUtil.b(FbInjector.get(context));
    }

    @DoNotStrip
    public FullscreenCallToActionEndscreenPlugin(Context context) {
        this(context, null);
    }

    private FullscreenCallToActionEndscreenPlugin(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private FullscreenCallToActionEndscreenPlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f22114n = new C18871(this);
        Class cls = FullscreenCallToActionEndscreenPlugin.class;
        m24735a(this, getContext());
    }

    protected final boolean m24738j() {
        return a(this.a);
    }

    protected final boolean m24736a(@Nullable GraphQLStoryAttachment graphQLStoryAttachment) {
        if (this.f22113m.a()) {
            if (graphQLStoryAttachment == null || !this.f22113m.c(graphQLStoryAttachment)) {
                return false;
            }
            return true;
        } else if (graphQLStoryAttachment == null || (!CallToActionUtil.e(graphQLStoryAttachment) && !CallToActionUtil.d(graphQLStoryAttachment))) {
            return false;
        } else {
            return true;
        }
    }

    protected OnClickListener getCallToActionEndscreenReplayClickListener() {
        return this.f22114n;
    }

    protected final boolean m24737f() {
        return true;
    }
}

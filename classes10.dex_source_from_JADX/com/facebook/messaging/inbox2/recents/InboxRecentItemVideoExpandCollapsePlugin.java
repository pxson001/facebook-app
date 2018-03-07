package com.facebook.messaging.inbox2.recents;

import android.content.Context;
import com.facebook.content.event.FbEvent;
import com.facebook.messaging.inbox2.recents.InboxRecentItemVideoView.InboxRecentItemVideoViewEnvironment;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.events.RVPChromeBehaviorChangeEvent;
import com.facebook.video.player.events.RVPPlayerStateChangedEvent;
import com.facebook.video.player.events.RVPSeekBarStateEvent;
import com.facebook.video.player.events.RichVideoPlayerEventSubscriber;
import com.facebook.video.player.plugins.ChromeBehavior;
import com.facebook.video.player.plugins.PlaybackController.State;
import com.facebook.video.player.plugins.RichVideoPlayerPluginWithEnv;

/* compiled from: send failed! */
class InboxRecentItemVideoExpandCollapsePlugin extends RichVideoPlayerPluginWithEnv<InboxRecentItemVideoEnvironment> {
    private static final Class<?> f2884a = InboxRecentItemVideoExpandCollapsePlugin.class;

    /* compiled from: send failed! */
    class C04721 extends RichVideoPlayerEventSubscriber<RVPPlayerStateChangedEvent> {
        final /* synthetic */ InboxRecentItemVideoExpandCollapsePlugin f2882a;

        C04721(InboxRecentItemVideoExpandCollapsePlugin inboxRecentItemVideoExpandCollapsePlugin) {
            this.f2882a = inboxRecentItemVideoExpandCollapsePlugin;
        }

        public final void m2846b(FbEvent fbEvent) {
            RVPPlayerStateChangedEvent rVPPlayerStateChangedEvent = (RVPPlayerStateChangedEvent) fbEvent;
            InboxRecentItemVideoExpandCollapsePlugin inboxRecentItemVideoExpandCollapsePlugin = this.f2882a;
            if (rVPPlayerStateChangedEvent.b.isPlayingState() && inboxRecentItemVideoExpandCollapsePlugin.c != null) {
                ((InboxRecentItemVideoViewEnvironment) inboxRecentItemVideoExpandCollapsePlugin.c).m2853a();
            }
            if (rVPPlayerStateChangedEvent.b == State.PLAYING) {
                inboxRecentItemVideoExpandCollapsePlugin.g.a(new RVPSeekBarStateEvent(RVPSeekBarStateEvent.State.DEFAULT));
            } else if (rVPPlayerStateChangedEvent.b == State.PLAYBACK_COMPLETE) {
                if (inboxRecentItemVideoExpandCollapsePlugin.c != null) {
                    ((InboxRecentItemVideoViewEnvironment) inboxRecentItemVideoExpandCollapsePlugin.c).m2854b();
                }
            }
        }

        public final Class<RVPPlayerStateChangedEvent> m2845a() {
            return RVPPlayerStateChangedEvent.class;
        }
    }

    /* compiled from: send failed! */
    class C04732 extends RichVideoPlayerEventSubscriber<InboxRecentItemVideoExpandStateChangeEvent> {
        final /* synthetic */ InboxRecentItemVideoExpandCollapsePlugin f2883a;

        C04732(InboxRecentItemVideoExpandCollapsePlugin inboxRecentItemVideoExpandCollapsePlugin) {
            this.f2883a = inboxRecentItemVideoExpandCollapsePlugin;
        }

        public final void m2848b(FbEvent fbEvent) {
            if (((InboxRecentItemVideoExpandStateChangeEvent) fbEvent).f2885a) {
                this.f2883a.g.a(new RVPChromeBehaviorChangeEvent(ChromeBehavior.AUTO));
            } else {
                InboxRecentItemVideoExpandCollapsePlugin.m2849k(this.f2883a);
            }
        }

        public final Class<InboxRecentItemVideoExpandStateChangeEvent> m2847a() {
            return InboxRecentItemVideoExpandStateChangeEvent.class;
        }
    }

    public InboxRecentItemVideoExpandCollapsePlugin(Context context, InboxRecentItemVideoViewEnvironment inboxRecentItemVideoViewEnvironment) {
        super(context);
        this.f.add(new C04721(this));
        this.f.add(new C04732(this));
        setEnvironment(inboxRecentItemVideoViewEnvironment);
    }

    protected final void m2850a(RichVideoPlayerParams richVideoPlayerParams, boolean z) {
        m2849k(this);
    }

    public static void m2849k(InboxRecentItemVideoExpandCollapsePlugin inboxRecentItemVideoExpandCollapsePlugin) {
        inboxRecentItemVideoExpandCollapsePlugin.g.a(new RVPSeekBarStateEvent(RVPSeekBarStateEvent.State.ALWAYS_INVISIBLE));
        inboxRecentItemVideoExpandCollapsePlugin.g.a(new RVPChromeBehaviorChangeEvent(ChromeBehavior.ALWAYS_VISIBLE));
    }
}

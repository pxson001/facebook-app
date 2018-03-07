package com.facebook.messaging.inbox2.recents;

import android.content.Context;
import android.content.Intent;
import android.view.ViewGroup;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.LocalBroadcast;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ultralight.Inject;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.player.events.RVPRequestPausingEvent;
import com.facebook.video.player.plugins.RichVideoPlayerPlugin;

/* compiled from: sendCancelGroupJoinRequestRequest */
public class InboxRecentItemVideoChatHeadsReceiverPlugin extends RichVideoPlayerPlugin {
    public static final Class<?> f2873a = InboxRecentItemVideoChatHeadsReceiverPlugin.class;
    @Inject
    @LocalBroadcast
    public BaseFbBroadcastManager f2874b;
    private final SelfRegistrableReceiverImpl f2875c = this.f2874b.a().a("chat_head_collapsed", new C04691(this)).a();

    /* compiled from: sendCancelGroupJoinRequestRequest */
    class C04691 implements ActionReceiver {
        final /* synthetic */ InboxRecentItemVideoChatHeadsReceiverPlugin f2872a;

        C04691(InboxRecentItemVideoChatHeadsReceiverPlugin inboxRecentItemVideoChatHeadsReceiverPlugin) {
            this.f2872a = inboxRecentItemVideoChatHeadsReceiverPlugin;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -139137164);
            Class cls = InboxRecentItemVideoChatHeadsReceiverPlugin.f2873a;
            this.f2872a.g.a(new RVPRequestPausingEvent(EventTriggerType.BY_CHAT_HEADS_COLLAPSE));
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 2075920698, a);
        }
    }

    public static void m2835a(Object obj, Context context) {
        ((InboxRecentItemVideoChatHeadsReceiverPlugin) obj).f2874b = (BaseFbBroadcastManager) LocalFbBroadcastManager.a(FbInjector.get(context));
    }

    public InboxRecentItemVideoChatHeadsReceiverPlugin(Context context) {
        super(context);
        Class cls = InboxRecentItemVideoChatHeadsReceiverPlugin.class;
        m2835a(this, getContext());
    }

    public final void m2836a(ViewGroup viewGroup) {
        super.a(viewGroup);
        this.f2875c.b();
    }

    public final void m2837b(ViewGroup viewGroup) {
        super.b(viewGroup);
        this.f2875c.c();
    }
}

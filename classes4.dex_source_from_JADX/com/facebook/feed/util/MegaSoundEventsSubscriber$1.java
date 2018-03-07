package com.facebook.feed.util;

import android.content.Context;
import android.content.Intent;
import com.facebook.composer.publish.optimistic.ComposerActivityBroadcaster.Result;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.sounds.FBSoundUtil;

/* compiled from: http.origin-server */
public class MegaSoundEventsSubscriber$1 implements ActionReceiver {
    final /* synthetic */ MegaSoundEventsSubscriber f10678a;

    public MegaSoundEventsSubscriber$1(MegaSoundEventsSubscriber megaSoundEventsSubscriber) {
        this.f10678a = megaSoundEventsSubscriber;
    }

    public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
        int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1787756733);
        MegaSoundEventsSubscriber megaSoundEventsSubscriber = this.f10678a;
        if (intent.getExtras().getString("extra_result").equals(Result.SUCCESS.toString())) {
            megaSoundEventsSubscriber = this.f10678a;
            if (MegaSoundEventsSubscriber.a("post_main")) {
                ((FBSoundUtil) this.f10678a.b.get()).m2629b("post_main");
            }
        }
        Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -869687505, a);
    }
}

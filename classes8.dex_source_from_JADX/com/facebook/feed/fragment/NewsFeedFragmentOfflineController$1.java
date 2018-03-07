package com.facebook.feed.fragment;

import android.content.Context;
import android.content.Intent;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: group_side_conversation_started */
public class NewsFeedFragmentOfflineController$1 implements ActionReceiver {
    final /* synthetic */ NewsFeedFragmentOfflineController f11877a;

    public NewsFeedFragmentOfflineController$1(NewsFeedFragmentOfflineController newsFeedFragmentOfflineController) {
        this.f11877a = newsFeedFragmentOfflineController;
    }

    public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
        int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 1826865749);
        NewsFeedFragmentOfflineController.e(this.f11877a);
        Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 1753200939, a);
    }
}

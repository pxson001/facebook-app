package com.facebook.backstage.nub;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.facebook.backstage.nub.BackstageService.C05661;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.content.DynamicSecureBroadcastReceiver;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap.Builder;

/* compiled from: request_action_id */
public class BackstageSystemIntentReceiver {
    private static final ImmutableList<String> f5403a = ImmutableList.of("android.intent.action.CLOSE_SYSTEM_DIALOGS", "android.intent.action.SCREEN_OFF", "android.intent.action.SCREEN_ON", "android.intent.action.USER_PRESENT");
    private final ActionReceiver f5404b = new C05681(this);
    public final DynamicSecureBroadcastReceiver f5405c;
    public final IntentFilter f5406d;
    public final C05661 f5407e;

    /* compiled from: request_action_id */
    class C05681 implements ActionReceiver {
        final /* synthetic */ BackstageSystemIntentReceiver f5402a;

        C05681(BackstageSystemIntentReceiver backstageSystemIntentReceiver) {
            this.f5402a = backstageSystemIntentReceiver;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 1970288194);
            C05661 c05661 = this.f5402a.f5407e;
            BackstageEventListener$EventType eventType = BackstageEventListener$EventType.getEventType(intent.getAction());
            intent.getExtras();
            c05661.m5624a(eventType);
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -2007445332, a);
        }
    }

    public BackstageSystemIntentReceiver(C05661 c05661) {
        int i = 0;
        this.f5407e = c05661;
        this.f5406d = new IntentFilter();
        int size = f5403a.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f5406d.addAction((String) f5403a.get(i2));
        }
        Builder builder = new Builder();
        size = f5403a.size();
        while (i < size) {
            builder.b((String) f5403a.get(i), this.f5404b);
            i++;
        }
        this.f5405c = new DynamicSecureBroadcastReceiver(builder.b());
    }
}

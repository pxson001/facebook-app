package com.facebook.messages.ipc;

import android.content.Context;
import android.content.Intent;
import com.facebook.content.FacebookOnlySecureBroadcastReceiver;
import com.facebook.messages.ipc.MessagesCrossProcessContract.MessageActionCallback;
import com.facebook.notifications.lockscreenservice.LockMessageLoader;
import com.facebook.notifications.lockscreenservice.LockMessageLoader.C05341;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import javax.inject.Provider;

/* compiled from: getImageStatus */
public class MessagesCrossProcessBroadcastReceiver extends FacebookOnlySecureBroadcastReceiver {
    private final C05341 f11151a;
    public final Provider<String> f11152b;

    public MessagesCrossProcessBroadcastReceiver(MessageActionCallback messageActionCallback, Provider<String> provider) {
        super(ImmutableList.of("messages.ACTION_NEW_MESSAGE", "messages.ACTION_CLEAR_ALL_MESSAGES", "messages.ACTION_CLEAR_MESSAGE"));
        this.f11151a = messageActionCallback;
        this.f11152b = provider;
    }

    protected final void m11609a(Context context, Intent intent, String str) {
        if (!Objects.equal(this.f11152b.get(), intent.getStringExtra("userId"))) {
            return;
        }
        if ("messages.ACTION_NEW_MESSAGE".equals(str)) {
            this.f11151a.f11150a.m9241a((FrozenNewMessageNotification) intent.getParcelableExtra("message"));
        } else if ("messages.ACTION_CLEAR_ALL_MESSAGES".equals(str)) {
            this.f11151a.f11150a.m9242b();
        } else if ("messages.ACTION_CLEAR_MESSAGE".equals(str)) {
            LockMessageLoader.m9237a(this.f11151a.f11150a, intent.getStringExtra("threadId"));
        }
    }
}

package com.facebook.prefetch.feed.scheduler;

import android.content.Context;
import android.content.Intent;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectableComponentWithoutContext;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.UltralightRuntime;
import javax.inject.Provider;

/* compiled from: response_num */
public class NewsFeedPrefetchBroadcastReceiver$InitiateFetchReceiver implements ActionReceiver {
    @Inject
    public volatile Provider<NewsFeedPrefetchInvoker> f4476a = UltralightRuntime.a;

    private static <T extends InjectableComponentWithoutContext> void m4316a(Class<T> cls, T t, Context context) {
        m4317a(t, context);
    }

    public static void m4317a(Object obj, Context context) {
        ((NewsFeedPrefetchBroadcastReceiver$InitiateFetchReceiver) obj).f4476a = IdBasedProvider.a(FbInjector.get(context), 9666);
    }

    NewsFeedPrefetchBroadcastReceiver$InitiateFetchReceiver() {
    }

    public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
        int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 717841706);
        if ("com.facebook.prefetch.feed.scheduler.NewsFeedPrefetchBroadcastReceiver.INITIATE_BACKGROUND_FETCH".equals(intent.getAction())) {
            String str = NewsFeedPrefetchBroadcastReceiver.a;
            Class cls = NewsFeedPrefetchBroadcastReceiver$InitiateFetchReceiver.class;
            m4317a(this, context);
            ((NewsFeedPrefetchInvoker) this.f4476a.get()).m4323a();
            LogUtils.e(-414492348, a);
            return;
        }
        Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 668717216, a);
    }

    private void m4318a(Provider<NewsFeedPrefetchInvoker> provider) {
        this.f4476a = provider;
    }
}

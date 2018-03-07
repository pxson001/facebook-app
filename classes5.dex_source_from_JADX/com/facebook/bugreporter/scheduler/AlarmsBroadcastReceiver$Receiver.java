package com.facebook.bugreporter.scheduler;

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

/* compiled from: android.intent.extra.TEXT */
public class AlarmsBroadcastReceiver$Receiver implements ActionReceiver {
    @Inject
    public volatile Provider<BugReportRetryInvoker> f10762a = UltralightRuntime.a;

    private static <T extends InjectableComponentWithoutContext> void m18790a(Class<T> cls, T t, Context context) {
        m18791a(t, context);
    }

    public static void m18791a(Object obj, Context context) {
        ((AlarmsBroadcastReceiver$Receiver) obj).f10762a = IdBasedProvider.a(FbInjector.get(context), 5021);
    }

    private void m18792a(Provider<BugReportRetryInvoker> provider) {
        this.f10762a = provider;
    }

    public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
        int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 1948182021);
        if ("com.facebook.bugreporter.scheduler.AlarmsBroadcastReceiver.RETRY_UPLOAD".equals(intent.getAction())) {
            Class cls = AlarmsBroadcastReceiver$Receiver.class;
            m18791a(this, context);
            ((BugReportRetryInvoker) this.f10762a.get()).m18794a();
            LogUtils.e(-1510633628, a);
            return;
        }
        Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -634076360, a);
    }
}

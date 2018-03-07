package com.facebook.base.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Looper;
import com.facebook.common.android.FbLocalBroadcastManager;
import com.facebook.debug.log.BLog;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import javax.annotation.Nullable;

@Deprecated
/* compiled from: quick_promotion_large_image_size_param */
public abstract class SafeLocalBroadcastReceiver {
    public static final Class<?> f8337a = SafeLocalBroadcastReceiver.class;
    private final FbLocalBroadcastManager f8338b;
    private final IntentFilter f8339c;
    private final BroadcastReceiver f8340d;
    @Nullable
    private final Looper f8341e;
    public boolean f8342f;

    /* compiled from: quick_promotion_large_image_size_param */
    class C03611 extends BroadcastReceiver {
        final /* synthetic */ SafeLocalBroadcastReceiver f8343a;

        C03611(SafeLocalBroadcastReceiver safeLocalBroadcastReceiver) {
            this.f8343a = safeLocalBroadcastReceiver;
        }

        public void onReceive(Context context, Intent intent) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -2030859356);
            if (this.f8343a.f8342f) {
                this.f8343a.mo1730a(context, intent);
                LogUtils.a(intent, -465189111, a);
                return;
            }
            BLog.b(SafeLocalBroadcastReceiver.f8337a, "Called onReceive after it was unregistered.");
            LogUtils.a(intent, 2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 2000886822, a);
        }
    }

    public abstract void mo1730a(Context context, Intent intent);

    public SafeLocalBroadcastReceiver(Context context, IntentFilter intentFilter) {
        this(context, intentFilter, null);
    }

    private SafeLocalBroadcastReceiver(Context context, IntentFilter intentFilter, @Nullable Looper looper) {
        this.f8338b = FbLocalBroadcastManager.m2961a(context);
        this.f8339c = intentFilter;
        this.f8340d = new C03611(this);
        this.f8341e = looper;
    }

    public final void m12857a() {
        if (this.f8342f) {
            BLog.b(f8337a, "Called registerNotificationReceiver twice.");
            return;
        }
        this.f8338b.m2968a(this.f8340d, this.f8339c, this.f8341e);
        this.f8342f = true;
    }

    public void mo1933b() {
        if (this.f8342f) {
            this.f8338b.m2966a(this.f8340d);
            this.f8342f = false;
        }
    }
}

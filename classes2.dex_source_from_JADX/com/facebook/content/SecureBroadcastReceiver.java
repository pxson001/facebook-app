package com.facebook.content;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.facebook.backgroundworklog.observer.MultiplexBackgroundWorkObserver;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.inject.FbInjector;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import javax.annotation.Nullable;

/* compiled from: upload_bytes_per_update */
public abstract class SecureBroadcastReceiver extends BroadcastReceiver implements BroadcastReceiverLike {
    @Nullable
    private final Lazy<MultiplexBackgroundWorkObserver> f1649a;

    @Nullable
    protected abstract ActionReceiver mo509a(Context context, Intent intent);

    protected SecureBroadcastReceiver() {
        this(null);
    }

    protected SecureBroadcastReceiver(@Nullable Lazy<MultiplexBackgroundWorkObserver> lazy) {
        this.f1649a = lazy;
    }

    @VisibleForTesting
    private void m3301b(Context context, Intent intent) {
        AbstractFbErrorReporter a = FbErrorReporterImpl.m2317a(FbInjector.get(context));
        String name = getClass().getName();
        a.m2340a(name, "Rejected the intent for the receiver because it was not registered: " + intent.getAction() + ":" + name);
    }

    protected boolean mo508b() {
        return true;
    }

    private MultiplexBackgroundWorkObserver m3302c() {
        if (this.f1649a == null) {
            return null;
        }
        return (MultiplexBackgroundWorkObserver) this.f1649a.get();
    }

    public final void onReceive(Context context, Intent intent) {
        Class cls = null;
        int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1619989948);
        MultiplexBackgroundWorkObserver c = m3302c();
        long j = -1;
        if (c != null) {
            j = c.m1684b();
        }
        try {
            if (mo508b()) {
                ActionReceiver a2 = mo509a(context, intent);
                if (a2 != null) {
                    cls = a2.getClass();
                    a2.onReceive(context, intent, this);
                } else {
                    m3301b(context, intent);
                }
                if (c != null) {
                    c.mo233a(j, intent, cls);
                }
                LogUtils.a(intent, 2003860387, a);
                return;
            }
            if (c != null) {
                c.mo233a(j, intent, null);
            }
            LogUtils.a(intent, 2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -689141010, a);
        } catch (Throwable th) {
            if (c != null) {
                c.mo233a(j, intent, null);
            }
            LogUtils.a(intent, 1885945658, a);
        }
    }
}

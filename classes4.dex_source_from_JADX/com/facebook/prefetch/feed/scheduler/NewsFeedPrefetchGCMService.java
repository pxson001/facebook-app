package com.facebook.prefetch.feed.scheduler;

import android.content.Context;
import android.content.Intent;
import com.facebook.debug.log.BLog;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.UltralightRuntime;
import com.google.android.gms.gcm.GcmTaskService;
import com.google.android.gms.gcm.TaskParams;
import javax.inject.Provider;

/* compiled from: no_fetch_needed */
public class NewsFeedPrefetchGCMService extends GcmTaskService {
    private static final String f7091b = NewsFeedPrefetchGCMService.class.getName();
    @Inject
    public volatile Provider<NewsFeedPrefetchInvoker> f7092a = UltralightRuntime.a;

    private static <T extends Context> void m7412a(Class<T> cls, T t) {
        m7413a((Object) t, (Context) t);
    }

    public static void m7413a(Object obj, Context context) {
        ((NewsFeedPrefetchGCMService) obj).f7092a = IdBasedProvider.a(FbInjector.get(context), 9666);
    }

    public void onCreate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_SERVICE_START, -38817002);
        super.onCreate();
        Class cls = NewsFeedPrefetchGCMService.class;
        m7413a((Object) this, (Context) this);
        Logger.a(2, EntryType.LIFECYCLE_SERVICE_END, -1716027652, a);
    }

    public final int m7415a(TaskParams taskParams) {
        ((NewsFeedPrefetchInvoker) this.f7092a.get()).a();
        return 0;
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        int i3 = 2;
        int a = Logger.a(2, EntryType.LIFECYCLE_SERVICE_START, -584254184);
        if (intent == null) {
            try {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Received a null intent, did you ever return START_STICKY?");
                Logger.a(2, EntryType.LIFECYCLE_SERVICE_END, 71566895, a);
                throw illegalArgumentException;
            } catch (Throwable e) {
                BLog.a(f7091b, e, "Unexpected service start parameters", new Object[0]);
                stopSelf(i2);
                LogUtils.d(-1790534385, a);
            }
        } else {
            i3 = super.onStartCommand(intent, i, i2);
            LogUtils.d(1810076021, a);
            return i3;
        }
    }

    private void m7414a(Provider<NewsFeedPrefetchInvoker> provider) {
        this.f7092a = provider;
    }
}

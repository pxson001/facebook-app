package com.facebook.api.feedcache.resync;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.facebook.api.feed.xconfig.AsyncFeedXConfigReader;
import com.facebook.common.jobscheduler.compat.DisabledServiceWorkaround;
import com.facebook.debug.log.BLog;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.gcm.GcmNetworkManager;
import com.google.android.gms.gcm.GcmTaskService;
import com.google.android.gms.gcm.OneoffTask.Builder;
import com.google.android.gms.gcm.TaskParams;
import javax.inject.Inject;

/* compiled from: messenger_media_upload */
public class NewsFeedCacheInvalidationGCMService extends GcmTaskService {
    private Context f7968a;
    private NewsFeedCacheInvalidator f7969b;
    private NewsFeedCacheSyncPreRunChecker f7970c;
    private AsyncFeedXConfigReader f7971d;

    private static <T extends Context> void m8297a(Class<T> cls, T t) {
        m8298a((Object) t, (Context) t);
    }

    public static void m8298a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((NewsFeedCacheInvalidationGCMService) obj).m8296a((Context) fbInjector.getInstance(Context.class), NewsFeedCacheInvalidator.a(fbInjector), NewsFeedCacheSyncPreRunChecker.a(fbInjector), AsyncFeedXConfigReader.a(fbInjector));
    }

    public static void m8295a(Context context, long j) {
        GoogleApiAvailability.a();
        if (GoogleApiAvailability.a(context) == 0) {
            if (j < 60) {
                j = 60;
            }
            try {
                GcmNetworkManager.a(context).a(new Builder().a(NewsFeedCacheInvalidationGCMService.class).a("NewsFeedCacheInvalidationGCMService").a(j, 30 + j).a(0).b(true).c(true).a(false).b());
            } catch (Throwable e) {
                BLog.b("NewsFeedCacheInvalidationGCMService", e, "GcmNetworkManager bug, packageManager cannot find the registered component", new Object[0]);
            } catch (Throwable e2) {
                BLog.b("NewsFeedCacheInvalidationGCMService", e2, "Unexpected Security Exception. Nothing to be done! Check t8784969", new Object[0]);
            }
        }
    }

    public static void m8294a(Context context) {
        try {
            GcmNetworkManager.a(context).a(NewsFeedCacheInvalidationGCMService.class);
        } catch (IllegalArgumentException e) {
            DisabledServiceWorkaround.m7416a(context, new ComponentName(context, "NewsFeedCacheInvalidationGCMService"), e);
        } catch (Throwable e2) {
            BLog.b("NewsFeedCacheInvalidationGCMService", e2, "Unexpected Security Exception. Nothing to be done! Check t8784969", new Object[0]);
        }
    }

    @Inject
    private void m8296a(Context context, NewsFeedCacheInvalidator newsFeedCacheInvalidator, NewsFeedCacheSyncPreRunChecker newsFeedCacheSyncPreRunChecker, AsyncFeedXConfigReader asyncFeedXConfigReader) {
        this.f7969b = newsFeedCacheInvalidator;
        this.f7970c = newsFeedCacheSyncPreRunChecker;
        this.f7968a = context;
        this.f7971d = asyncFeedXConfigReader;
    }

    public void onCreate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_SERVICE_START, 1532034334);
        Class cls = NewsFeedCacheInvalidationGCMService.class;
        m8298a((Object) this, (Context) this);
        Logger.a(2, EntryType.LIFECYCLE_SERVICE_END, -2091838428, a);
    }

    public final int m8299a(TaskParams taskParams) {
        Object obj;
        NewsFeedCacheSyncPreRunChecker newsFeedCacheSyncPreRunChecker = this.f7970c;
        if (!newsFeedCacheSyncPreRunChecker.c()) {
            obj = 2;
        } else if (newsFeedCacheSyncPreRunChecker.b()) {
            obj = null;
        } else {
            obj = 1;
        }
        Object obj2 = obj;
        if (2 == obj2) {
            return 2;
        }
        if (1 == obj2) {
            return 1;
        }
        if (!this.f7969b.a()) {
            return 2;
        }
        m8295a(this.f7968a, ((long) this.f7971d.e(60)) * 60);
        return 0;
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        int i3 = 2;
        int a = Logger.a(2, EntryType.LIFECYCLE_SERVICE_START, 1003495899);
        if (intent == null) {
            try {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Received a null intent, did you ever return START_STICKY?");
                Logger.a(2, EntryType.LIFECYCLE_SERVICE_END, 1327289791, a);
                throw illegalArgumentException;
            } catch (Throwable e) {
                BLog.a("NewsFeedCacheInvalidationGCMService", e, "Unexpected service start parameters", new Object[0]);
                stopSelf(i2);
                LogUtils.d(1802472291, a);
            }
        } else {
            i3 = super.onStartCommand(intent, i, i2);
            LogUtils.d(169398322, a);
            return i3;
        }
    }
}

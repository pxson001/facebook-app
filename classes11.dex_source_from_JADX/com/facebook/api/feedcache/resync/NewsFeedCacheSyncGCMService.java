package com.facebook.api.feedcache.resync;

import android.content.Context;
import com.facebook.common.jobscheduler.compat.GcmTaskServiceCompat;
import com.facebook.common.jobscheduler.compat.RunJobLogic;
import com.facebook.inject.FbInjector;
import javax.inject.Inject;

/* compiled from: message_button_nux_key */
public class NewsFeedCacheSyncGCMService extends GcmTaskServiceCompat {
    public NewsFeedCacheSynchronizer f5430a;
    public NewsFeedCacheSyncPreRunChecker f5431b;

    /* compiled from: message_button_nux_key */
    class C07111 extends RunJobLogic {
        final /* synthetic */ NewsFeedCacheSyncGCMService f5429a;

        C07111(NewsFeedCacheSyncGCMService newsFeedCacheSyncGCMService) {
            this.f5429a = newsFeedCacheSyncGCMService;
        }

        public final boolean m6648a() {
            if (this.f5429a.f5431b.m6662c()) {
                if (this.f5429a.f5431b.m6661b()) {
                    this.f5429a.f5430a.m6675a();
                } else {
                    this.f5429a.f5430a.m6676b();
                }
            }
            return false;
        }

        public final boolean m6649b() {
            return false;
        }
    }

    private static <T extends Context> void m6652a(Class<T> cls, T t) {
        m6653a((Object) t, (Context) t);
    }

    public static void m6653a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((NewsFeedCacheSyncGCMService) obj).m6651a(NewsFeedCacheSynchronizer.m6673a(fbInjector), NewsFeedCacheSyncPreRunChecker.m6659a(fbInjector));
    }

    @Inject
    private void m6651a(NewsFeedCacheSynchronizer newsFeedCacheSynchronizer, NewsFeedCacheSyncPreRunChecker newsFeedCacheSyncPreRunChecker) {
        this.f5430a = newsFeedCacheSynchronizer;
        this.f5431b = newsFeedCacheSyncPreRunChecker;
    }

    protected final RunJobLogic m6655a() {
        Class cls = NewsFeedCacheSyncGCMService.class;
        m6653a((Object) this, (Context) this);
        return new C07111(this);
    }
}

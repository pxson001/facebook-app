package com.facebook.api.feedcache.resync;

import com.facebook.common.jobscheduler.compat.JobServiceCompat;
import com.facebook.common.jobscheduler.compat.RunJobLogic;
import com.facebook.inject.FbInjector;

/* compiled from: menu_share_new_post_press */
public class NewsFeedCacheSyncLollipopService extends JobServiceCompat {
    protected final RunJobLogic m6658a() {
        FbInjector fbInjector = FbInjector.get(this);
        final NewsFeedCacheSynchronizer a = NewsFeedCacheSynchronizer.m6673a(fbInjector);
        final NewsFeedCacheSyncPreRunChecker a2 = NewsFeedCacheSyncPreRunChecker.m6659a(fbInjector);
        return new RunJobLogic(this) {
            final /* synthetic */ NewsFeedCacheSyncLollipopService f5434c;

            public final boolean m6656a() {
                if (a2.m6662c()) {
                    if (a2.m6661b()) {
                        a.m6675a();
                    } else {
                        a.m6676b();
                    }
                }
                return false;
            }

            public final boolean m6657b() {
                return false;
            }
        };
    }
}

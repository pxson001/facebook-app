package com.facebook.dialtone.cachemanager;

import android.os.Bundle;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.events.data.EventsDatabaseSupplier;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.zero.common.constants.DialtonePrefKeys;

/* compiled from: The field 'newSenderStatus' has been assigned the invalid value  */
class DialtoneCacheManagerStateChangedListener$1 implements Runnable {
    final /* synthetic */ DialtoneCacheManagerStateChangedListener f24218a;

    DialtoneCacheManagerStateChangedListener$1(DialtoneCacheManagerStateChangedListener dialtoneCacheManagerStateChangedListener) {
        this.f24218a = dialtoneCacheManagerStateChangedListener;
    }

    public void run() {
        DialtoneCacheManager dialtoneCacheManager = (DialtoneCacheManager) this.f24218a.b.get();
        if (dialtoneCacheManager.f24210b.a(DialtonePrefKeys.v, true)) {
            dialtoneCacheManager.f24214f.clearUserData();
            Bundle bundle = new Bundle();
            bundle.putBoolean("clearCacheResetFeedLoader", true);
            BlueServiceOperationFactoryDetour.a(dialtoneCacheManager.f24209a, "feed_clear_cache", bundle, ErrorPropagation.BY_ERROR_CODE, CallerContext.a(dialtoneCacheManager.getClass()), -783978364).a(true).a();
            dialtoneCacheManager.f24213e.m861b();
            dialtoneCacheManager.f24211c.d();
            dialtoneCacheManager.f24212d.d();
            dialtoneCacheManager.f24215g.e();
            ((EventsDatabaseSupplier) dialtoneCacheManager.f24217i.get()).e();
            dialtoneCacheManager.f24216h.e();
            dialtoneCacheManager.f24210b.edit().putBoolean(DialtonePrefKeys.v, false).commit();
        }
    }
}

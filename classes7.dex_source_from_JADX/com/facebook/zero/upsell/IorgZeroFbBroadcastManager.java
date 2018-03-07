package com.facebook.zero.upsell;

import android.content.Intent;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.CrossProcessFbBroadcastManager;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: was_foreground */
public class IorgZeroFbBroadcastManager {
    private final BaseFbBroadcastManager f258a;

    public static IorgZeroFbBroadcastManager m255b(InjectorLike injectorLike) {
        return new IorgZeroFbBroadcastManager((BaseFbBroadcastManager) CrossProcessFbBroadcastManager.a(injectorLike));
    }

    @Inject
    public IorgZeroFbBroadcastManager(BaseFbBroadcastManager baseFbBroadcastManager) {
        this.f258a = baseFbBroadcastManager;
    }

    public final void m256a(Intent intent) {
        this.f258a.a(intent);
    }
}

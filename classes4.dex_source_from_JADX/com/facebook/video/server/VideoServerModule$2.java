package com.facebook.video.server;

import com.facebook.common.statfs.StatFsHelper;
import com.facebook.common.statfs.StatFsHelper.StorageType;
import javax.inject.Provider;

/* compiled from: page_swipe */
final class VideoServerModule$2 implements Provider<Boolean> {
    final /* synthetic */ StatFsHelper f5398a;

    VideoServerModule$2(StatFsHelper statFsHelper) {
        this.f5398a = statFsHelper;
    }

    public final Object get() {
        return Boolean.valueOf(this.f5398a.a(StorageType.INTERNAL) > 5242880);
    }
}

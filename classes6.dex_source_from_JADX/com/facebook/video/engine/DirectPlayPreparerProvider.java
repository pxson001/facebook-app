package com.facebook.video.engine;

import android.net.Uri;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.ListeningExecutorService_VideoPerformanceExecutorMethodAutoProvider;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.video.server.PlayerReadableCacheMethodAutoProvider;
import com.facebook.video.server.VideoResourceMetadata;
import com.facebook.video.server.VideoServerMethodAutoProvider;

/* compiled from: compost_draft_db */
public class DirectPlayPreparerProvider extends AbstractAssistedProvider<DirectPlayPreparer> {
    public final DirectPlayPreparer m27507a(VideoResourceMetadata videoResourceMetadata, Uri uri) {
        return new DirectPlayPreparer(videoResourceMetadata, uri, DefaultAndroidThreadUtil.b(this), VideoServerMethodAutoProvider.a(this), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(this), (QeAccessor) QeInternalImplMethodAutoProvider.a(this), GatekeeperStoreImplMethodAutoProvider.a(this), PlayerReadableCacheMethodAutoProvider.m28241a(this), ListeningExecutorService_VideoPerformanceExecutorMethodAutoProvider.a(this));
    }
}

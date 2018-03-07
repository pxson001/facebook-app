package com.facebook.timeline.header.controllers;

import android.app.Activity;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.ipc.profile.TimelineContext;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.timeline.header.data.TimelineHeaderUserData;
import com.facebook.timeline.header.editphotohelper.TimelineEditPhotoHelper;
import com.facebook.timeline.logging.TimelineAnalyticsLogger;
import com.facebook.timeline.profilemedia.ProfileMediaChangeBroadcaster;
import com.google.common.base.Supplier;
import java.util.concurrent.Executor;

/* compiled from: first_factor */
public class TimelineProfileImageControllerImplProvider extends AbstractAssistedProvider<TimelineProfileImageControllerImpl> {
    public final TimelineProfileImageControllerImpl m11707a(Activity activity, TimelineAnalyticsLogger timelineAnalyticsLogger, TimelineContext timelineContext, Supplier<TimelineEditPhotoHelper> supplier, TimelineHeaderUserData timelineHeaderUserData) {
        return new TimelineProfileImageControllerImpl(activity, timelineAnalyticsLogger, timelineContext, supplier, timelineHeaderUserData, IdBasedProvider.a(this, 9351), IdBasedSingletonScopeProvider.a(this, 9346), IdBasedLazy.a(this, 11267), IdBasedSingletonScopeProvider.a(this, 968), IdBasedLazy.a(this, 3588), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(this), (QeAccessor) QeInternalImplMethodAutoProvider.a(this), ProfileMediaChangeBroadcaster.a(this));
    }
}

package com.facebook.timeline.header.editphotohelper;

import com.facebook.common.executors.Handler_ForUiThreadMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.AbstractAssistedProvider;
import com.google.common.base.Supplier;

/* compiled from: upload_status */
public class ProfilePictureActionFlowLauncherProvider extends AbstractAssistedProvider<ProfilePictureActionFlowLauncher> {
    public final ProfilePictureActionFlowLauncher m877a(Supplier<TimelineEditPhotoHelper> supplier) {
        return new ProfilePictureActionFlowLauncher(supplier, Handler_ForUiThreadMethodAutoProvider.b(this), (Clock) SystemClockMethodAutoProvider.a(this));
    }
}

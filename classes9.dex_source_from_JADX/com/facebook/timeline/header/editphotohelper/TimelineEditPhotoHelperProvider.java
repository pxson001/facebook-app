package com.facebook.timeline.header.editphotohelper;

import android.support.v4.app.Fragment;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.ipc.profile.profilevideo.ProfileVideoPreviewLauncher;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.timeline.profilevideo.ProfileVideoPreviewLauncherImpl;

/* compiled from: upload_profile_pic */
public class TimelineEditPhotoHelperProvider extends AbstractAssistedProvider<TimelineEditPhotoHelper> {
    public final TimelineEditPhotoHelper m886a(Long l, Fragment fragment, int i) {
        return new TimelineEditPhotoHelper(l, fragment, i, (QeAccessor) QeInternalImplMethodAutoProvider.a(this), IdBasedSingletonScopeProvider.a(this, 2347), IdBasedSingletonScopeProvider.a(this, 968), IdBasedProvider.a(this, 372), IdBasedLazy.a(this, 11305), IdBasedLazy.a(this, 11301), (ProfileVideoPreviewLauncher) ProfileVideoPreviewLauncherImpl.b(this), (AbstractFbErrorReporter) FbErrorReporterImpl.a(this), IdBasedLazy.a(this, 11303));
    }
}

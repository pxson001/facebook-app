package com.facebook.platform.composer.publish;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.network.FbDataConnectionManager;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.composer.publish.helpers.OptimisticPostHelper;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.photos.base.media.MediaItemFactory;
import com.facebook.photos.tagging.store.FaceBoxStore;
import com.facebook.photos.tagging.store.TagStore;
import com.facebook.photos.upload.manager.UploadManager;
import com.facebook.photos.upload.operation.UploadOperationFactory;
import com.facebook.platform.composer.model.PlatformComposerModel;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.spherical.photo.abtest.Photos360QEHelper;
import com.facebook.ui.toaster.Toaster;
import com.facebook.user.model.User;

/* compiled from: results_module_type */
public class PublishShareHelperProvider extends AbstractAssistedProvider<PublishShareHelper> {
    public final PublishShareHelper m4212a(PlatformComposerModel platformComposerModel, User user, long j, OptimisticPostHelper optimisticPostHelper) {
        return new PublishShareHelper(platformComposerModel, user, j, optimisticPostHelper, FbDataConnectionManager.a(this), (Clock) SystemClockMethodAutoProvider.a(this), TagStore.a(this), FaceBoxStore.a(this), Toaster.a(this), (FbSharedPreferences) FbSharedPreferencesImpl.a(this), UploadManager.a(this), UploadOperationFactory.a(this), (AbstractFbErrorReporter) FbErrorReporterImpl.a(this), MediaItemFactory.a(this), Photos360QEHelper.a(this));
    }
}

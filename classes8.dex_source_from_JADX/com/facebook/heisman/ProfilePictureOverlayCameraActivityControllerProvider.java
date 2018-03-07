package com.facebook.heisman;

import android.app.Activity;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.heisman.intent.ProfilePictureOverlayCameraIntentData;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.base.media.MediaItemFactory;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.timeline.profilevideo.ProfileVideoPreviewLauncherImpl;
import java.util.concurrent.Executor;

/* compiled from: version_request */
public class ProfilePictureOverlayCameraActivityControllerProvider extends AbstractAssistedProvider<ProfilePictureOverlayCameraActivityController> {
    public final ProfilePictureOverlayCameraActivityController m741a(Activity activity, ProfilePictureOverlayCameraIntentData profilePictureOverlayCameraIntentData) {
        ProfilePictureOverlayCameraActivityController profilePictureOverlayCameraActivityController = new ProfilePictureOverlayCameraActivityController(activity, profilePictureOverlayCameraIntentData);
        profilePictureOverlayCameraActivityController.m736a(IdBasedSingletonScopeProvider.a(this, 2436), ProfilePictureOverlayCameraModelStore.m761a((InjectorLike) this), ProfilePictureOverlayActivityLauncher.m648a(this), ProfilePictureOverlayCameraToolbarBinder.m774a(this), ProfilePictureOverlayCameraQueryExecutor.m765a((InjectorLike) this), ProfilePictureOverlayIntentFactory.m784a(this), ProfilePictureOverlayAnalyticsLogger.m653a((InjectorLike) this), (SecureContextHelper) DefaultSecureContextHelper.a(this), IdBasedSingletonScopeProvider.b(this, 494), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(this), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(this), MediaItemFactory.a(this), (QeAccessor) QeInternalImplMethodAutoProvider.a(this), ProfileVideoPreviewLauncherImpl.m11077a((InjectorLike) this), ProfilePictureOverlayExpirationTimeConfig.m780a((InjectorLike) this));
        return profilePictureOverlayCameraActivityController;
    }
}

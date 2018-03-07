package com.facebook.friendsharing.suggestedcoverphotos;

import android.app.Activity;
import com.facebook.auth.module.String_LoggedInUserIdMethodAutoProvider;
import com.facebook.common.executors.C0055x2995691a;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.friendsharing.suggestedcoverphotos.analytics.SuggestedCoverPhotosLogger;
import com.facebook.imagepipeline.module.ImagePipelineMethodAutoProvider;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.base.media.MediaItemFactory;
import com.facebook.photos.sharing.TempBinaryFileManager;
import com.facebook.productionprompts.logging.PromptAnalytics;
import com.facebook.timeline.coverphoto.activity.CoverPhotoRepositionActivityLauncherProvider;
import com.facebook.ui.toaster.Toaster;

/* compiled from: modify_backstack_override */
public class SuggestedCoverPhotoEditHelperProvider extends AbstractAssistedProvider<SuggestedCoverPhotoEditHelper> {
    public final SuggestedCoverPhotoEditHelper m19695a(Activity activity, String str, PromptAnalytics promptAnalytics) {
        return new SuggestedCoverPhotoEditHelper(activity, str, promptAnalytics, ImagePipelineMethodAutoProvider.m15546a(this), TempBinaryFileManager.a(this), C0055x2995691a.m1881a(this), ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.m1951a(this), MediaItemFactory.m19668b((InjectorLike) this), (CoverPhotoRepositionActivityLauncherProvider) getOnDemandAssistedProviderForStaticDi(CoverPhotoRepositionActivityLauncherProvider.class), String_LoggedInUserIdMethodAutoProvider.m4329b(this), Toaster.m6454b((InjectorLike) this), SuggestedCoverPhotosLogger.m19697b(this));
    }
}

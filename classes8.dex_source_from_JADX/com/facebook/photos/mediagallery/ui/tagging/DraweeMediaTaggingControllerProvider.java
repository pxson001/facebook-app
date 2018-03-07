package com.facebook.photos.mediagallery.ui.tagging;

import android.widget.FrameLayout;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.galleryutil.events.ConsumptionPhotoEventBus;
import com.facebook.photos.mediagallery.mutation.MediaMutationGenerator;
import com.facebook.photos.mediagallery.ui.widget.GalleryDraweeView;
import com.facebook.photos.tagging.shared.logging.TaggingAnalyticHelper;
import com.facebook.ui.futures.TasksManager;

/* compiled from: sms_auto_confirm_attempt */
public class DraweeMediaTaggingControllerProvider extends AbstractAssistedProvider<DraweeMediaTaggingController> {
    public final DraweeMediaTaggingController m2594a(FrameLayout frameLayout, GalleryDraweeView galleryDraweeView, int i, String str, String str2) {
        return new DraweeMediaTaggingController(frameLayout, galleryDraweeView, i, str, str2, TagToFaceBoxMapper.m2641a((InjectorLike) this), TaggingStateController.m2663a((InjectorLike) this), MediaMutationGenerator.a(this), (TagsViewProvider) getOnDemandAssistedProviderForStaticDi(TagsViewProvider.class), (TaggingIntentControllerProvider) getOnDemandAssistedProviderForStaticDi(TaggingIntentControllerProvider.class), IdBasedLazy.a(this, 9252), (DraweeTypeaheadControllerProvider) getOnDemandAssistedProviderForStaticDi(DraweeTypeaheadControllerProvider.class), TasksManager.a(this), ConsumptionPhotoEventBus.a(this), TaggingAnalyticHelper.a(this));
    }
}

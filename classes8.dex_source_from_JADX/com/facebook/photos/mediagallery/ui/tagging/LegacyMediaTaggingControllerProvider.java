package com.facebook.photos.mediagallery.ui.tagging;

import android.widget.FrameLayout;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.galleryutil.events.ConsumptionPhotoEventBus;
import com.facebook.photos.mediagallery.mutation.MediaMutationGenerator;
import com.facebook.photos.tagging.shared.logging.TaggingAnalyticHelper;
import com.facebook.ui.futures.TasksManager;
import com.facebook.widget.images.zoomableimageview.ZoomableView;

/* compiled from: slideshow_preview_reorder */
public class LegacyMediaTaggingControllerProvider extends AbstractAssistedProvider<LegacyMediaTaggingController> {
    public final LegacyMediaTaggingController m2622a(FrameLayout frameLayout, ZoomableView zoomableView, int i, String str, String str2) {
        return new LegacyMediaTaggingController(frameLayout, zoomableView, i, str, str2, TagToFaceBoxMapper.m2641a((InjectorLike) this), TaggingStateController.m2663a((InjectorLike) this), MediaMutationGenerator.a(this), (TagsViewProvider) getOnDemandAssistedProviderForStaticDi(TagsViewProvider.class), (TaggingIntentControllerProvider) getOnDemandAssistedProviderForStaticDi(TaggingIntentControllerProvider.class), IdBasedLazy.a(this, 9252), (LegacyTypeaheadControllerProvider) getOnDemandAssistedProviderForStaticDi(LegacyTypeaheadControllerProvider.class), TasksManager.a(this), ConsumptionPhotoEventBus.a(this), TaggingAnalyticHelper.a(this));
    }
}

package com.facebook.photos.mediagallery.ui.tagging;

import android.graphics.Matrix;
import android.widget.FrameLayout;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.photos.base.analytics.MediaLogger;
import com.facebook.photos.galleryutil.events.ConsumptionPhotoEventBus;
import com.facebook.photos.mediagallery.mutation.MediaMutationGenerator;
import com.facebook.photos.tagging.shared.logging.TaggingAnalyticHelper;
import com.facebook.ui.futures.TasksManager;
import com.facebook.widget.images.zoomableimageview.ZoomableView;
import javax.inject.Inject;

/* compiled from: slideshow_preview_save */
public class LegacyMediaTaggingController extends MediaTaggingController {
    private final ZoomableView f2489c;
    private final LegacyTypeaheadControllerProvider f2490d;

    @Inject
    public LegacyMediaTaggingController(@Assisted FrameLayout frameLayout, @Assisted ZoomableView zoomableView, @Assisted int i, @Assisted String str, @Assisted String str2, TagToFaceBoxMapper tagToFaceBoxMapper, TaggingStateController taggingStateController, MediaMutationGenerator mediaMutationGenerator, TagsViewProvider tagsViewProvider, TaggingIntentControllerProvider taggingIntentControllerProvider, Lazy<MediaLogger> lazy, LegacyTypeaheadControllerProvider legacyTypeaheadControllerProvider, TasksManager tasksManager, ConsumptionPhotoEventBus consumptionPhotoEventBus, TaggingAnalyticHelper taggingAnalyticHelper) {
        super(frameLayout, tagToFaceBoxMapper, i, str, str2, taggingStateController, mediaMutationGenerator, tagsViewProvider, taggingIntentControllerProvider, lazy, tasksManager, consumptionPhotoEventBus, taggingAnalyticHelper);
        this.f2489c = zoomableView;
        this.f2489c.a(m2590i());
        this.f2490d = legacyTypeaheadControllerProvider;
    }

    final TypeaheadController mo120a() {
        return this.f2490d.m2630a(this.f2489c, this.f2463p, this.f2464q, this.f2458k);
    }

    final void mo121b() {
        Matrix imageMatrix = this.f2489c.getImageMatrix();
        if (this.f2489c.e() && imageMatrix != null) {
            boolean z;
            this.f2448a.a(this.f2489c.getPhotoWidth(), this.f2489c.getPhotoHeight(), this.f2489c.getImageMatrix());
            TagsView tagsView = this.f2449b;
            if (this.f2489c.getScale() > this.f2489c.getMinZoom()) {
                z = true;
            } else {
                z = false;
            }
            tagsView.f2570b.a(this.f2489c, z);
        }
    }

    final boolean mo122c() {
        return this.f2489c.e();
    }
}

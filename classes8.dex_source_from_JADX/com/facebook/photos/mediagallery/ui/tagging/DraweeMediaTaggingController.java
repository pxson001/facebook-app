package com.facebook.photos.mediagallery.ui.tagging;

import android.graphics.Matrix;
import android.widget.FrameLayout;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.photos.base.analytics.MediaLogger;
import com.facebook.photos.galleryutil.events.ConsumptionPhotoEventBus;
import com.facebook.photos.mediagallery.mutation.MediaMutationGenerator;
import com.facebook.photos.mediagallery.ui.widget.GalleryDraweeView;
import com.facebook.photos.tagging.shared.logging.TaggingAnalyticHelper;
import com.facebook.samples.zoomable.AnimatedZoomableController;
import com.facebook.ui.futures.TasksManager;
import javax.inject.Inject;

/* compiled from: sms_auto_confirm_detected */
public class DraweeMediaTaggingController extends MediaTaggingController {
    private final DraweeTypeaheadControllerProvider f2466c;
    private final GalleryDraweeView f2467d;
    private final Matrix f2468e = new Matrix();

    @Inject
    public DraweeMediaTaggingController(@Assisted FrameLayout frameLayout, @Assisted GalleryDraweeView galleryDraweeView, @Assisted int i, @Assisted String str, @Assisted String str2, TagToFaceBoxMapper tagToFaceBoxMapper, TaggingStateController taggingStateController, MediaMutationGenerator mediaMutationGenerator, TagsViewProvider tagsViewProvider, TaggingIntentControllerProvider taggingIntentControllerProvider, Lazy<MediaLogger> lazy, DraweeTypeaheadControllerProvider draweeTypeaheadControllerProvider, TasksManager tasksManager, ConsumptionPhotoEventBus consumptionPhotoEventBus, TaggingAnalyticHelper taggingAnalyticHelper) {
        super(frameLayout, tagToFaceBoxMapper, i, str, str2, taggingStateController, mediaMutationGenerator, tagsViewProvider, taggingIntentControllerProvider, lazy, tasksManager, consumptionPhotoEventBus, taggingAnalyticHelper);
        this.f2466c = draweeTypeaheadControllerProvider;
        this.f2467d = galleryDraweeView;
        this.f2467d.m2703a(m2590i());
    }

    final TypeaheadController mo120a() {
        return this.f2466c.m2615a(this.f2467d, this.f2463p, this.f2464q, this.f2458k);
    }

    final void mo121b() {
        boolean z;
        AnimatedZoomableController zoomableController = this.f2467d.getZoomableController();
        zoomableController.a(this.f2468e);
        this.f2448a.setDraweeMatrix(this.f2468e);
        TagsView tagsView = this.f2449b;
        if (zoomableController.m() > zoomableController.i) {
            z = true;
        } else {
            z = false;
        }
        tagsView.f2570b.a(zoomableController, z);
    }

    final boolean mo122c() {
        return this.f2467d.getZoomableController().j();
    }
}

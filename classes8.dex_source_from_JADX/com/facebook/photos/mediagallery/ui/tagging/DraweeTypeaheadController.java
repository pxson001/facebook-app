package com.facebook.photos.mediagallery.ui.tagging;

import android.graphics.Matrix;
import android.graphics.PointF;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.photos.mediagallery.ui.widget.GalleryDraweeView;
import com.facebook.photos.tagging.shared.TypeaheadAnimationHelper;
import com.facebook.photos.tagging.shared.TypeaheadAnimationHelper.SelectedFaceParams;
import com.facebook.qe.api.QeAccessor;
import com.facebook.samples.zoomable.AnimatedZoomableController;
import com.facebook.tagging.data.TagTypeaheadDataSource;
import com.facebook.tagging.graphql.data.GoodFriendsTaggingTypeaheadDataSource;
import com.facebook.tagging.graphql.data.GroupMembersTaggingTypeaheadDataSourceProvider;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: slideshow_removed */
public class DraweeTypeaheadController extends TypeaheadController {
    private final GalleryDraweeView f2484k;
    private final PointF f2485l = new PointF();
    private final Matrix f2486m = new Matrix();

    @Inject
    public DraweeTypeaheadController(@Assisted GalleryDraweeView galleryDraweeView, @Assisted int i, @Assisted String str, @Assisted String str2, TypeaheadAnimationHelper typeaheadAnimationHelper, FaceBoxInfoUtils faceBoxInfoUtils, TaggingProfileFactory taggingProfileFactory, Lazy<TagTypeaheadDataSource> lazy, DefaultSuggestionController defaultSuggestionController, GroupMembersTaggingTypeaheadDataSourceProvider groupMembersTaggingTypeaheadDataSourceProvider, Lazy<GoodFriendsTaggingTypeaheadDataSource> lazy2, QeAccessor qeAccessor) {
        super(typeaheadAnimationHelper, faceBoxInfoUtils, taggingProfileFactory, lazy, defaultSuggestionController, i, str, str2, groupMembersTaggingTypeaheadDataSourceProvider, lazy2, qeAccessor);
        this.f2484k = galleryDraweeView;
    }

    final SelectedFaceParams mo123a() {
        return this.f2469a.a(this.f2484k.getZoomableController(), this.f2475g);
    }

    final SelectedFaceParams mo125b() {
        return this.f2469a.a(this.f2484k.getZoomableController());
    }

    public final void mo124a(@Nullable Runnable runnable, boolean z) {
        this.f2485l.set(this.f2475g.centerX(), this.f2475g.centerY());
        this.f2484k.getZoomableController().a(this.f2470b.a, this.f2485l, this.f2477i, 5, 300, runnable);
    }

    public final void mo126c() {
        this.f2484k.getZoomableController().a(this.f2471c, 300, null);
    }

    final void mo127d() {
        this.f2471c.set(this.f2484k.getZoomableController().p());
    }

    final void mo128e() {
        AnimatedZoomableController zoomableController = this.f2484k.getZoomableController();
        zoomableController.a(this.f2486m);
        this.f2486m.mapRect(this.f2476h, this.f2475g);
        this.e = ((float) Math.hypot((double) this.f2476h.width(), (double) this.f2476h.height())) / 2.0f;
        this.d = new PointF(this.f2476h.centerX(), this.f2476h.centerY());
        PointF pointF = this.f2472d;
        SelectedFaceParams selectedFaceParams = this.f2470b;
        float width = zoomableController.k.width();
        float width2 = zoomableController.l.width();
        this.i = TypeaheadAnimationHelper.a(pointF, selectedFaceParams, width, width2, width / zoomableController.k.height() <= width2 / zoomableController.l.height());
    }
}

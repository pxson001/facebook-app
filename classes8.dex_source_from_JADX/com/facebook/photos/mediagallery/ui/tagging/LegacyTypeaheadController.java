package com.facebook.photos.mediagallery.ui.tagging;

import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.PointF;
import android.graphics.RectF;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.photos.tagging.shared.TypeaheadAnimationHelper;
import com.facebook.photos.tagging.shared.TypeaheadAnimationHelper.SelectedFaceParams;
import com.facebook.qe.api.QeAccessor;
import com.facebook.tagging.data.TagTypeaheadDataSource;
import com.facebook.tagging.graphql.data.GoodFriendsTaggingTypeaheadDataSource;
import com.facebook.tagging.graphql.data.GroupMembersTaggingTypeaheadDataSourceProvider;
import com.facebook.widget.images.zoomableimageview.ZoomableView;
import com.facebook.widget.images.zoomableimageview.ZoomableView.ZoomableImageViewZoomAndPanListener;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: slideshow_preview_play */
public class LegacyTypeaheadController extends TypeaheadController {
    public final ZoomableView f2493k;
    private float f2494l;

    @Inject
    public LegacyTypeaheadController(@Assisted ZoomableView zoomableView, @Assisted int i, @Assisted String str, @Assisted String str2, TypeaheadAnimationHelper typeaheadAnimationHelper, FaceBoxInfoUtils faceBoxInfoUtils, TaggingProfileFactory taggingProfileFactory, Lazy<TagTypeaheadDataSource> lazy, DefaultSuggestionController defaultSuggestionController, GroupMembersTaggingTypeaheadDataSourceProvider groupMembersTaggingTypeaheadDataSourceProvider, Lazy<GoodFriendsTaggingTypeaheadDataSource> lazy2, QeAccessor qeAccessor) {
        super(typeaheadAnimationHelper, faceBoxInfoUtils, taggingProfileFactory, lazy, defaultSuggestionController, i, str, str2, groupMembersTaggingTypeaheadDataSourceProvider, lazy2, qeAccessor);
        this.f2493k = zoomableView;
    }

    final SelectedFaceParams mo123a() {
        return this.f2469a.a(this.f2493k, this.f2475g);
    }

    final SelectedFaceParams mo125b() {
        return this.f2469a.a(this.f2493k);
    }

    public final void mo124a(@Nullable final Runnable runnable, boolean z) {
        Preconditions.checkNotNull(this.f2477i);
        Object[] objArr = new Object[]{Float.valueOf(this.f2470b.a), this.f2477i.toString(), this.f2476h, Float.valueOf(this.f2477i.x - this.f2476h.centerX()), Float.valueOf(this.f2477i.y - this.f2476h.centerY())};
        this.f2493k.a(this.f2470b.a, this.f2476h.centerX(), this.f2476h.centerY(), this.f2477i.x - this.f2476h.centerX(), this.f2477i.y - this.f2476h.centerY(), 300);
        if (runnable == null) {
            return;
        }
        if (z) {
            runnable.run();
            return;
        }
        this.f2493k.setZoomAndPanListener(new ZoomableImageViewZoomAndPanListener(this) {
            final /* synthetic */ LegacyTypeaheadController f2492b;

            public final void m2623a() {
                runnable.run();
            }
        });
    }

    public final void mo126c() {
        Preconditions.checkNotNull(this.f2477i);
        RectF a = TypeaheadAnimationHelper.a(this.f2493k, this.f2475g, this.f2471c);
        this.f2493k.a(this.f2494l, this.f2477i.x, this.f2477i.y, a.centerX() - this.f2477i.x, a.centerY() - this.f2477i.y, 300);
    }

    final void mo127d() {
        this.f2494l = this.f2493k.getScale();
        this.c = new Matrix(this.f2493k.getPhotoDisplayMatrix());
        Float.valueOf(this.f2494l);
        this.f2471c.toShortString();
    }

    final void mo128e() {
        Matrix matrix = new Matrix();
        matrix.setRectToRect(new RectF(0.0f, 0.0f, 1.0f, 1.0f), new RectF(0.0f, 0.0f, (float) this.f2493k.getPhotoWidth(), (float) this.f2493k.getPhotoHeight()), ScaleToFit.FILL);
        matrix.mapRect(this.f2476h, this.f2475g);
        PointF pointF = new PointF(this.f2476h.centerX(), this.f2476h.centerY());
        this.f2493k.getPhotoDisplayMatrix().mapRect(this.f2476h);
        this.i = TypeaheadAnimationHelper.a(this.f2493k, pointF, this.f2470b);
        this.f2476h.toShortString();
        this.f2477i.toString();
        this.d = pointF;
        this.e = TypeaheadAnimationHelper.a(this.f2493k.getPhotoWidth(), this.f2493k.getPhotoHeight(), this.f2475g);
    }
}

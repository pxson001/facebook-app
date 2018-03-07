package com.facebook.photos.creativeediting.renderers;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.creativeediting.interfaces.PhotoOverlayItem;
import com.facebook.photos.creativeediting.interfaces.UriAwarePhotoOverlayItem;
import com.facebook.photos.creativeediting.model.CreativeEditingData;
import com.facebook.photos.creativeediting.model.DoodleParams;
import com.facebook.photos.creativeediting.model.StickerParams;
import com.facebook.photos.creativeediting.model.TextParams;
import com.facebook.photos.creativeediting.renderers.CreativeEditingPhotoOverlayView.OverlayViewEventListener;
import com.facebook.photos.creativeediting.utilities.PhotoOverlayObjectMapper;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;

/* compiled from: mStates */
public class PhotoOverlayController implements OverlayViewEventListener {
    private static final RectF f9598b = new RectF(0.0f, 0.0f, 1.0f, 1.0f);
    public final PhotoOverlayItemsRenderer f9599a;

    /* compiled from: mStates */
    public enum OverlayType {
        STICKERS,
        TEXTS,
        DOODLE,
        FACEBOXES,
        TAGS,
        FRAME
    }

    public static PhotoOverlayController m11526b(InjectorLike injectorLike) {
        return new PhotoOverlayController(new PhotoOverlayItemsRenderer(PhotoOverlayObjectMapper.a(injectorLike), (MovableItemContainerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(MovableItemContainerProvider.class)));
    }

    @Inject
    public PhotoOverlayController(PhotoOverlayItemsRenderer photoOverlayItemsRenderer) {
        this.f9599a = photoOverlayItemsRenderer;
    }

    public static PhotoOverlayController m11525a(InjectorLike injectorLike) {
        return m11526b(injectorLike);
    }

    public final void m11529a(CreativeEditingData creativeEditingData, int i, int i2, int i3, View view, boolean z, OverlayType... overlayTypeArr) {
        ImmutableList i4;
        Preconditions.checkNotNull(overlayTypeArr);
        RectF c = (!z || creativeEditingData.c() == null) ? f9598b : creativeEditingData.c();
        Builder builder = new Builder();
        Object obj = null;
        Object obj2 = null;
        Object obj3 = null;
        Object obj4 = null;
        int length = overlayTypeArr.length;
        int i5 = 0;
        while (i5 < length) {
            Object obj5;
            switch (overlayTypeArr[i5]) {
                case STICKERS:
                    Object obj6 = obj4;
                    obj4 = obj2;
                    int i6 = 1;
                    obj5 = obj6;
                    break;
                case TEXTS:
                    obj2 = obj;
                    obj5 = obj4;
                    int i7 = 1;
                    break;
                case DOODLE:
                    int i8 = 1;
                    obj5 = obj4;
                    obj4 = obj2;
                    obj2 = obj;
                    break;
                case FRAME:
                    obj5 = 1;
                    obj4 = obj2;
                    obj2 = obj;
                    break;
                default:
                    obj5 = obj4;
                    obj4 = obj2;
                    obj2 = obj;
                    break;
            }
            i5++;
            obj = obj2;
            obj2 = obj4;
            obj4 = obj5;
        }
        ImmutableList h = creativeEditingData.h();
        int size = h.size();
        for (i5 = 0; i5 < size; i5++) {
            PhotoOverlayItem photoOverlayItem = (PhotoOverlayItem) h.get(i5);
            if ((photoOverlayItem instanceof StickerParams) && obj != null) {
                builder.c((UriAwarePhotoOverlayItem) photoOverlayItem);
            } else if ((photoOverlayItem instanceof TextParams) && obj2 != null) {
                builder.c((UriAwarePhotoOverlayItem) photoOverlayItem);
            } else if ((photoOverlayItem instanceof DoodleParams) && r2 != null) {
                builder.c((UriAwarePhotoOverlayItem) photoOverlayItem);
            }
        }
        ImmutableList b = builder.b();
        if (obj4 != null) {
            i4 = creativeEditingData.i();
        } else {
            i4 = null;
        }
        if ((b != null && !b.isEmpty()) || (i4 != null && !i4.isEmpty())) {
            this.f9599a.m11537a(b, i4, i, i2, i3, c, view);
            this.f9599a.m11535a();
        }
    }

    public final void m11532c() {
        mo500b();
    }

    public final void m11533d() {
        PhotoOverlayItemsRenderer photoOverlayItemsRenderer = this.f9599a;
        photoOverlayItemsRenderer.m11538b();
        photoOverlayItemsRenderer.f9601b.m11523j();
    }

    public final void mo497a() {
        this.f9599a.m11535a();
    }

    public final void mo500b() {
        this.f9599a.m11538b();
    }

    public final void mo498a(Canvas canvas) {
        boolean z;
        PhotoOverlayItemsRenderer photoOverlayItemsRenderer = this.f9599a;
        if (photoOverlayItemsRenderer.f9601b.f9592k == null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        photoOverlayItemsRenderer.f9601b.m11506a(canvas, photoOverlayItemsRenderer.f9607h);
    }

    public final boolean mo499a(Drawable drawable) {
        return this.f9599a.f9601b.m11511a(drawable);
    }
}

package com.facebook.photos.creativeediting.utilities;

import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.PointF;
import android.graphics.RectF;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.creativeediting.interfaces.PhotoOverlayItem;
import com.facebook.photos.creativeediting.interfaces.UriAwarePhotoOverlayItem;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: inContactList */
public class PhotoOverlayObjectMapper {
    private static final RectF f12846a = new RectF(0.0f, 0.0f, 1.0f, 1.0f);
    private final Map<PhotoOverlayItem, PhotoOverlayItem> f12847b = Maps.c();
    public RectF f12848c;
    private final float[] f12849d = new float[2];
    private final Matrix f12850e = new Matrix();
    private int f12851f;

    public static PhotoOverlayObjectMapper m20234a(InjectorLike injectorLike) {
        return new PhotoOverlayObjectMapper();
    }

    @Inject
    public PhotoOverlayObjectMapper() {
        m20238a(f12846a, 0);
    }

    public final void m20238a(RectF rectF, int i) {
        Preconditions.checkNotNull(rectF);
        Preconditions.checkState(f12846a.contains(rectF));
        this.f12848c = rectF;
        this.f12851f = i;
        this.f12850e.setRectToRect(this.f12848c, f12846a, ScaleToFit.FILL);
        this.f12850e.postRotate((float) i, 0.5f, 0.5f);
    }

    @Nullable
    public final PhotoOverlayItem m20236a(PhotoOverlayItem photoOverlayItem) {
        Preconditions.checkNotNull(photoOverlayItem);
        return (PhotoOverlayItem) this.f12847b.get(photoOverlayItem);
    }

    @Nullable
    public final List<? extends PhotoOverlayItem> m20237a(@Nullable List<? extends PhotoOverlayItem> list) {
        this.f12847b.clear();
        List<? extends PhotoOverlayItem> a = Lists.a();
        if (list == null || list.isEmpty()) {
            return null;
        }
        for (PhotoOverlayItem photoOverlayItem : list) {
            if (RectF.intersects(this.f12848c, photoOverlayItem.mo221a())) {
                Object a2;
                this.f12849d[0] = photoOverlayItem.mo223b().x;
                this.f12849d[1] = photoOverlayItem.mo223b().y;
                this.f12850e.mapPoints(this.f12849d);
                if (m20235a() || this.f12851f > 0) {
                    RectF rectF = new RectF();
                    this.f12850e.mapRect(rectF, photoOverlayItem.mo221a());
                    a2 = photoOverlayItem.mo222a(rectF, new PointF(this.f12849d[0], this.f12849d[1]), (photoOverlayItem.mo224c() + ((float) this.f12851f)) % 360.0f);
                } else {
                    PhotoOverlayItem photoOverlayItem2 = photoOverlayItem;
                }
                a.add(a2);
                this.f12847b.put(a2, photoOverlayItem);
            }
        }
        return a;
    }

    public final PhotoOverlayItem m20239b(PhotoOverlayItem photoOverlayItem) {
        if ((photoOverlayItem instanceof UriAwarePhotoOverlayItem) && ((UriAwarePhotoOverlayItem) photoOverlayItem).mo231j()) {
            return photoOverlayItem;
        }
        if (!m20235a() && this.f12851f <= 0) {
            return photoOverlayItem;
        }
        this.f12849d[0] = photoOverlayItem.mo223b().x;
        this.f12849d[1] = photoOverlayItem.mo223b().y;
        this.f12850e.mapPoints(this.f12849d);
        RectF rectF = new RectF();
        this.f12850e.mapRect(rectF, photoOverlayItem.mo221a());
        return photoOverlayItem.mo222a(rectF, new PointF(this.f12849d[0], this.f12849d[1]), (photoOverlayItem.mo224c() + ((float) this.f12851f)) % 360.0f);
    }

    @Nullable
    public final List<? extends PhotoOverlayItem> m20240b(@Nullable List<? extends PhotoOverlayItem> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        List<? extends PhotoOverlayItem> a = Lists.a();
        Matrix matrix = new Matrix();
        this.f12850e.invert(matrix);
        for (PhotoOverlayItem photoOverlayItem : list) {
            int i;
            RectF rectF = new RectF();
            matrix.mapRect(rectF, photoOverlayItem.mo221a());
            this.f12849d[0] = photoOverlayItem.mo223b().x;
            this.f12849d[1] = photoOverlayItem.mo223b().y;
            matrix.mapPoints(this.f12849d);
            if (this.f12851f > 0) {
                i = 360 - this.f12851f;
            } else {
                i = 0;
            }
            a.add(photoOverlayItem.mo222a(rectF, new PointF(this.f12849d[0], this.f12849d[1]), (((float) i) + photoOverlayItem.mo224c()) % 360.0f));
        }
        return a;
    }

    @Nullable
    public final PhotoOverlayItem m20241c(PhotoOverlayItem photoOverlayItem) {
        if (this.f12848c == null) {
            return photoOverlayItem;
        }
        for (Entry entry : this.f12847b.entrySet()) {
            if (entry.getValue() == photoOverlayItem) {
                return (PhotoOverlayItem) entry.getKey();
            }
        }
        return null;
    }

    private boolean m20235a() {
        return (this.f12848c.left == f12846a.left && this.f12848c.top == f12846a.top && this.f12848c.right == f12846a.right && this.f12848c.bottom == f12846a.bottom) ? false : true;
    }
}

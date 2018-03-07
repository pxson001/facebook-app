package com.facebook.photos.creativeediting.renderers;

import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.photos.creativeediting.interfaces.UriAwarePhotoOverlayItem;
import com.facebook.photos.creativeediting.model.StickerParams;
import com.facebook.photos.creativeediting.utilities.PhotoOverlayObjectMapper;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: mStandardEmission */
public class PhotoOverlayItemsRenderer {
    private final PhotoOverlayObjectMapper f9600a;
    public final MovableItemContainer f9601b;
    private boolean f9602c;
    private ImmutableList<UriAwarePhotoOverlayItem> f9603d;
    private ImmutableList<StickerParams> f9604e;
    private RectF f9605f;
    private View f9606g;
    public Rect f9607h;

    @Inject
    public PhotoOverlayItemsRenderer(PhotoOverlayObjectMapper photoOverlayObjectMapper, MovableItemContainerProvider movableItemContainerProvider) {
        this.f9600a = photoOverlayObjectMapper;
        this.f9601b = movableItemContainerProvider.m11524a(this.f9607h);
    }

    public final void m11537a(ImmutableList<UriAwarePhotoOverlayItem> immutableList, ImmutableList<StickerParams> immutableList2, int i, int i2, int i3, RectF rectF, View view) {
        if ((immutableList != null && !immutableList.isEmpty()) || (immutableList2 != null && !immutableList2.isEmpty())) {
            this.f9603d = immutableList;
            this.f9604e = immutableList2;
            this.f9601b.m11523j();
            this.f9605f = rectF;
            this.f9607h = new Rect(0, 0, i, i2);
            this.f9606g = view;
            this.f9601b.m11517c(this.f9607h);
            m11534a(i, i2, i3);
        }
    }

    private void m11534a(int i, int i2, int i3) {
        int i4 = 0;
        if (i2 != 0 && i != 0) {
            int i5;
            if (this.f9605f != null) {
                this.f9600a.a(this.f9605f, i3);
            }
            if (this.f9603d != null) {
                int size = this.f9603d.size();
                for (i5 = 0; i5 < size; i5++) {
                    this.f9601b.m11509a((UriAwarePhotoOverlayItem) this.f9600a.b((UriAwarePhotoOverlayItem) this.f9603d.get(i5)), this.f9606g);
                }
            }
            if (this.f9604e != null) {
                i5 = this.f9604e.size();
                while (i4 < i5) {
                    this.f9601b.m11509a((StickerParams) this.f9604e.get(i4), this.f9606g);
                    i4++;
                }
            }
            this.f9602c = true;
        }
    }

    public final void m11536a(Rect rect, int i) {
        Preconditions.checkNotNull(rect);
        this.f9607h = rect;
        if ((this.f9603d != null && !this.f9603d.isEmpty()) || (this.f9604e != null && !this.f9604e.isEmpty())) {
            if (this.f9602c) {
                MovableItemContainer movableItemContainer = this.f9601b;
                movableItemContainer.f9595n = rect;
                for (UriAwarePhotoOverlayItem uriAwarePhotoOverlayItem : movableItemContainer.f9583b.keySet()) {
                    ((DraweeHolder) movableItemContainer.f9583b.get(uriAwarePhotoOverlayItem)).h().setBounds(uriAwarePhotoOverlayItem.a(rect));
                }
                return;
            }
            m11534a(rect.width(), rect.height(), i);
        }
    }

    public final void m11535a() {
        this.f9601b.m11516c();
    }

    public final void m11538b() {
        this.f9601b.m11519d();
    }
}

package com.facebook.photos.editgallery;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.facebook.inject.FbInjector;
import com.facebook.photos.creativeediting.renderers.MovableItemContainer;
import com.facebook.photos.creativeediting.renderers.MovableItemContainerProvider;
import com.facebook.photos.crop.CropImageOverlay;
import javax.inject.Inject;

/* compiled from: like_attempt_empty_feedback */
public class CropImageOverlayWithFrame extends CropImageOverlay {
    @Inject
    public MovableItemContainerProvider f10217a;
    public final Rect f10218b = new Rect();
    public MovableItemContainer f10219c;

    public static void m12087a(Object obj, Context context) {
        ((CropImageOverlayWithFrame) obj).f10217a = (MovableItemContainerProvider) FbInjector.get(context).getOnDemandAssistedProviderForStaticDi(MovableItemContainerProvider.class);
    }

    public CropImageOverlayWithFrame(Context context, boolean z) {
        super(context, z);
        Class cls = CropImageOverlayWithFrame.class;
        m12087a(this, getContext());
        this.f10219c = this.f10217a.m11524a(this.f10218b);
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || this.f10219c.m11511a(drawable);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f10065c.round(this.f10218b);
        this.f10219c.m11506a(canvas, this.f10218b);
    }
}

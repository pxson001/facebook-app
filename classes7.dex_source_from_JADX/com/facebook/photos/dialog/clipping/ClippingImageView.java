package com.facebook.photos.dialog.clipping;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.facebook.common.io.FbCloseables;
import com.facebook.photos.mediagallery.launcher.animation.DrawingRule;
import java.io.Closeable;
import javax.annotation.Nullable;

/* compiled from: list adapter has not been initialized yet */
public class ClippingImageView extends FrameLayout {
    protected DrawingRule f10128a;
    @Nullable
    protected Drawable f10129b;
    public ClippingAnimationController f10130c = new ClippingAnimationController(this);

    public ClippingImageView(Context context) {
        super(context);
        mo555a();
    }

    public ClippingImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        mo555a();
    }

    public ClippingImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        mo555a();
    }

    protected void mo555a() {
        setWillNotDraw(false);
    }

    public void setDrawable(@Nullable Drawable drawable) {
        mo556a(drawable);
        if (drawable != this.f10129b) {
            if (this.f10129b instanceof Closeable) {
                FbCloseables.a((Closeable) this.f10129b);
            }
            this.f10129b = drawable;
        }
    }

    public void mo557a(DrawingRule drawingRule, DrawingRule drawingRule2) {
    }

    protected void mo556a(Drawable drawable) {
    }

    public final DrawingRule m12001a(DrawingRule drawingRule) {
        DrawingRule drawingRule2 = this.f10128a;
        this.f10128a = drawingRule;
        mo558b(drawingRule2);
        return drawingRule2;
    }

    protected void mo558b(@Nullable DrawingRule drawingRule) {
    }
}

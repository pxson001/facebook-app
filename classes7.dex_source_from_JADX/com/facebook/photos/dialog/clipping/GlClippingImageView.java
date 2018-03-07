package com.facebook.photos.dialog.clipping;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.facebook.photos.mediagallery.launcher.animation.DrawingRule;
import com.facebook.widget.CustomViewUtils;
import javax.annotation.Nullable;

/* compiled from: links_impression */
public class GlClippingImageView extends ClippingImageView {
    private static final String f10131c = GlClippingImageView.class.getSimpleName();
    private View f10132d;
    private FrameLayout f10133e;
    private boolean f10134f;

    public GlClippingImageView(Context context) {
        super(context);
    }

    public GlClippingImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public GlClippingImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @TargetApi(11)
    protected final void mo555a() {
        super.mo555a();
        this.f10132d = new ImageView(getContext());
        this.f10133e = new FrameLayout(getContext());
        this.f10133e.addView(this.f10132d);
        addView(this.f10133e, new LayoutParams(-1, -1));
        this.f10132d.setVisibility(4);
        this.f10133e.setPivotX(0.0f);
        this.f10133e.setPivotY(0.0f);
    }

    @TargetApi(11)
    protected final void mo556a(Drawable drawable) {
        CustomViewUtils.b(this.f10132d, drawable);
    }

    private static boolean m12006c(DrawingRule drawingRule) {
        float width = ((float) drawingRule.f10720b.width()) / 20.0f;
        float height = ((float) drawingRule.f10720b.height()) / 20.0f;
        return ((float) drawingRule.f10720b.left) - width > ((float) drawingRule.f10719a.left) || ((float) drawingRule.f10720b.top) - height > ((float) drawingRule.f10719a.top) || width + ((float) drawingRule.f10720b.right) < ((float) drawingRule.f10719a.right) || ((float) drawingRule.f10720b.bottom) + height < ((float) drawingRule.f10719a.bottom);
    }

    @TargetApi(11)
    public final void mo557a(DrawingRule drawingRule, DrawingRule drawingRule2) {
        boolean z = this.f10134f;
        boolean z2 = m12006c(drawingRule) || m12006c(drawingRule2);
        this.f10134f = z2;
        Boolean.valueOf(this.f10134f);
        ViewGroup.LayoutParams layoutParams = this.f10132d.getLayoutParams();
        if (this.f10129b == null) {
            return;
        }
        if (z != this.f10134f || layoutParams.width != this.f10129b.getIntrinsicWidth() || layoutParams.height != this.f10129b.getIntrinsicHeight()) {
            this.f10132d.setLayoutParams(new LayoutParams(this.f10129b.getIntrinsicWidth(), this.f10129b.getIntrinsicHeight()));
            if (this.f10134f) {
                this.f10133e.setLayoutParams(new LayoutParams(this.f10129b.getIntrinsicWidth(), this.f10129b.getIntrinsicHeight()));
            } else {
                this.f10133e.setLayoutParams(new LayoutParams(-1, -1));
            }
            this.f10133e.setScaleX(1.0f);
            this.f10133e.setScaleY(1.0f);
            this.f10132d.setScaleX(1.0f);
            this.f10132d.setScaleY(1.0f);
            this.f10133e.setTranslationX(0.0f);
            this.f10133e.setTranslationY(0.0f);
            this.f10132d.setTranslationX(0.0f);
            this.f10132d.setTranslationY(0.0f);
            this.f10132d.setPivotX(0.0f);
            this.f10132d.setPivotY(0.0f);
        }
    }

    @TargetApi(11)
    protected final void mo558b(@Nullable DrawingRule drawingRule) {
        super.mo558b(drawingRule);
        float intrinsicWidth = (float) this.f10129b.getIntrinsicWidth();
        float intrinsicHeight = (float) this.f10129b.getIntrinsicHeight();
        float height;
        if (this.f10134f) {
            this.f10133e.setTranslationX((float) this.f10128a.f10720b.left);
            this.f10133e.setTranslationY((float) this.f10128a.f10720b.top);
            this.f10133e.setScaleX(((float) this.f10128a.f10720b.width()) / intrinsicWidth);
            this.f10133e.setScaleY(((float) this.f10128a.f10720b.height()) / intrinsicHeight);
            float width = (((float) (this.f10128a.f10720b.left - this.f10128a.f10719a.left)) * intrinsicWidth) / ((float) this.f10128a.f10719a.width());
            height = (((float) (this.f10128a.f10720b.top - this.f10128a.f10719a.top)) * intrinsicHeight) / ((float) this.f10128a.f10719a.height());
            this.f10132d.setTranslationX(-width);
            this.f10132d.setTranslationY(-height);
            this.f10132d.setPivotX(width);
            this.f10132d.setPivotY(height);
            this.f10132d.setScaleX((((float) this.f10128a.f10719a.width()) / intrinsicWidth) / this.f10133e.getScaleX());
            this.f10132d.setScaleY((((float) this.f10128a.f10719a.height()) / intrinsicHeight) / this.f10133e.getScaleY());
        } else {
            height = (float) this.f10128a.f10719a.top;
            intrinsicWidth = ((float) this.f10128a.f10719a.width()) / intrinsicWidth;
            intrinsicHeight = ((float) this.f10128a.f10719a.height()) / intrinsicHeight;
            this.f10132d.setTranslationX((float) this.f10128a.f10719a.left);
            this.f10132d.setTranslationY(height);
            this.f10132d.setScaleX(intrinsicWidth);
            this.f10132d.setScaleY(intrinsicHeight);
        }
        this.f10132d.setVisibility(0);
    }
}

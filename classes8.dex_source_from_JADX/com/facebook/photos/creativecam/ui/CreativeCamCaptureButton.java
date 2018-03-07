package com.facebook.photos.creativecam.ui;

import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ImageButton;

/* compiled from: state_current_list */
public class CreativeCamCaptureButton extends ImageButton {
    public static int f2191a;
    public static int f2192b;
    public static int f2193c;
    public static int f2194d;
    public Drawable f2195e;
    public Drawable f2196f;
    private LayerDrawable f2197g;

    /* compiled from: state_current_list */
    public enum CaptureType {
        IMAGE,
        VIDEO
    }

    /* compiled from: state_current_list */
    class RecordButtonAnimation extends Animation {
        final /* synthetic */ CreativeCamCaptureButton f2190a;

        public RecordButtonAnimation(CreativeCamCaptureButton creativeCamCaptureButton) {
            this.f2190a = creativeCamCaptureButton;
            setInterpolator(new AccelerateDecelerateInterpolator());
            setDuration((long) creativeCamCaptureButton.getResources().getInteger(17694720));
        }

        protected void applyTransformation(float f, Transformation transformation) {
            int i = (int) ((((float) CreativeCamCaptureButton.f2192b) * f) + (((float) CreativeCamCaptureButton.f2191a) * (1.0f - f)));
            int i2 = (CreativeCamCaptureButton.f2193c * 2) - i;
            int i3 = (int) ((((float) CreativeCamCaptureButton.f2194d) * f) + (((float) CreativeCamCaptureButton.f2193c) * (1.0f - f)));
            int i4 = (CreativeCamCaptureButton.f2193c * 2) - i3;
            this.f2190a.f2195e.setBounds(i, i, i2, i2);
            this.f2190a.f2196f.setBounds(i3, i3, i4, i4);
        }
    }

    public CreativeCamCaptureButton(Context context) {
        super(context);
        m2365g();
    }

    public CreativeCamCaptureButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m2365g();
    }

    public CreativeCamCaptureButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m2365g();
    }

    private void m2365g() {
        f2191a = getResources().getDimensionPixelSize(2131429522);
        f2192b = getResources().getDimensionPixelSize(2131429521);
        f2193c = getResources().getDimensionPixelSize(2131429520) / 2;
        f2194d = getResources().getDimensionPixelSize(2131429527);
        this.f2197g = (LayerDrawable) getBackground();
        this.f2195e = this.f2197g.findDrawableByLayerId(2131568579);
        this.f2196f = this.f2197g.findDrawableByLayerId(2131568580);
        this.f2196f.setAlpha(0);
    }

    public void setCaptureType(CaptureType captureType) {
        if (captureType == CaptureType.IMAGE) {
            this.f2195e.setColorFilter(getResources().getColor(2131362919), Mode.SRC_ATOP);
            this.f2196f.setAlpha(0);
            return;
        }
        this.f2195e.setColorFilter(getResources().getColor(2131362922), Mode.SRC_ATOP);
    }

    public final void m2366a() {
        this.f2196f.setAlpha(255);
        startAnimation(new RecordButtonAnimation(this));
    }

    public final void m2367b() {
        this.f2196f.setAlpha(0);
    }
}

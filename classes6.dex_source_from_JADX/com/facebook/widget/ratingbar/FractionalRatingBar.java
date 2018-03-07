package com.facebook.widget.ratingbar;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.facebook.R;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.base.Preconditions;

/* compiled from: com.google.android.gms.maps.internal.ILocationSourceDelegate */
public class FractionalRatingBar extends CustomLinearLayout {
    private final Drawable f19847a;
    private final Drawable f19848b;
    private final Drawable f19849c;
    private float f19850d;

    public FractionalRatingBar(Context context) {
        this(context, null);
    }

    public FractionalRatingBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f19850d = 0.0f;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FractionalRatingBar);
        Resources resources = context.getResources();
        this.f19847a = m28567a(0, obtainStyledAttributes, resources, 2130843463);
        this.f19848b = m28567a(1, obtainStyledAttributes, resources, 2130843465);
        this.f19849c = m28567a(2, obtainStyledAttributes, resources, 2130843466);
        m28568a();
    }

    public void setRating(float f) {
        boolean z = f >= 0.0f && f <= 5.0f;
        Preconditions.checkArgument(z);
        if (f != this.f19850d) {
            this.f19850d = f;
            double floor = Math.floor(((double) this.f19850d) + 0.25d);
            double ceil = Math.ceil(((double) this.f19850d) - 0.25d);
            for (int i = 0; i < 5; i++) {
                Drawable drawable;
                if (((double) i) < floor) {
                    drawable = this.f19847a;
                } else if (((double) i) >= ceil) {
                    drawable = this.f19849c;
                } else {
                    drawable = this.f19848b;
                }
                ImageView imageView = (ImageView) getChildAt(i);
                if (imageView.getDrawable() != drawable) {
                    imageView.setImageDrawable(drawable);
                }
            }
        }
    }

    private void m28568a() {
        for (int i = 0; i < 5; i++) {
            View imageView = new ImageView(getContext());
            imageView.setImageDrawable(this.f19849c);
            addView(imageView);
        }
    }

    private static Drawable m28567a(int i, TypedArray typedArray, Resources resources, int i2) {
        Drawable drawable = typedArray.getDrawable(i);
        return drawable == null ? resources.getDrawable(i2) : drawable;
    }
}

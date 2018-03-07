package com.facebook.nearby.v2.intent.categorypicker.icons;

import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomViewGroup;

/* compiled from: pending_count */
public class NearbyPlacesCategoryPickerIconView extends CustomViewGroup {
    public FbTextView f5147a;
    public ImageView f5148b;
    public NearbyPlacesCategoryPickerIconType f5149c;

    public NearbyPlacesCategoryPickerIconView(String str, Drawable drawable, int i, NearbyPlacesCategoryPickerIconType nearbyPlacesCategoryPickerIconType, Context context) {
        this(context);
        this.f5149c = nearbyPlacesCategoryPickerIconType;
        this.f5147a.setText(str);
        if (this.f5148b.getBackground() == null) {
            this.f5148b.setBackgroundResource(2130841602);
        }
        this.f5148b.getBackground().setColorFilter(i, Mode.MULTIPLY);
        this.f5148b.setImageDrawable(drawable);
    }

    private NearbyPlacesCategoryPickerIconView(Context context) {
        this(context, null);
    }

    private NearbyPlacesCategoryPickerIconView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private NearbyPlacesCategoryPickerIconView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5149c = NearbyPlacesCategoryPickerIconType.INVALID;
        setContentView(2130905390);
        this.f5148b = (ImageView) findViewById(2131564107);
        this.f5147a = (FbTextView) findViewById(2131564108);
    }
}

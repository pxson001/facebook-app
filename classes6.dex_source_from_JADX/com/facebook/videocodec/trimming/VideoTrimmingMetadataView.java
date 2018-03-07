package com.facebook.videocodec.trimming;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;
import com.facebook.R;
import com.facebook.widget.CustomLinearLayout;

/* compiled from: com.google.android.gms.maps.internal.IOnMapReadyCallback */
public class VideoTrimmingMetadataView extends CustomLinearLayout {
    private TextView f19765a;
    private TextView f19766b;
    private TextView f19767c;

    public VideoTrimmingMetadataView(Context context) {
        super(context);
        m28495a(context, null, 0);
    }

    public VideoTrimmingMetadataView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m28495a(context, attributeSet, 0);
    }

    protected VideoTrimmingMetadataView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m28495a(context, attributeSet, i);
    }

    private void m28495a(Context context, AttributeSet attributeSet, int i) {
        setOrientation(1);
        setContentView(2130907705);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.VideoTrimmingMetadataView, i, 0);
        CharSequence string = obtainStyledAttributes.getString(0);
        int color = obtainStyledAttributes.getColor(1, -1);
        int color2 = obtainStyledAttributes.getColor(2, -1);
        this.f19765a = (TextView) a(2131568407);
        this.f19765a.setTextColor(color);
        this.f19766b = (TextView) a(2131568408);
        this.f19766b.setTextColor(color2);
        this.f19767c = (TextView) a(2131568409);
        this.f19767c.setTextColor(color2);
        this.f19765a.setText(string);
        obtainStyledAttributes.recycle();
    }

    public void setDurationString(String str) {
        this.f19766b.setText(str);
    }

    public void setSizeString(String str) {
        this.f19767c.setText(str);
    }
}

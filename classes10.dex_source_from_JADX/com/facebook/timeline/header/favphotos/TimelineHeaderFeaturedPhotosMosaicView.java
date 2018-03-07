package com.facebook.timeline.header.favphotos;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.widget.mosaic.MosaicGridLayout;
import com.facebook.widget.recyclerview.keepattached.RecyclerViewKeepAttached;

/* compiled from: fetch_suggested_photos */
public class TimelineHeaderFeaturedPhotosMosaicView extends MosaicGridLayout implements RecyclerViewKeepAttached {
    public TimelineHeaderFeaturedPhotosMosaicView(Context context) {
        super(context);
        m11836a();
    }

    public TimelineHeaderFeaturedPhotosMosaicView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m11836a();
    }

    public TimelineHeaderFeaturedPhotosMosaicView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m11836a();
    }

    private void m11836a() {
        this.f11738c = true;
        int dimensionPixelSize = getResources().getDimensionPixelSize(2131429961);
        m11835b(dimensionPixelSize, dimensionPixelSize);
    }

    public final boolean gK_() {
        return true;
    }
}

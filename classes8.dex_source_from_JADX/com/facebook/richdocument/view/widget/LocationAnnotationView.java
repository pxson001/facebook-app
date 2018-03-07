package com.facebook.richdocument.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.facebook.richdocument.model.block.LocationAnnotation;
import javax.annotation.Nullable;

/* compiled from: onDestoryView  */
public class LocationAnnotationView extends TextAnnotationView<LocationAnnotation> {
    public LocationAnnotationView(Context context) {
        super(context);
        m7492e();
    }

    public LocationAnnotationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m7492e();
    }

    public LocationAnnotationView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m7492e();
    }

    private void m7492e() {
        m7401a(2130843053, 2131558711, 2131558712);
        setDrawablePaddingResource(2131431826);
    }

    public static LocationAnnotationView m7491a(Context context, ViewGroup viewGroup, LocationAnnotation locationAnnotation) {
        LocationAnnotationView locationAnnotationView = (LocationAnnotationView) LayoutInflater.from(context).inflate(2130906875, viewGroup, false);
        locationAnnotationView.setAnnotation(locationAnnotation);
        return locationAnnotationView;
    }
}

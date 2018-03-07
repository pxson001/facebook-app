package com.facebook.view.inflation.inflaters;

import android.content.Context;
import android.view.View;
import android.widget.ImageButton;
import com.facebook.view.inflation.utils.ParseUtils;
import com.facebook.view.inflation.utils.ViewIdentifier;

/* compiled from: location_opt_in_notifications_turned_on */
public class ImageButtonInflater extends ImageViewInflater {
    public ImageButtonInflater(ParseUtils parseUtils, ViewIdentifier viewIdentifier) {
        super(parseUtils, viewIdentifier);
    }

    protected final View mo623a(Context context) {
        return new ImageButton(context);
    }
}

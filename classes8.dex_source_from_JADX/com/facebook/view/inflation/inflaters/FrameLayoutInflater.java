package com.facebook.view.inflation.inflaters;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.facebook.view.inflation.utils.ParseUtils;
import com.facebook.view.inflation.utils.ViewIdentifier;

/* compiled from: location_opt_in_place_save_banner_learn_more_tapped */
public class FrameLayoutInflater extends ViewGroupInflater {
    public FrameLayoutInflater(ParseUtils parseUtils, ViewIdentifier viewIdentifier) {
        super(parseUtils, viewIdentifier);
    }

    protected View mo623a(Context context) {
        return new FrameLayout(context);
    }

    protected void mo624a(View view, String str, String str2, Context context) {
        throw new IllegalArgumentException("unknown attribute for FrameLayout = " + str);
    }
}

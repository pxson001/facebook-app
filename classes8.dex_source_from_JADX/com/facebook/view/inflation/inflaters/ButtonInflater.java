package com.facebook.view.inflation.inflaters;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import com.facebook.view.inflation.utils.ParseUtils;
import com.facebook.view.inflation.utils.ViewIdentifier;

/* compiled from: location_opt_in_place_save_intro_get_started_tapped */
public class ButtonInflater extends TextViewInflater {
    public ButtonInflater(ParseUtils parseUtils, ViewIdentifier viewIdentifier) {
        super(parseUtils, viewIdentifier);
    }

    protected final View mo623a(Context context) {
        return new Button(context);
    }
}

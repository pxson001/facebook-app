package com.facebook.view.inflation.inflaters;

import android.content.Context;
import android.view.View;
import com.facebook.view.inflation.utils.ParseUtils;
import com.facebook.view.inflation.utils.ViewIdentifier;

/* compiled from: location_opt_in_lh_notification_turn_on_tapped */
public class ViewInflaterImpl extends ViewInflater {
    public ViewInflaterImpl(ParseUtils parseUtils, ViewIdentifier viewIdentifier) {
        super(parseUtils, viewIdentifier);
    }

    protected final View mo623a(Context context) {
        return new View(context);
    }

    protected final void mo624a(View view, String str, String str2, Context context) {
        throw new IllegalArgumentException("unknown view attribute = " + str);
    }
}

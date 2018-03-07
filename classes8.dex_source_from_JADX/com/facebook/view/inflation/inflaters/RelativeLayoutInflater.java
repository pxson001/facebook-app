package com.facebook.view.inflation.inflaters;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import com.facebook.view.inflation.utils.ParseUtils;
import com.facebook.view.inflation.utils.ViewIdentifier;

/* compiled from: location_opt_in_location_permission_req_canceled */
class RelativeLayoutInflater extends ViewGroupInflater {
    public RelativeLayoutInflater(ParseUtils parseUtils, ViewIdentifier viewIdentifier) {
        super(parseUtils, viewIdentifier);
    }

    protected final View mo623a(Context context) {
        return new RelativeLayout(context);
    }

    protected final void mo624a(View view, String str, String str2, Context context) {
        throw new IllegalArgumentException("unknown relative layout attribute = " + str);
    }
}

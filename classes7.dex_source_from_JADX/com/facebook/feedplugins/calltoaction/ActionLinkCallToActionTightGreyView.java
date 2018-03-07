package com.facebook.feedplugins.calltoaction;

import android.content.Context;
import android.widget.TextView;
import com.facebook.widget.CustomViewUtils;

/* compiled from: SuggestEditsSectionsQuery */
public class ActionLinkCallToActionTightGreyView extends ActionLinkCallToActionView {
    public ActionLinkCallToActionTightGreyView(Context context) {
        super(context);
        setBackgroundColor(context.getResources().getColor(2131363658));
        CustomViewUtils.a((TextView) findViewById(2131559195), context.getResources().getDrawable(2130837927));
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(2131427642);
        setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
    }
}
